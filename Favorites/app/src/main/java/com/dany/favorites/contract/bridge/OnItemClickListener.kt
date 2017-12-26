package com.dany.favorites.contract.bridge

import android.view.View

/**
 * RecyclerView item点击接口
 *Created by dan.y on 2017/12/26 11:46.
 */
interface OnItemClickListener {
    fun onItemClick(view: View, position:Int)
}