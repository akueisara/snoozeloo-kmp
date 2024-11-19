package io.github.akueisara.alarm

import kotlinx.datetime.Instant

internal actual class AlarmNotificationManager {
    actual fun schedule(id: Long, name: String, time: Instant) {
    }

    actual fun cancel(id: Long) {
    }
}