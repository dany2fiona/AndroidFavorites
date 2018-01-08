package com.dany.favorites.ui.activity.t2.zxingdemo

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.view.View
import com.dany.favorites.R
import com.dany.favorites.common.task.DecodeQRCodeAsyncTask
import com.dany.favorites.global.BaseActivity
import kotlinx.android.synthetic.main.activity_long_press.*
import kotlinx.android.synthetic.main.layout_navback.*
import kotlinx.android.synthetic.main.toolbar_backandtitle.*

/**
 *Created by dan.y on 2018/1/8 13:52.
 */
class LongPressActivity:BaseActivity(),View.OnLongClickListener,DecodeQRCodeAsyncTask.Listener{

    var mDecodeQRCodeAsyncTask:DecodeQRCodeAsyncTask?=null
    var bitmap:Bitmap?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_long_press)
        setSupportActionBar(toolbar)
        fl_toolbar.setBackgroundColor(resources.getColor(R.color.colorAccent))
        tv_title.text="长按识别二维码"
        toolbar_back.setOnClickListener({ finish() })
        iv_qcode.setOnLongClickListener(this)
        bitmap = BitmapFactory.decodeResource(resources,R.mipmap.qcode)
    }

    override fun onLongClick(v: View?): Boolean {
        when(v?.id){
            R.id.iv_qcode ->{
                mDecodeQRCodeAsyncTask = DecodeQRCodeAsyncTask(this@LongPressActivity,this)
                mDecodeQRCodeAsyncTask?.execute(bitmap)
            }
        }
        return false
    }

    override fun onDestroy() {
        super.onDestroy()
        mDecodeQRCodeAsyncTask?.cancel(true);
        mDecodeQRCodeAsyncTask = null;
    }

    override fun onTaskSuccessed(content: String) {
        //调用所有浏览器，选择一种打开
        val uri = Uri.parse(content)
        val it = Intent(Intent.ACTION_VIEW, uri)
        startActivity(it)
    }

}