package com.dany.favorites.ui.activity.t2

import android.os.Bundle
import android.view.View
import android.widget.ScrollView
import com.dany.favorites.R
import com.dany.favorites.bean.RoboBean
import com.dany.favorites.contract.robo.RoboContract
import com.dany.favorites.global.BaseActivity
import com.dany.favorites.presenter.robo.RoboPresenter
import kotlinx.android.synthetic.main.activity_robo.*
import kotlinx.android.synthetic.main.layout_navback.*
import kotlinx.android.synthetic.main.toolbar_backandtitle.*
import com.dany.favorites.common.utils.RefreshScrollViewUtils
import com.handmark.pulltorefresh.library.PullToRefreshBase



/**
 * Created by dan.y on 2017/6/26.
 */
class RoboActivity : BaseActivity(), View.OnClickListener , RoboContract.View{

    var mPresenter:RoboContract.Presenter?=null
    val info:String = "讲个故事吧"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_robo)
        setSupportActionBar(toolbar)
        tv_title.text = "robo tell story"
        RefreshScrollViewUtils.initRefreshScollView(relf_scro, PullToRefreshBase.Mode.PULL_FROM_START)
        relf_scro.setOnRefreshListener({ refreshView -> run{
            RefreshScrollViewUtils.changeRefreshTime(relf_scro)
            if (refreshView.isHeaderShown()) {
                // 下拉刷新 业务代码
                getStory()
            }
        }})
        toolbar_back.setOnClickListener(this)
        RoboPresenter(this)
        getStory()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.toolbar_back -> finish()
            else -> {}
        }
    }

    override fun setRoboPresenter(presenter: RoboContract.Presenter) {
        mPresenter = presenter
    }
    override fun getStory() {
        mPresenter?.getStory(info, this@RoboActivity)
    }
    override fun getStorySuccessed(bean: RoboBean) {
        tv_story.text = bean.text +"\n"+bean.text +"\n"+bean.text +"\n"+bean.text
    }
    override fun onStopRefresh() {
        RefreshScrollViewUtils.onRefreshComplete(relf_scro)
    }

}