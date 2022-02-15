package com.example.app1.data.repository

import com.example.app1.data.dto.Todo
import retrofit2.Response

interface TodoRepository {

    suspend fun getTodos(): Response<List<Todo>>

    suspend fun getTodoById(id: Int): Response<Todo>
}