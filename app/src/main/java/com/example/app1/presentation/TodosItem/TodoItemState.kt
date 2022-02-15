package com.example.app1.presentation.TodosItem

import com.example.app1.data.dto.Todo

data class TodoItemState(
    val isLoading: Boolean = false,
    val data: Todo? = null,
    val error: String = ""
)
