package com.lib.starlightrush

import android.content.Context
import android.util.Log
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

object AppsFlyerProvider {
    private const val APPS_FLYER_KEY = "4buFftGeoUXVzfrDfEMBCe"

    fun provideAppsFlyer(context: Context) = callbackFlow {
        AppsFlyerLib.getInstance().init(
            APPS_FLYER_KEY,
            object : AppsFlyerConversionListener {
                override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
                    trySend(data)
                    Log.d("dataFlow", "conversion:  " + data.toString())
                }

                override fun onConversionDataFail(message: String?) {
                    trySend(null)
                    Log.d("dataFlow", "conversion:  " + " null")

                }

                override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {

                }

                override fun onAttributionFailure(p0: String?) {

                }
            },
            context
        )
        AppsFlyerLib.getInstance().start(context)
        awaitClose {
            cancel()
        }
    }
}