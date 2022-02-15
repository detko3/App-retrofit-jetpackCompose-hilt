package com.example.app1.data.useCase

import com.example.app1.common.Resource
import com.example.app1.data.dto.Todo
import com.example.app1.data.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTodoUseCase @Inject constructor(
    private val repository: TodoRepository
) {
    operator fun invoke(id: Int): Flow<Resource<Todo>> = flow {
        try {
            emit(Resource.Loading<Todo>())
            val response = repository.getTodoById(id)
            if (response.isSuccessful && response.body() != null) {
                emit(Resource.Success<Todo>(response.body()!!))
            } else {
                emit(Resource.Error<Todo>("response is null or not succesfull"))
            }
        } catch (e: IOException) {
            emit(Resource.Error<Todo>("Internet error: $e"))
        } catch (e: HttpException) {
            emit(Resource.Error<Todo>("Http error $e"))
        }
    }
}