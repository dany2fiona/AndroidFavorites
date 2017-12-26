package com.dany.favorites.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dany.favorites.R
import com.dany.favorites.contract.bridge.OnItemClickListener
import com.dany.favorites.extensions.ctx
import kotlinx.android.synthetic.main.layout_item_flowm.view.*
import java.util.*

/**
 *Created by dan.y on 2017/12/14 11:52.
 */
class FlowmAdapter(var items: ArrayList<String>): RecyclerView.Adapter<FlowmAdapter.ViewHolder>(),View.OnClickListener {
    public var mListener:OnItemClickListener?=null
    override fun onClick(v: View?) {
        mListener!!.onItemClick(v!!, v!!.getTag() as Int)
    }
    private val colors: ArrayList<Int> = arrayListOf(
            R.color.colorAccent,
            R.color.yellow,
            R.color.red,
            R.color.blue,
            R.color.orange,
            R.color.purple,
            R.color.green
    )
    private var context: Context? = null

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.itemView?.tv_item?.setBackgroundColor(context?.resources?.getColor(colors[Random().nextInt(colors.size)])!!)
        holder?.itemView?.tv_item?.apply { text = items[position]
            setOnClickListener(this@FlowmAdapter)
            setTag(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        context = parent?.ctx
        val view = LayoutInflater.from(context).inflate(R.layout.layout_item_flowm,parent,false)
        return ViewHolder(view)
    }

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view){

    }

}