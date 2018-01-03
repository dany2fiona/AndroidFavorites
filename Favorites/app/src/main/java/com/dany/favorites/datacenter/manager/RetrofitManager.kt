package com.dany.favorites.datacenter.manager

import com.dany.favorites.R
import com.dany.favorites.extensions.DelegatesExt
import com.dany.favorites.global.FavorApp
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import okhttp3.OkHttpClient



/**
 * 创建人：dan.y
 * 创建时间：2017-6-21
 * 类描述：封装一个retrofit集成0kHttp3的抽象基类
*/
open class RetrofitManager {
    companion object{
        private var mRetrofit: Retrofit by DelegatesExt.notNullSingleValue<Retrofit>()
        private var mOkHttpClient: OkHttpClient by DelegatesExt.notNullSingleValue<OkHttpClient>()

        /**
         * 获取Retrofit对象
         * @return
         */
        /*protected*/ fun getRetrofit(): Retrofit{
            mOkHttpClient = OkhttpManager.getOkHttpClient()
            mRetrofit = Retrofit.Builder()
                    .baseUrl(FavorApp.instance.getString(R.string.baseUrl))
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(mOkHttpClient)
                    .build()
            return mRetrofit
        }
    }

}