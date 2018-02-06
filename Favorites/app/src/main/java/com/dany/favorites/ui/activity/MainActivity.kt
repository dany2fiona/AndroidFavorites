package com.dany.favorites.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import com.dany.favorites.R
import com.dany.favorites.adapter.MainTabAdapter
import com.dany.favorites.global.BaseActivity
import com.dany.libs.viewpagerindicator.view.indicator.IndicatorViewPager
import com.dany.libs.viewpagerindicator.view.indicator.transition.OnTransitionTextListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    var datas:ArrayList<Int> = arrayListOf()
    var mIndicatorViewPager:IndicatorViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mIndicator.setOnTransitionListener(OnTransitionTextListener().setColor(Color.RED, Color.GRAY))
        mIndicatorViewPager = IndicatorViewPager(mIndicator,mViewPager)
        mIndicatorViewPager?.adapter = MainTabAdapter(supportFragmentManager)
        mViewPager.isCanScroll = false/*true*/
        mViewPager.offscreenPageLimit = 4
        setSwipeBackEnable(false)
//        for (i in 1L..100L){
//            Log.d("dan.yyy","---------func($i):"+func(i)+"----------")
//        }
}

    private fun fillData() {
        for (i in 1..50){
            datas.add(i)
        }
    }

    private fun func(p:Long):Long {
        if(p==1L)return 1L
        else if(p==2L)return 2
        else{
            if(p%2 == 1L){
                return func(p-1)+func(p-2)
            }else{
                return 2*func(p-1)
            }
        }
    }
}
