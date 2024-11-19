package io.github.akueisara

import kotlinx.datetime.Instant

expect class NotificationManager {

    fun schedule(alarmName: String, time: Instant)

    fun cancel(alarmName: String)
}