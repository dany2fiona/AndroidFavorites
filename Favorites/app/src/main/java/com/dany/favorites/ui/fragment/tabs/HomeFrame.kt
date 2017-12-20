package com.dany.favorites.ui.fragment.tabs

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.dany.favorites.R
import com.dany.favorites.global.BaseFrame
import com.dany.favorites.ui.activity.CollapseToolbarActivity


/**
 * Kotlin fragment中直接调用控件id获取不了其引用，使用find初始化..
 *Created by dan.y on 2017/12/20 10:11.
 */
class HomeFrame:BaseFrame() {
    var tv_tilte:TextView?=null

    override fun getBaseLayout(inflater: LayoutInflater, container: ViewGroup?): View {
        return LayoutInflater.from(context).inflate(R.layout.layout_frame_home,container, false)
    }

    override fun initView() {
        Log.d("dan.y","==home==initView==")
        tv_tilte = find(R.id.tv_title) as TextView
        tv_tilte?.apply { text="hello"
            setOnClickListener{
                var intent = Intent(context,CollapseToolbarActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun initData() {
        Log.d("dan.y","==home==initData==")
    }

    override fun onBackPressed() {
    }
}

