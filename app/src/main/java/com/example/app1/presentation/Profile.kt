package com.example.app1

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun Profile(navController: NavController) {
    /*...*/

    Button(onClick = { navController.navigate("todoslist") }) {
        Text(text = "Navigate next")
    }
    /*...*/
}
