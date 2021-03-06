package com.dany.favorites.ui.fragment.tabs

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.dany.favorites.R
import com.dany.favorites.global.BaseActivity
import com.dany.favorites.global.BaseFrame
import kotlinx.android.synthetic.main.layout_frame_home.*
import org.jetbrains.anko.find

/**
 *Created by dan.y on 2017/12/20 10:11.
 */
class T4Frame : BaseFrame() {
    var tv_tilte:TextView?=null
    var tv_col:TextView?=null

    override fun getBaseLayout(inflater: LayoutInflater, container: ViewGroup?): View {
        return LayoutInflater.from(context).inflate(R.layout.layout_frame_home,container, false)
    }

    override fun initView() {
        Log.d("dan.y","==T4F==initView==")
        (activity as BaseActivity).setSupportActionBar(toolbar)
        tv_tilte = find(R.id.tv_title) as TextView
        tv_tilte?.text="helloT4"
        tv_col = find(R.id.tv_collap) as TextView
        tv_col?.text="hello4"
    }

    override fun initData() {
        isLazyLoaded = true
        Log.d("dan.y","==T4F==initData==")
    }

    override fun onBackPressed() {
    }
}