package com.mvettosi.template.entrypoint.ui.navigation

sealed class Screen(val route: String) {
  object Home : Screen("home_screen")
  object Sample : Screen("sample_screen")
}
