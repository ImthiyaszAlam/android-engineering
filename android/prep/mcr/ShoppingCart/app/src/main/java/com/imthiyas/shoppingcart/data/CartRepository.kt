package com.imthiyas.shoppingcart.data

import com.imthiyas.shoppingcart.model.CartItem
import com.imthiyas.shoppingcart.model.Product
import kotlinx.coroutines.flow.Flow

class CartRepository(
    private val cartDao: CartDao
) {

    val cartItems: Flow<List<CartItem>> = cartDao.getCartItems()

    suspend fun addToCart(product: Product) {
        cartDao.addToCart(
            CartItem(
                productId = product.id,
                productName = product.name,
                pricePaise = product.pricePaise,
                quantity = 1
            )
        )
    }

    suspend fun changeQuantity(id: Int, delta: Int) {
        cartDao.changeQuantity(id, delta)
    }

    suspend fun removeItem(id: Int) {
        cartDao.deleteItem(id)
    }

}