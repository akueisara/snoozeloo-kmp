package io.github.akueisara.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import io.github.akueisara.ui.utils.Navigation

@Composable
fun App() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    NavHost(
        navController = navController,
        startDestination = Navigation.AlarmList.route,
    ) {
        composable(Navigation.AlarmList.route) {
            AlarmScreen()
        }
    }

}