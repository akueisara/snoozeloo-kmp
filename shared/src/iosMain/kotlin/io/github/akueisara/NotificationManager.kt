package io.github.akueisara

import kotlinx.datetime.Instant

actual class NotificationManager {
    actual fun schedule(alarmName: String, time: Instant) {

    }

    actual fun cancel(alarmName: String) {
    }
}