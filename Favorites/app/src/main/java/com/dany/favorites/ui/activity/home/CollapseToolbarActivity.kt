package com.dany.favorites.ui.activity.home

import android.os.Build
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.WindowManager
import com.dany.favorites.R
import com.dany.favorites.adapter.TestAdapter
import com.dany.favorites.global.BaseActivity
import kotlinx.android.synthetic.main.activity_collapsetoolbar.*
import kotlinx.android.synthetic.main.layout_navback.*
import kotlinx.android.synthetic.main.toolbar_backandtitle_trans.*

class CollapseToolbarActivity : BaseActivity() {
    var datas:ArrayList<Int> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= /*Build.VERSION_CODES.LOLLIPOP*/21 ) {//kotlin版本报错
            //全屏模式显示statusbar
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
            window.addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN)
        }
        setContentView(R.layout.activity_collapsetoolbar)
        setSupportActionBar(toolbar_collapsing)
        tv_title.text = "DesignLibrary.."
        toolbar_back.setOnClickListener{scrollToFinishActivity()}
//        toolbar_layout.setTitle("DesignLibrary..");
        toolbar_layout.isTitleEnabled = false
//        toolbar_layout.setCollapsedTitleTextColor(resources.getColor(R.color.white));
//        toolbar_layout.setExpandedTitleColor(resources.getColor(R.color.orange));
        iv.setImageResource(R.mipmap.bg_test)
        recyclerview.layoutManager = LinearLayoutManager(this)
        fillData();
        recyclerview.adapter = TestAdapter(datas)
    }

    private fun fillData() {
        for (i in 1..50){
            datas.add(i)
        }
    }
}