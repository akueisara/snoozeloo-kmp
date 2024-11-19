package io.github.akueisara.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.AlarmManagerCompat
import kotlinx.datetime.Instant

internal actual class AlarmNotificationManager(
    private val context: Context,
) {
    private val alarmManager: AlarmManager? by lazy { context.getSystemService(Context.ALARM_SERVICE) as? AlarmManager }

    actual fun schedule(alarmId: Long, alarmName: String, time: Instant) {
        alarmManager?.let { alarmManager ->
            val type = AlarmManager.RTC_WAKEUP
            val alarmIntent = Intent(context, AlarmReceiver::class.java)
                .createPendingIntent(context, alarmId.toInt())
            AlarmManagerCompat.setExactAndAllowWhileIdle(
                alarmManager,
                type,
                time.toEpochMilliseconds(),
                alarmIntent
            )
        }
    }

    actual fun cancel(alarmId: Long) {
        val alarmIntent = Intent(context, AlarmReceiver::class.java)
            .createPendingIntent(context, alarmId.toInt())
        alarmManager?.cancel(alarmIntent)
    }
}

private fun Intent.createPendingIntent(context: Context, id: Int) = PendingIntent.getBroadcast(
    context,
    id,
    this,
    PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
)