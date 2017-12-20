package com.dany.favorites.global

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.find

/**
 *
 *Created by dan.y on 2017/12/19 17:50.
 */
abstract class BaseFrame: Fragment() {
    private  var mView: View? = null
    protected var isVisy: Boolean = false
    protected var isLazyLoaded:Boolean = false
    protected var isFirstIn:Boolean = true//判断第一次加载数据的逻辑在oncreate里面不在onresume中

    /**
     * 在这里实现Fragment数据的缓加载.
     * 如果需要进入页面就重新加载数据，isLazyLoaded为false即可..
     */
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        Log.d("dan.y","--setUserVisibleHint--"+getUserVisibleHint())
        if(getUserVisibleHint()) {
            isVisy = true;
            if(!isLazyLoaded) initData()
        } else {
            isVisy = false;
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mView == null) {
            mView = getBaseLayout(inflater!!, container)
            initView()
            if(isVisy && !isLazyLoaded){//第一次主页加载重复..
                initData()
            }
        }
        // 判断是否已经被加过parent， 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        val parent = mView?.getParent() as? ViewGroup
        parent?.removeView(mView)
        return mView
    }

    protected fun find(id:Int):View? = mView?.find(id)

    override fun onResume() {
        super.onResume()
        if (isFirstIn){
            //donoting..
            isFirstIn = false
        }else{
            if(isVisy && !isLazyLoaded){
                initData()
            }
        }
    }

    protected abstract fun getBaseLayout(inflater: LayoutInflater,
                                         container: ViewGroup?): View

    protected abstract fun initView()

    protected abstract fun initData()

    protected abstract fun onBackPressed()

}