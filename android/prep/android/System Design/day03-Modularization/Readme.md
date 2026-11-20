Here’s your complete **Day 3 `.md` file** for **System Design for Android – Modular Cart Feature Design**, formatted for GitHub or Notion.

---

```markdown
# 📅 Day 3 – Modularization & Layered Cart Design (30 Days of Android System Design)

## 🧠 Goals
- Learn how to **modularize feature layers**
- Understand when **Clean Architecture is overkill**
- Practice designing a real-world **Cart Feature** (like Swiggy/Flipkart)
- Push architectural boundaries with multi-module, reusable components

---

## 🧩 Prompt: Design a Cart Feature for a Food Delivery App

> Users can:
> - Add/Remove items
> - Update item quantity
> - Apply promo codes
> - View total price & delivery fee

---

## 🏗️ Suggested Modular Structure

```

🔸 App Module (entry point)
│
├── \:feature\:cart
│     ├── CartScreen.kt
│     ├── CartViewModel.kt
│     └── di/CartModule.kt
│
├── \:domain\:cart
│     ├── model/CartItem.kt
│     ├── usecase/AddItemToCartUseCase.kt
│     └── repository/CartRepository.kt
│
├── \:data\:cart
│     ├── CartRepositoryImpl.kt
│     ├── local/CartDao.kt
│     └── model/CartEntity.kt
│
├── \:core\:network
├── \:core\:database
├── \:core\:utils

````

---

## ✅ Interfaces

### `CartItem.kt` (Domain Model)
```kotlin
data class CartItem(
    val id: String,
    val name: String,
    val price: Double,
    val quantity: Int,
    val imageUrl: String
)
````

### `CartRepository.kt`

```kotlin
interface CartRepository {
    suspend fun addItem(item: CartItem): Result<Unit>
    suspend fun removeItem(id: String): Result<Unit>
    suspend fun updateQuantity(id: String, quantity: Int): Result<Unit>
    suspend fun getCartItems(): Result<List<CartItem>>
}
```

### `AddItemToCartUseCase.kt`

```kotlin
class AddItemToCartUseCase(private val repo: CartRepository) {
    suspend operator fun invoke(item: CartItem): Result<Unit> {
        return repo.addItem(item)
    }
}
```

### `CartViewModel.kt`

```kotlin
class CartViewModel(
    private val addItemToCartUseCase: AddItemToCartUseCase,
    private val getCartItemsUseCase: GetCartItemsUseCase
) : ViewModel() {

    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems: StateFlow<List<CartItem>> = _cartItems

    fun loadCart() {
        viewModelScope.launch {
            val result = getCartItemsUseCase()
            result.onSuccess { _cartItems.value = it }
        }
    }

    fun addItem(item: CartItem) {
        viewModelScope.launch {
            addItemToCartUseCase(item)
            loadCart()
        }
    }
}
```

---

## ❓ Interviewer-style Questions (with Sample Answers)

### 1. Why modularize Cart?

> Cart logic is often **state-heavy** and isolated. Modularizing allows:

* Parallel team development
* Faster builds
* Reuse in other modules (e.g., Grocery, Medicine, etc.)

Modularization becomes overkill only if the feature is **static, rarely touched**, or handled by one developer.

---

### 2. What if Room fails to update quantity?

* Wrap in `try-catch` and return `Result.failure()`
* Show a fallback UX: “Couldn’t update, try again”
* Use optimistic updates in UI, then rollback if DB fails

---

### 3. How to support Grocery Cart + Food Cart?

> Refactor repository to support **Cart Types**:

```kotlin
enum class CartType { FOOD, GROCERY }

interface CartRepository {
    suspend fun getCartItems(type: CartType): Result<List<CartItem>>
    ...
}
```

Split DB tables or add `cart_type` column in Room.

---

## 🐞 Debugging Scenario

### ❓Problem:

User updates quantity to `3`, but UI shows `2`.
Room DB shows correct `3`.

### 🧠 Diagnosis:

* Race condition: UI is showing stale state
* You forgot to **collect latest Flow** from Room
* Or local cache in ViewModel wasn’t updated

### 🛠 Fix:

```kotlin
viewModelScope.launch {
    cartRepository.getCartItems().collectLatest {
        _cartItems.value = it
    }
}
```

---

## 🔥 Pro Tips

| Area            | Recommendation                                      |
| --------------- | --------------------------------------------------- |
| Promo Code      | Use a `PromoManager` in domain layer                |
| Syncing         | Create `CartSyncUseCase` that pushes local → server |
| Total Price     | Expose computed values in ViewModel                 |
| Offline Caching | Cache via Room and retry in background              |

---

## ✅ Summary

| Deliverable                      | Status |
| -------------------------------- | ------ |
| Modular Diagram (text)           | ✅ Done |
| Repository + UseCase + ViewModel | ✅ Done |
| Interview Questions (3+)         | ✅ Done |
| Debugging Bug Scenario           | ✅ Done |

---

## 📦 What’s Next?

### 👉 **Day 4**:

*Caching Strategies*
Design a **Login + Preferences system** using `SharedPreferences`, `DataStore`, and fallback techniques.

---

## 🧠 Reflect:

> “If your Cart breaks, your conversion drops. Design it like money depends on it — because it does.”

---

Let’s connect:
🔗 [Follow on Medium](https://medium.com/@yourprofile)
🔗 [Connect on LinkedIn](https://linkedin.com/in/yourprofile)
🔗 [Read the original 30 System Design Problems](https://www.linkedin.com/feed/update/your-post)

```

---

Let me know if you want this `.md` exported as a downloadable file or want the `.md` for Day 4 when ready!
```
