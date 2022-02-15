package com.example.app1.presentation.TodosList

import com.example.app1.data.dto.Todo

data class TodosListState(
    val isLoading: Boolean = false,
    val data: List<Todo> = emptyList(),
    val error: String = ""
)
