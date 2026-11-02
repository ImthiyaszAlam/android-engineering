package com.imthiyas.userdirectory.data

import com.imthiyas.userdirectory.model.User

class UserRepository() {

    private val users = listOf(
        User(1, "Aarav Sharma", "Android Developer", 85000.0),
        User(2, "Priya Verma", "Frontend Developer", 75000.0),
        User(3, "Rahul Mehta", "Backend Developer", 95000.0),
        User(4, "Ananya Singh", "UI/UX Designer", 65000.0),
        User(5, "Vikram Patel", "QA Engineer", 60000.0),
        User(6, "Sneha Kapoor", "Product Manager", 120000.0),
        User(7, "Arjun Reddy", "Full Stack Developer", 90000.0),
        User(8, "Neha Gupta", "Data Analyst", 70000.0),
        User(9, "Karan Malhotra", "DevOps Engineer", 100000.0),
        User(10, "Meera Nair", "iOS Developer", 88000.0),
        User(11, "Rohan Das", "Software Engineer", 80000.0),
        User(12, "Ishita Joshi", "Business Analyst", 72000.0),
        User(13, "Aditya Kumar", "Data Scientist", 110000.0),
        User(14, "Kavya Iyer", "HR Manager", 68000.0),
        User(15, "Siddharth Rao", "Cloud Engineer", 105000.0),
        User(16, "Pooja Mishra", "Technical Writer", 55000.0),
        User(17, "Nikhil Jain", "Security Engineer", 98000.0),
        User(18, "Divya Menon", "Scrum Master", 115000.0),
        User(19, "Manish Yadav", "Junior Android Developer", 35000.0),
        User(20, "Simran Kaur", "Automation Test Engineer", 78000.0)
    )


    fun getUsers(): List<User> {
        return users
    }


}