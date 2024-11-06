package io.github.akueisara.ui.utils

sealed class Navigation(val route: String) {
    data object AlarmList : Navigation("alarmList")
}