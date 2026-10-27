data class Student(var name: String, var marks: Int)

fun main() {
    val students =
            listOf(
                    Student("Alam", 87),
                    Student("Alam1", 90),
                    Student("Alam2", 67),
                    Student("Alam3", 87),
                    Student("Alam4", 29),
                    Student("Alam5", 98),
                    Student("Alam6", 83),
            )

    val sorted = students.sortedByDescending { it.marks }
    println("Sorted Marks: $sorted")

    val topper = sorted.first()
    println("topper: $topper")
}
