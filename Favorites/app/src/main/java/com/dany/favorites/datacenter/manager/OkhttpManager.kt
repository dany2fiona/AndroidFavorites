package com.dany.favorites.datacenter.manager

import android.content.Context
import android.net.wifi.WifiManager
import android.net.ConnectivityManager
import android.util.Log
import com.dany.favorites.extensions.DelegatesExt
import com.dany.favorites.global.FavorApp
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.io.IOException
import java.util.concurrent.TimeUnit


/**
 *类描述：封装一个OkHttp3的获取类
 * Created by dan.y on 2017/6/21.
 */
class OkhttpManager {

    companion object{
        private var mOkHttpClient: OkHttpClient by DelegatesExt.notNullSingleValue<OkHttpClient>()
        //设置缓存目录
        private val cacheDirectory = File(FavorApp.instance.getCacheDir().getAbsolutePath(), "MyCache")
        private val cache = Cache(cacheDirectory, 200 * 1024 * 1024)
        private val httpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        /**
         * 获取OkHttpClient对象
         * @return
         */
        fun getOkHttpClient(): OkHttpClient {
            mOkHttpClient = OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor)
                    //                    .addInterceptor(interceptor)
                    //                    .addNetworkInterceptor(interceptor)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    //                    .cache(cache)
                    .build()
            return mOkHttpClient
        }

        private val interceptor = object : Interceptor{
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                val maxAge = 60 * 60 // 有网络时 设置缓存超时时间1个小时
                val maxStale = 60 * 60 * 24 * 28 // 无网络时，设置超时为4周
                var request = chain.request()
                if (isNetworkReachable(FavorApp.instance)) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_NETWORK)//有网络时只从网络获取
                            .build()
                } else {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)//无网络时只从缓存中读取
                            .build()
                }
                var response = chain.proceed(request)
                if (isNetworkReachable(FavorApp.instance)) {
                    response = response.newBuilder()
                            .removeHeader("Pragma")
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .build()
                } else {
                    response = response.newBuilder()
                            .removeHeader("Pragma")
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .build()
                }
                Log.d("dan.y", response.body().toString())
                return response
            }

        }

        /**
         * 判断网络是否可用

         * @param context Context对象
         */
        fun isNetworkReachable(context: Context?): Boolean {
            if (context == null) {
                return false
            }
            val cm:ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return cm.getActiveNetworkInfo()?.isAvailable ?: return false
        }

        /**
         * 获取本机IP地址

         * @param context
         * *
         * @return
         */
        fun getIP(context: Context): String? {
            if (isNetworkReachable(context)) {
                // 获取wifi服务
                val wifiManager:WifiManager = context.getSystemService(Context.WIFI_SERVICE) as WifiManager
                // 判断wifi是否开启
                if (!wifiManager.isWifiEnabled) {
                    wifiManager.isWifiEnabled = true
                }
                val wifiInfo = wifiManager.connectionInfo
                val ipAddress = wifiInfo.ipAddress
                val ip = intToIp(ipAddress)
                return ip
            }
            return null
        }

        private fun intToIp(i: Int): String {
            return (i and 0xFF).toString() + "." + (i shr 8 and 0xFF) + "." + (i shr 16 and 0xFF) +"." + (i shr 24 and 0xFF)
        }

    }

}

