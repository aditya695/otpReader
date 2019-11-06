package com.example.otpreader

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.telephony.SmsMessage
import android.util.Log
import androidx.annotation.RequiresApi
import java.lang.Exception


class RssOtpReader : BroadcastReceiver() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onReceive(context: Context?, intent: Intent?) {

        if (intent!=null)
        {
            if(intent.action.equals("android.provider.Telephony.SMS_RECEIVED"))
            {
                val bundle = intent.extras
                val msgs: Array<SmsMessage?>
                var msg_from: String? =null
                var msgBody: String? =null
                if (bundle != null){
                    try {
                        val pdus = bundle.get("pdus") as Array<Any>
                        msgs = arrayOfNulls<SmsMessage>(pdus.size)
                        for (i in 0 until msgs.size) {
                            msgs[i] = SmsMessage.createFromPdu(pdus[i] as ByteArray)

                            msg_from = msgs[i]?.getOriginatingAddress().toString()
                            val msgBody = msgs[i]?.getMessageBody()
                            Log.d("Aditya_msg_recved",msgBody)
                        }
                        if (context != null) {
                            ShowNotification(msg_from.toString(), msgBody.toString(), context)
                        }

                    }catch (e : Exception)
                    {
                        Log.d("error",e.printStackTrace().toString())
                    }
                }
            }
        }


        }

    }



