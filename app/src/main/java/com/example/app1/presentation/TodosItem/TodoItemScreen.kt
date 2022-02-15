package com.example.app1.presentation.TodosItem

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.app1.presentation.ui.theme.SoftBlack

@Composable
fun TodoItemScreen(
    viewModel: TodoItemViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Log.d("ItemScreen", state.data.toString())

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(SoftBlack)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            backgroundColor = Color.Black,
            elevation = 10.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            state.data?.let { item ->
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${item.userId}. ",
                            color = Color.White,
                            style = MaterialTheme.typography.body1,
                            fontSize = 20.sp
                        )
                        Text(
                            text = if (item.completed) "complete" else "incomplete",
                            color = if (item.completed) Color.Green else Color.Red,
                            textAlign = TextAlign.End,
                            style = MaterialTheme.typography.body1,
                            fontSize = 20.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = item.title,
                        color = Color.White,
                        style = MaterialTheme.typography.body2,
                        fontSize = 15.sp
                    )
                }
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
}