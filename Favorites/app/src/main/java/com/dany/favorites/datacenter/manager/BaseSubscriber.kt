package com.dany.favorites.datacenter.manager

import com.dany.favorites.global.BaseActivity
import org.jetbrains.anko.toast
import rx.Subscriber
import java.net.ConnectException
import java.net.SocketTimeoutException

/**
 * Created by dan.y on 2017/6/23.
 */
abstract class BaseSubscriber<T>(val context: BaseActivity) : Subscriber<T>() {
    var isShowProgressCircle:Boolean = true         //默认显示加载进度圈
    var isShowErrorInfo:Boolean = true              //默认显示错误信息
    var isShowErrorToast:Boolean = true             //默认显示错误toast..多个请求同时发送时只显示一次。

    override fun onStart() {
        super.onStart()
        if(!OkhttpManager.isNetworkReachable(context)){
            onCompleted()
            return
        }
        if(isShowProgressCircle){
            context.showWaiting()
        }
    }

    override fun onError(e: Throwable?) {
        context.stopWaiting()
        if(isShowErrorToast){
            if(e is SocketTimeoutException){
                context.toast("网络中断，请检查您的网络状态")
            }else if(e is ConnectException){
                context.toast("网络中断，请检查您的网络状态")
            }else{
                if(isShowErrorInfo){
                    context.toast("错误:${ e?.message}")
                }
            }
        }
    }

    override fun onCompleted() {
        context.stopWaiting()
    }

    fun isShowProgressCirice(isShowProgressCircle:Boolean){
        this.isShowProgressCircle = isShowProgressCircle
    }

    fun isShowErrorInfo(showErrorInfo: Boolean) {//显示具体错误信息
        isShowErrorInfo = showErrorInfo
    }

    fun isShowErrorToast(showErrorToast: Boolean) {//显示无网错误信息
        isShowErrorToast = showErrorToast
    }

}