package com.dany.favorites.datacenter.manager

import com.dany.favorites.common.utils.IntentUtils
import com.dany.favorites.common.utils.ALog
import com.dany.favorites.global.BaseActivity
import org.jetbrains.anko.toast
import rx.Subscriber
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException


/**
 * 有下拉刷新的
 * Created by dan.y on 2016/12/13.
 */

abstract class BaseSubscriberWithRefresh<T>(private val context: BaseActivity) : Subscriber<T>() {
    private var isShowProgressCircle = true//默认显示加载进度圈
    private var isShowErrorInfo = true     //默认显示错误信息,同一个接口不同类型参数访问两次要统一时间处理的时间差异常不显示
    private var isShowErrorToast = true    //默认显示错误toast..多个请求同时发送时只显示一次。
    override fun onStart() {
        super.onStart()
        if (!OkhttpManager.isNetworkReachable(context)) {
            //            DialogUtil.showToastDialog(context, "当前网络不可用，请检查网络情况");
            onCompleted()
            return
        }
        if (isShowProgressCircle) {
            context.showWaiting()
        }
    }

    override fun onError(e: Throwable) {
        onStopRefresh()
        context.stopWaiting()
        if (isShowErrorToast) {
            if (e is SocketTimeoutException) {
                context.toast("网络中断，请检查您的网络状态")
            } else if (e is ConnectException) {
                context.toast("网络中断，请检查您的网络状态")
            } else if (e is UnknownHostException) {
                context.toast("网络中断，请检查您的网络状态")
            } else {
                if (isShowErrorInfo) {
                    context.toast("错误:" + e.message)
                }
                ALog.d("dan.y", "错误:" + e.message)
            }
        }
    }

    override fun onCompleted() {
        onStopRefresh()
        context.stopWaiting()
    }

    fun isShowProgressCirice(isShowProgressCircle: Boolean) {
        this.isShowProgressCircle = isShowProgressCircle
    }

    fun isShowErrorInfo(showErrorInfo: Boolean) {
        isShowErrorInfo = showErrorInfo
    }

    fun isShowErrorToast(showErrorToast: Boolean) {//显示无网错误信息
        isShowErrorToast = showErrorToast
    }

    abstract fun onStopRefresh()
}

