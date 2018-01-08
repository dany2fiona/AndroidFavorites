package com.dany.favorites.global

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.WindowManager
import com.dany.favorites.widget.dialog.LoadingDialog
import com.dany.favorites.widget.dialog.LoadingDialog.Companion.createProgrssDialog
import com.dany.libs.swipeback.app.SwipeBackActivity

/**
 *Created by dan.y on 2017/12/19 16:03.
 */
open class BaseActivity:SwipeBackActivity() {
    protected var progressDialog: LoadingDialog?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP/*21*/ ) {//kotlin版本报错---anko版本（0.10）问题识别不到LOLLIPOP
            //全屏模式显示statusbar
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
            window.addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
        }
    }

    protected fun getRootContext():Activity = getRootContext(this)

    private fun getRootContext(act: Activity): Activity = if(act.isChild) getRootContext(act.parent) else act

    override fun onCreateOptionsMenu(menu: Menu?): Boolean = true

    /**
     * 显示加载
     * @param showMessage
     */
    fun showWaiting() {
        progressDialog?.dismiss()
        progressDialog = null
        progressDialog = createProgrssDialog(getRootContext())
        progressDialog?.show()
    }

    fun stopWaiting() {
        progressDialog?.dismiss()
        progressDialog = null
    }

}