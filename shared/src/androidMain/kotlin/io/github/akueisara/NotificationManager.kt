package io.github.akueisara

import android.content.Context
import kotlinx.datetime.Instant

actual class NotificationManager(
    private val context: Context,
) {
    actual fun schedule(alarmName: String, time: Instant) {
    }

    actual fun cancel(alarmName: String) {
    }

}