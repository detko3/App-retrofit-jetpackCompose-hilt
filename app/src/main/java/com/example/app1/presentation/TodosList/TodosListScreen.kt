package com.example.app1

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.app1.presentation.TodosList.TodosListViewModel
import com.example.app1.presentation.TodosList.components.TodoListItem

@Composable
fun TodosListScreen(
    navController: NavController,
    viewModel: TodosListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
   Box(modifier = Modifier.fillMaxSize()) {
       LazyColumn(modifier = Modifier
           .fillMaxSize()
           .background(color = Color.Black)) {
           items(state.data) { item ->
               TodoListItem(item = item, onClick = {
                   navController.navigate("todoItem/${item.id}")
               } )
           }
       }
       if(state.error.isNotBlank()) {
           Text(
               text = state.error,
               color = MaterialTheme.colors.error,
               textAlign = TextAlign.Center,
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(horizontal = 20.dp)
                   .align(Alignment.Center)
           )
       }
       if(state.isLoading) {
           CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
       }
   }

    
    
    
//    Log.d("HERE", viewModel.state.value.data.toString())
//    Button(onClick = { navController.navigate("profile") }) {
//        Text(text = "Navigate next 2")
//    }
    /*...*/
}
