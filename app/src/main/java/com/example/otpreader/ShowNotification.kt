package com.example.otpreader

import androidx.core.app.NotificationCompat
import android.R
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.provider.Settings.Global.getString
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService




@RequiresApi(Build.VERSION_CODES.O)
class ShowNotification(
    msgFrom: String,
    msgBody: String,
    var context: Context
) {
    val NOTIFICATION_CHANNEL_ID = "channel_id"
    val NOTIFICATION_ID = 101
    val CHANNEL_NAME = "Notification Channel"
    val CHANNEL_DESC = "Notification Channel"

    init {

            createNotificationChannel()
            var builder = NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_menu_camera)
                .setContentTitle("My notification")
                .setContentText("Much longer text that cannot fit one line...")
                .setStyle(NotificationCompat.BigTextStyle()
                    .bigText("Much longer text that cannot fit one line..."))
                .setPriority(NotificationCompat.PRIORITY_HIGH).setDefaults(Notification.DEFAULT_ALL)

            with(NotificationManagerCompat.from(context)) {
                // notificationId is a unique int for each notification that you must define
                notify(NOTIFICATION_ID, builder.build())
            }


     /*   val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?
        val notification = Notification.Builder(context).setContentTitle("Some Message")
            .setContentText("You've received new messages!")
            .setSmallIcon(R.drawable.ic_menu_camera)
            .setChannelId(NOTIFICATION_CHANNEL_ID).build();
        notificationManager?.notify(NOTIFICATION_ID, notification);*/
    }

    /*fun showNotification(msgFrom : String, msg : String,context : Context)
    { val context=context
        Toast.makeText(context,msgFrom+" "+msg, Toast.LENGTH_LONG).show()

        createNotificationChannel()
        var builder = NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_menu_camera)
            .setContentTitle("My notification")
            .setContentText("Much longer text that cannot fit one line...")
            .setStyle(NotificationCompat.BigTextStyle()
                .bigText("Much longer text that cannot fit one line..."))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(context)) {
            // notificationId is a unique int for each notification that you must define
            notify(NOTIFICATION_ID, builder.build())
        }
    }*/

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name =CHANNEL_NAME
            val descriptionText = CHANNEL_DESC
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(NOTIFICATION_CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}