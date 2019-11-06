package com.example.otpreader

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import java.util.regex.Pattern


class OtpReader () : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }

    fun readOTP(msg: String): String {
        for (otpCollection in MyOtpCollection.values()) {
            val pattern = Pattern.compile(otpCollection.getOtpType(), Pattern.MULTILINE)
            val matcher = pattern.matcher(msg)
            while (matcher.find()) {
                //System.out.println("Full match: " + matcher.group(0));
                for (i in 1..1) {
                    // System.out.println("Group " + i + ": " + matcher.group(i));
                    return matcher.group(i)
                }
            }
        }
        return msg
    }
}