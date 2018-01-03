package com.dany.favorites.presenter.robo

import com.dany.favorites.bean.RoboBean
import com.dany.favorites.contract.robo.RoboContract
import com.dany.favorites.datacenter.manager.BaseSubscriber
import com.dany.favorites.datacenter.manager.BaseSubscriberWithRefresh
import com.dany.favorites.datacenter.servers.robo.RoboServers
import com.dany.favorites.global.BaseActivity
import org.jetbrains.anko.toast

/**
 *Created by dan.y on 2018/1/2 17:32.
 */
class RoboPresenter(var view:RoboContract.View):RoboContract.Presenter {

    init {
        view.setRoboPresenter(this)
    }

    override fun getStory(storyName: String, context: BaseActivity) {
        RoboServers.getStory(storyName,object : BaseSubscriberWithRefresh<RoboBean>(context){

            override fun onNext(bean: RoboBean?) {
                context.toast("tell成功")
                view.getStorySuccessed(bean!!)
            }

            override fun onStopRefresh() {
                view.onStopRefresh()
            }

        })
    }
}