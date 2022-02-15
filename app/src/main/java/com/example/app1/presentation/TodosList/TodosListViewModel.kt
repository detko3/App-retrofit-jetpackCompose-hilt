package com.example.app1.presentation.TodosList

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app1.common.Resource
import com.example.app1.data.dto.Todo
import com.example.app1.data.repository.TodoRepository
import com.example.app1.data.useCase.GetTodosListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodosListViewModel @Inject constructor(
    private val getTodosListUseCase: GetTodosListUseCase
): ViewModel() {

    private val _state = mutableStateOf(TodosListState())
    val state: State<TodosListState> = _state

    init {
        getTodos()
    }

    fun getTodos() {
        getTodosListUseCase().onEach {
            when(it) {
                is Resource.Success -> {
//                    Log.d("VIEWMODEL", "Succes")
                    _state.value = TodosListState(data = it.data?: emptyList())
                }
                is Resource.Loading -> {
//                    Log.d("VIEWMODEL", "Loading")
                    _state.value = TodosListState(isLoading = true)
                }
                is Resource.Error -> {
//                    Log.d("VIEWMODEL", "Error")
                    _state.value = TodosListState(error = it.message?: "some error")
                }
            }
        }.launchIn(viewModelScope)
    }
}