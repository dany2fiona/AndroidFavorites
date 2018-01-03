package com.dany.favorites.datacenter.servers.robo

import com.dany.favorites.bean.RoboBean
import com.dany.favorites.datacenter.servers.Servers
import com.dany.favorites.global.FavorApp.Companion.roboKey
import rx.Observable
import rx.Subscriber

/**
 * Created by dan.y on 2017/6/22.
 */
class RoboServers : Servers() {
    companion object{
        //根据info查故事内容
        fun getStory (info: String,subscriber: Subscriber<RoboBean>) {
            getStory(service.getStory(roboKey,info),subscriber)
        }
        fun getStory(observable: Observable<RoboBean>, subscriber: Subscriber<RoboBean>){
            setSubscribe(observable,subscriber)
        }
    }
}