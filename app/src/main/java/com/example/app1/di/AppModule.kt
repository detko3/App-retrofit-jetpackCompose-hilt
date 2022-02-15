package com.example.app1.di

import com.example.app1.data.remote.TodosApi
import com.example.app1.data.repository.TodoRepository
import com.example.app1.data.repositoryImpl.TodoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTodosApi(): TodosApi {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TodosApi::class.java)
    }

    @Provides
    @Singleton
    fun provideTodosRepository(api: TodosApi): TodoRepository {
        return TodoRepositoryImpl(api)
    }
}