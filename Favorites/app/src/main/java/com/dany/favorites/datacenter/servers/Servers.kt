package com.dany.favorites.datacenter.servers

import com.dany.favorites.datacenter.manager.RetrofitManager
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by dan.y on 2017/6/21.
 */
open class Servers : RetrofitManager() {
    companion object {
        /*protected*/ val service:APIs = getRetrofit().create(APIs::class.java)

        /**
         * 插入观察者
         * @param observable
         * @param subscriber
         * @param <T>
         *     需要map的转换下再写入
         */
        fun <T> setSubscribe(observable: Observable<T>, subscriber: Subscriber<T>) {
            observable.subscribeOn(Schedulers.io())
                    .subscribeOn(Schedulers.newThread())//子线程访问网络
                    .observeOn(AndroidSchedulers.mainThread())//回调到主线程
                    .subscribe(subscriber)
        }
    }
}
