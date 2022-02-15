package com.example.app1.data.useCase

import android.util.Log
import com.example.app1.common.Resource
import com.example.app1.data.dto.Todo
import com.example.app1.data.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTodosListUseCase @Inject constructor(
    private val repository: TodoRepository
) {
    operator fun invoke(): Flow<Resource<List<Todo>>> = flow {
//        Log.d("USE CASE", "started")
        try {
            emit(Resource.Loading<List<Todo>>())
            val response = repository.getTodos()
            if (response.isSuccessful && response.body() != null) {
//                Log.d("USE CASE: ", "Here")
                emit(Resource.Success<List<Todo>>(response.body()!!))
            } else {
                emit(Resource.Error<List<Todo>>("response is null or not succesfull"))
            }
        } catch (e: IOException) {
            emit(Resource.Error<List<Todo>>("Internet error: $e"))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Todo>>("Http error $e"))
        }
    }
}