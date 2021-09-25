package com.mvettosi.template.entrypoint.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.mvettosi.template.entrypoint.ui.navigation.Screen

@Composable
fun Home(navController: NavController, viewModel: HomeViewModel) {
  val nameState by viewModel.name.collectAsState()
  Column(
      modifier = Modifier.fillMaxSize(),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.SpaceEvenly) {
    Text(text = "Hello ${nameState ?: "Unknown"}!")
    Button(onClick = { viewModel.refreshName() }) { Text(text = "Load name") }
    Button(onClick = { navController.navigate(Screen.Sample.route) }) { Text(text = "Navigate") }
  }
}
