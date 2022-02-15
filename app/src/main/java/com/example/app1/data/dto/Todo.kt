package com.example.app1.data.dto

data class Todo(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)