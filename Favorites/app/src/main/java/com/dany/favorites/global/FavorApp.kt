package com.dany.favorites.global

import android.app.Application
import com.dany.favorites.R
import com.dany.favorites.common.constants.LogLevel
import com.dany.favorites.extensions.DelegatesExt

/**
 *Created by dan.y on 2017/12/19 14:39.
 */
class FavorApp: Application() {
    var currentLogLevel = LogLevel.Null

    companion object {
        var instance:FavorApp by DelegatesExt.notNullSingleValue()
        var roboKey:String = "7b157f27ee4e49f19739e1ab125e9af6"
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        val loglevel = getString(R.string.logLevel)
        currentLogLevel = LogLevel.convertToEnum(Integer.parseInt(loglevel))
    }
}