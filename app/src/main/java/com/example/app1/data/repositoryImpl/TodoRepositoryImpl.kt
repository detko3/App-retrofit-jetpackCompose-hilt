package com.example.app1.data.repositoryImpl

import android.util.Log
import com.example.app1.data.dto.Todo
import com.example.app1.data.remote.TodosApi
import com.example.app1.data.repository.TodoRepository
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(
    private val api: TodosApi
): TodoRepository {

    override suspend fun getTodos(): Response<List<Todo>> {
        return api.getTodos()
    }

    override suspend fun getTodoById(id: Int): Response<Todo> {
        return api.getTodoById(id)
    }
}