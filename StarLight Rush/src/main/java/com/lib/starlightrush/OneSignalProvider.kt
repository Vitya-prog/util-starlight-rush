package com.lib.starlightrush

import android.app.Application
import com.onesignal.OneSignal

object OneSignalProvider {
    private const val ONESIGNAL_APP_ID = "4e54b7cf-fb21-496d-983e-e5e533dd57cc"

    fun initOneSignal(context: Application) {
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        // Initialization
        OneSignal.initWithContext(context)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
    }
}