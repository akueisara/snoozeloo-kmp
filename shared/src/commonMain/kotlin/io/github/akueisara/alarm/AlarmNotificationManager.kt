package io.github.akueisara.alarm

import kotlinx.datetime.Instant

internal expect class AlarmNotificationManager {

    fun schedule(id: Long, name: String, time: Instant)

    fun cancel(id: Long)
}