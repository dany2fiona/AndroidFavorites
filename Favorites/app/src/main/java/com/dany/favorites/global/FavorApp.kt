package com.dany.favorites.global

import android.app.Application
import com.dany.favorites.extensions.DelegatesExt

/**
 *Created by dan.y on 2017/12/19 14:39.
 */
class FavorApp: Application() {

    companion object {
        var instance:FavorApp by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}