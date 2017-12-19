package com.dany.favorites.global

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import com.dany.libs.swipeback.app.SwipeBackActivity

/**
 *Created by dan.y on 2017/12/19 16:03.
 */
open class BaseActivity:SwipeBackActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    protected fun getRootContext():Activity = getRootContext(this)

    private fun getRootContext(act: Activity): Activity = if(act.isChild) getRootContext(act.parent) else act

    override fun onCreateOptionsMenu(menu: Menu?): Boolean = true


}