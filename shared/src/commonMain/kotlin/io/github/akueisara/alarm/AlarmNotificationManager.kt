package io.github.akueisara.alarm

import kotlinx.datetime.Instant

internal expect class AlarmNotificationManager {

    fun schedule(alarmId: Long, alarmName: String, time: Instant)

    fun cancel(alarmId: Long)
}