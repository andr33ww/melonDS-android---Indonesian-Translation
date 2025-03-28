package me.magnum.melonds.extensions

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.PowerManager
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat

@RequiresApi(33)
fun Context.isNotificationPermissionGranted(): Boolean {
    return ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED
}

fun Context.isMicrophonePermissionGranted(): Boolean {
    return ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED
}

fun Context.isSustainedPerformanceModeAvailable(): Boolean {
    val powerManager = this.getSystemService(Context.POWER_SERVICE) as PowerManager
    return powerManager.isSustainedPerformanceModeSupported
}