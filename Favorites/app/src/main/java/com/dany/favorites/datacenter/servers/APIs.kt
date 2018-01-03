package com.dany.favorites.datacenter.servers


import com.dany.favorites.bean.RoboBean
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import rx.Observable

/**
 * Created by dan.y on 2016/12/13.
 */
interface APIs{

    //根据城市名查询天气
    @FormUrlEncoded
    @POST("api")
    fun getStory( @Field("key") key: String ,@Field("info") info: String): Observable<RoboBean>

}
