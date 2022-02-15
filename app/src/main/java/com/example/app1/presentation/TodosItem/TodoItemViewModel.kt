package com.example.app1.presentation.TodosItem

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app1.common.Resource
import com.example.app1.data.useCase.GetTodoUseCase
import com.example.app1.presentation.TodosList.TodosListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TodoItemViewModel @Inject constructor(
    private val getTodoUseCase: GetTodoUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val _state = mutableStateOf(TodoItemState())
    val state: State<TodoItemState> = _state

    init {
        savedStateHandle.get<String>("id")?.let { id ->
//            Log.d("ITEM", id)
            getTodoById(id.toInt())
        }
    }

    fun getTodoById(id: Int) {
        getTodoUseCase(id).onEach {
            when(it) {
                is Resource.Success -> {
                    _state.value = TodoItemState(data = it.data)
                }
                is Resource.Loading -> {
                    _state.value = TodoItemState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = TodoItemState(error = it.message?: "some error")
                }
            }
        }.launchIn(viewModelScope)
    }
}