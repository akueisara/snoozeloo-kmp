package io.github.akueisara.alarm

import co.touchlab.kermit.Logger
import kotlinx.datetime.Instant
import platform.Foundation.NSDate
import platform.Foundation.dateWithTimeIntervalSince1970
import platform.Foundation.timeIntervalSince1970
import platform.UserNotifications.UNMutableNotificationContent
import platform.UserNotifications.UNNotificationRequest
import platform.UserNotifications.UNNotificationSound
import platform.UserNotifications.UNTimeIntervalNotificationTrigger
import platform.UserNotifications.UNUserNotificationCenter

internal actual class AlarmNotificationManager {

    private val notificationCenter by lazy { UNUserNotificationCenter.currentNotificationCenter() }

    actual fun schedule(id: Long, name: String, time: Instant) {
        val content = UNMutableNotificationContent().apply {
            setTitle(name)
            setSound(UNNotificationSound.defaultSound)
        }

        val nsDate = NSDate.dateWithTimeIntervalSince1970(time.toEpochMilliseconds() / 1000.0)
        val trigger = UNTimeIntervalNotificationTrigger.triggerWithTimeInterval(
            timeInterval = nsDate.timeIntervalSince1970,
            repeats = false
        )
        val request = UNNotificationRequest.requestWithIdentifier(
            identifier = id.toString(),
            content = content,
            trigger = trigger,
        )

        notificationCenter.addNotificationRequest(request) { error ->
            if (error != null) {
                Logger.e { "Error scheduling alarm: $error" }
            }
        }
    }

    actual fun cancel(id: Long) {
        Logger.d { "Canceling alarm with id $id" }
        notificationCenter.removePendingNotificationRequestsWithIdentifiers(listOf(id.toString()))
    }
}