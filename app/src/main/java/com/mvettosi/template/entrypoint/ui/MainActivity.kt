package com.mvettosi.template.entrypoint.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mvettosi.template.entrypoint.ui.home.HomeViewModel
import com.mvettosi.template.entrypoint.ui.theme.TempTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      TempTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) { Greeting("_") }
      }
    }
  }
}

@Composable
fun Greeting(defaultName: String, viewModel: HomeViewModel = viewModel()) {
  val nameState by viewModel.name.collectAsState(initial = defaultName)
  Column(
      modifier = Modifier.fillMaxSize(),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.SpaceEvenly) {
    Text(text = "Hello $nameState!")
    Button(onClick = { viewModel.refreshName() }) { Text(text = "Load name") }
  }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  TempTheme { Greeting("Android") }
}
