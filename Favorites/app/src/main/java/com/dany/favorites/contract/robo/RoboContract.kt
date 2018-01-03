package com.dany.favorites.contract.robo

import com.dany.favorites.bean.RoboBean
import com.dany.favorites.global.BaseActivity

/**
 *Created by dan.y on 2018/1/2 17:20.
 */
interface RoboContract {
    interface View{
        fun setRoboPresenter(presenter: Presenter)
        fun getStory()
        fun getStorySuccessed(bean: RoboBean)
        fun onStopRefresh()
    }

    interface Presenter{
        fun getStory(storyName:String,context: BaseActivity)
    }
}