package com.example.app1.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app1.Profile
import com.example.app1.TodosListScreen
import com.example.app1.presentation.TodosItem.TodoItemScreen
import com.example.app1.presentation.TodosList.TodosListViewModel
import com.example.app1.presentation.ui.theme.App1Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

//    private val todosListViewModel: TodosListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "todoslist") {
                        composable("todoItem/{id}") { TodoItemScreen() }
                        composable("todoslist") { TodosListScreen(navController) }
                        /*...*/
                    }

                }
            }
        }
    }
}
