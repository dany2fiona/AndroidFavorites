package com.dany.favorites.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.dany.favorites.R
import com.dany.favorites.extensions.ctx
import com.dany.favorites.global.BaseFrame
import com.dany.favorites.ui.fragment.tabs.HomeFrame
import com.dany.favorites.ui.fragment.tabs.T2Frame
import com.dany.favorites.ui.fragment.tabs.T3Frame
import com.dany.favorites.ui.fragment.tabs.T4Frame
import com.dany.libs.viewpagerindicator.view.indicator.IndicatorViewPager

/**
 *Created by dan.y on 2017/12/18 16:40.
 */
class MainTabAdapter(fragmentManager: FragmentManager?) : IndicatorViewPager.IndicatorFragmentPagerAdapter(fragmentManager) {
    private val tabNames:Array<String> = arrayOf("主页", "消息", "发现", "我")
    private val tabIcons:Array<Int> = arrayOf(R.drawable.maintab_1_selector, R.drawable.maintab_2_selector, R.drawable.maintab_3_selector,
            R.drawable.maintab_4_selector)
    private val fragments = arrayListOf<BaseFrame>(HomeFrame(),T2Frame(),T3Frame(),T4Frame())
    private var context:Context?=null

    override fun getCount(): Int = tabNames.size

    override fun getViewForTab(position: Int, convertView: View?, container: ViewGroup?): View {
        context = container?.ctx
        var tabview:View? = convertView
        if(tabview == null){
            tabview = LayoutInflater.from(context).inflate(R.layout.tab_main,container,false)
        }
        val textView: TextView = tabview as TextView
        textView.text = tabNames[position]
        val mDrawable = context?.resources?.getDrawable(tabIcons[position])
        // 这一步必须要做,否则不会显示.
        mDrawable?.setBounds(0, 0, mDrawable.getMinimumWidth(),
                mDrawable.getMinimumHeight())
        textView.setCompoundDrawables(null, mDrawable, null, null)
//        textView.setCompoundDrawablesWithIntrinsicBounds(0,tabIcons[position],0,0)
        return textView
    }

    override fun getFragmentForPage(position: Int): Fragment {
        return fragments[position]
    }
}