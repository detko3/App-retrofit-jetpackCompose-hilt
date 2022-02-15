package com.example.app1.data.remote

import com.example.app1.data.dto.Todo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TodosApi {

    @GET("/todos")
    suspend fun getTodos(): Response<List<Todo>>

    @GET("/todos/{id}")
    suspend fun getTodoById(@Path("id") id: Int): Response<Todo>
}