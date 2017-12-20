package com.dany.favorites.global

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.find

/**
 *Created by dan.y on 2017/12/19 17:50.
 */
abstract class BaseFrame: Fragment() {
    private  var mView: View? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mView == null) {
            mView = getBaseLayout(inflater!!, container)
            initView()
            initData()
        }
        // 判断是否已经被加过parent， 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        val parent = mView?.getParent() as? ViewGroup
        parent?.removeView(mView)
        return mView
    }

    protected fun find(id:Int):View? = mView?.find(id)

    protected abstract fun getBaseLayout(inflater: LayoutInflater,
                                         container: ViewGroup?): View

    protected abstract fun initView()

    protected abstract fun initData()

    protected abstract fun onBackPressed()

}