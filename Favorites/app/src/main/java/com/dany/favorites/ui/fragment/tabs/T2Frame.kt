package com.dany.favorites.ui.fragment.tabs

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.dany.favorites.R
import com.dany.favorites.global.BaseFrame
import org.jetbrains.anko.find

/**
 *Created by dan.y on 2017/12/20 10:11.
 */
class T2Frame : BaseFrame() {
    var tv_tilte: TextView?=null

    override fun getBaseLayout(inflater: LayoutInflater, container: ViewGroup?): View {
        return LayoutInflater.from(context).inflate(R.layout.layout_frame_home,container, false)
    }

    override fun initView() {
        Log.d("dan.y","==T2F==initView==")
        tv_tilte = find(R.id.tv_title) as TextView
        tv_tilte?.text="hello2"
    }

    override fun initData() {
        Log.d("dan.y","==T2F==initData==")
    }

    override fun onBackPressed() {
    }
}