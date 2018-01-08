package com.dany.favorites.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dany.favorites.R
import com.dany.favorites.extensions.ctx
import kotlinx.android.synthetic.main.layout_item_test.view.*
import java.util.*


@Suppress("DEPRECATION")
/**
 *Created by dan.y on 2017/12/14 11:52.
 */
class TestAdapter(var items:ArrayList<Int>): RecyclerView.Adapter<TestAdapter.ViewHolder>() {
    private val colors:ArrayList<Int> = arrayListOf(
            R.color.colorAccent,
            R.color.yellow,
            R.color.red,
            R.color.blue,
            R.color.orange,
            R.color.purple,
            R.color.green
    )
    private var context:Context? = null

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.itemView?.ll_item?.setBackgroundColor(context?.resources?.getColor(colors[Random().nextInt(colors.size)])!!)
        holder?.itemView?.tv_item?.text = items[position].toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        context = parent?.ctx
        val view = LayoutInflater.from(context).inflate(R.layout.layout_item_test,parent,false)
        return ViewHolder(view)
    }

    class ViewHolder(val view:View):RecyclerView.ViewHolder(view){

    }

}