package io.github.akueisara.alarm

import kotlinx.datetime.Instant

internal actual class AlarmNotificationManager {
    actual fun schedule(alarmId: Long, alarmName: String, time: Instant) {
    }

    actual fun cancel(alarmId: Long) {
    }
}