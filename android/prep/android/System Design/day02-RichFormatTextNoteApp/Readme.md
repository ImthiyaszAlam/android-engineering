
```markdown
# 📘 DA2.md – Day 2: Clean Architecture with UseCases, Repository & ViewModel

## 🧩 Prompt: Rich Text Notes App

Design a **Notes App** with the following features:
- Add, edit, delete notes
- Rich text formatting (bold, italic, bullet points)
- Save notes locally (Room)
- Share notes (as text)
  
---

## 🏗️ Architecture Diagram (Text-based)

```

```
               +---------------------------+
               |     NotesScreen.kt        |
               |     NoteEditorScreen.kt   |
               +---------------------------+
                         ⬇️
               +---------------------------+
               |     NotesViewModel.kt     |
               +---------------------------+
                         ⬇️
```

+------------------------+           +--------------------------+
\|  AddNoteUseCase.kt     |           | GetFormattedNoteUseCase.kt|
\|  DeleteNoteUseCase.kt  |           |      ShareNoteUseCase.kt  |
+------------------------+           +--------------------------+
⬇️                          ⬇️
+----------------------------+
\|     NotesRepository.kt     |
+----------------------------+
⬇️
+----------------------------------------+
\| NotesRepositoryImpl.kt (Room + Mapper) |
+----------------------------------------+
⬇️
+------------------+           +------------------+
\|   NoteDao.kt     | <-------> |   NoteEntity.kt  |
+------------------+           +------------------+

````

---

## 📦 Domain Layer

### `Note.kt`
```kotlin
data class Note(
    val id: Int = 0,
    val title: String,
    val content: String,
    val createdAt: Long,
    val isBold: Boolean,
    val isItalic: Boolean,
    val bulletPoints: List<String> = emptyList()
)
````

---

### `NotesRepository.kt`

```kotlin
interface NotesRepository {
    suspend fun addNote(note: Note): Result<Unit>
    suspend fun deleteNote(id: Int): Result<Unit>
    suspend fun getAllNotes(): Result<List<Note>>
    suspend fun getNoteById(id: Int): Result<Note>
}
```

---

### `AddNoteUseCase.kt`

```kotlin
class AddNoteUseCase(private val repo: NotesRepository) {
    suspend operator fun invoke(note: Note): Result<Unit> = repo.addNote(note)
}
```

---

### `ShareNoteUseCase.kt`

```kotlin
class ShareNoteUseCase(private val repo: NotesRepository) {
    suspend operator fun invoke(noteId: Int): String {
        val note = repo.getNoteById(noteId).getOrNull()
        return note?.let {
            buildString {
                append("Title: ${it.title}\n")
                append("Content: ${it.content}\n")
                if (it.isBold) append("**Bold**\n")
                if (it.isItalic) append("_Italic_\n")
                append("Bullets:\n")
                it.bulletPoints.forEach { point -> append("• $point\n") }
            }
        } ?: "Note not found"
    }
}
```

---

## 🎯 Your Practice Tasks

* [ ] Write a `NotesViewModel` using `StateFlow` for managing UI state
* [ ] Implement `NoteEntity`, `NoteDao`, and mapping logic between `NoteEntity` and `Note`
* [ ] Create a fake `NotesRepositoryImpl` to simulate Room behavior (for testing UseCases)

---

## ❓ Interviewer-style Questions

### 1. What if user shares a note, but Room fetch fails?

* Catch and log the error using Crashlytics or custom logger
* Show fallback message: *"Note unavailable, please retry."*
* Retry logic or fallback to last cached note (if available)

---

### 2. Why not use `NoteEntity` everywhere?

* **Entity = DB representation**
* **Domain model = Clean, platform-independent**
* Keeping them separate:

  * Makes testing easier
  * Keeps DB concerns out of business logic
  * Allows changing data sources (e.g., from Room to Firestore)

---

### 3. How would `NotesRepository` change if Cloud Sync is added?

* Add multiple data sources:

  ```kotlin
  interface NotesRepository {
      suspend fun syncNoteToCloud(note: Note): Result<Unit>
  }
  ```
* Use a **LocalDataSource** and **RemoteDataSource** inside RepositoryImpl
* Sync flow: Save locally → enqueue for sync → retry on fail → success = mark synced

---

### 4. What’s wrong with using Room directly in ViewModel?

* Tightly couples database with UI
* Breaks testability
* No clean separation between layers
* Makes swapping data sources harder

---

### 5. How to write a unit test for `AddNoteUseCase`?

```kotlin
@Test
fun `test add note returns success`() = runTest {
    val fakeRepo = FakeNotesRepository()
    val useCase = AddNoteUseCase(fakeRepo)
    val note = Note(1, "Test", "Body", 0L, false, false)

    val result = useCase(note)

    assert(result.isSuccess)
}
```

---

## 🧪 Debugging Challenge

**Bug:** Notes reopen without formatting (bold/italic missing)

**Causes:**

* `NoteEntity` might not persist boolean flags
* `Mapper` might ignore isBold/isItalic
* Room column type mismatch (e.g., using `Int` instead of `Boolean`)
* Wrong deserialization of bullet points

**Fix:**

* Add unit tests for mapper logic
* Verify Room schema
* Log every insert & fetch with full data

---

## 🧠 Summary

| Topic                        | Covered |
| ---------------------------- | ------- |
| UseCase + Repository         | ✅ Yes   |
| Room Setup + Mapper          | ✅ Yes   |
| Compose + ViewModel Planning | ✅ Yes   |
| Interview Questions Practice | ✅ Yes   |
| Debugging Scenario           | ✅ Yes   |

