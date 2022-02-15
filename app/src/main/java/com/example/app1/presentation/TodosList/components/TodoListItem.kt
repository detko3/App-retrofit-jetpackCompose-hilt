package com.example.app1.presentation.TodosList.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.app1.data.dto.Todo

@Composable
fun TodoListItem(
    item: Todo,
    onClick: (Todo) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
//            .background(Color.White)
            .clickable { onClick(item) }
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "(${item.userId}) ${item.title}",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier.width(250.dp),
            color = Color.White
        )
//        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = if (item.completed) "complete" else "incomplete",
            color = if (item.completed) Color.Green else Color.Red,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.align(CenterVertically),
            maxLines = 1
        )
    }

}