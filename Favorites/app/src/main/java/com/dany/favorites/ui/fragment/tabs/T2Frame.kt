package com.dany.favorites.ui.fragment.tabs

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.dany.favorites.R
import com.dany.favorites.adapter.FlowmAdapter
import com.dany.favorites.contract.bridge.OnItemClickListener
import com.dany.favorites.global.BaseActivity
import com.dany.favorites.global.BaseFrame
import com.dany.favorites.ui.activity.t2.LoadBigImageActivity
import com.dany.favorites.ui.activity.t2.RoboActivity
import com.dany.favorites.ui.activity.t2.zxingdemo.ZxingDemoActivity
import com.dany.favorites.widget.recyclerview.FlowLayoutManager
import kotlinx.android.synthetic.main.layout_frame_t2.*
import org.jetbrains.anko.toast

/**
 *Created by dan.y on 2017/12/20 10:11.
 */
class T2Frame : BaseFrame(), OnItemClickListener {
    var tv_tilte: TextView?=null
    var recyclerview: RecyclerView?=null
    var mAdapter:FlowmAdapter ?=null
    var datas:ArrayList<String> = arrayListOf()

    override fun getBaseLayout(inflater: LayoutInflater, container: ViewGroup?): View {
        return LayoutInflater.from(context).inflate(R.layout.layout_frame_t2,container, false)
    }

    override fun initView() {
        (activity as BaseActivity).setSupportActionBar(toolbar)
        tv_tilte = find(R.id.tv_title) as TextView
        tv_tilte!!.text = "helloT2"
        Log.d("dan.y","==T2F==initView==")
        recyclerview = find(R.id.recyclerview) as RecyclerView
        recyclerview!!.layoutManager = FlowLayoutManager()
        fillData();
        mAdapter = FlowmAdapter(datas)
        recyclerview!!.adapter = mAdapter
        mAdapter!!.mListener = this@T2Frame
    }

    override fun onItemClick(view: View, position: Int) {
        activity.toast("position:"+position)
        var intent:Intent ?= null
        when(position){
            0 -> {
                intent = Intent(context, LoadBigImageActivity::class.java)
                startActivity(intent)
            }
            1 -> {
                intent = Intent(context, RoboActivity::class.java)
                startActivity(intent)
            }
            2 -> {
                intent = Intent(context, ZxingDemoActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun fillData() {
//        for (i in 1..50){
//            datas.add(i)
//        }
        datas.add("加载高清大图demo")
        datas.add("Rxjava+Retrofit+Okh3网络接口")
        datas.add("二维码功能组")
        datas.add("博士被骗23万")
        datas.add("南非诞生双脸小猫")
        datas.add("江西中学女生坠亡")
        datas.add("法院下令扑杀驯鹿")
        datas.add("黎姿近照曝光	")
        datas.add("8万元卖亲生女儿")
        datas.add("白百何牵儿子现身")
        datas.add("普京最大政敌竞选")
        datas.add("韩总理跪地吊唁")
        datas.add("张艺谋妻女晒自拍")
        datas.add("深圳地铁碾压事件")
        datas.add("2岁男童撞墙身亡")
        datas.add("巡警狂减肥60斤")
        datas.add("乐天创始人获刑")
        datas.add("巡警狂减肥60斤")
        datas.add("乐天创始人获刑")
        datas.add("巡警狂减肥60斤")
        datas.add("乐天创始人获刑")

    }

    override fun initData() {
        isLazyLoaded = true
        Log.d("dan.y","==T2F==initData==")
    }

    override fun onBackPressed() {
    }
}