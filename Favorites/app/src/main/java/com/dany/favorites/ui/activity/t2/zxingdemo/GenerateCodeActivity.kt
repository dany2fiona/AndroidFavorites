package com.dany.favorites.ui.activity.t2.zxingdemo

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import com.dany.favorites.R
import com.dany.favorites.global.BaseActivity
import kotlinx.android.synthetic.main.activity_generate_code.*
import kotlinx.android.synthetic.main.layout_navback.*
import kotlinx.android.synthetic.main.toolbar_backandtitle.*
import android.os.AsyncTask
import android.view.View
import com.dany.libs.qrcode.core.BGAQRCodeUtil
import com.dany.libs.qrcode.zxing.QRCodeEncoder
import org.jetbrains.anko.toast


/**
 *Created by dan.y on 2018/1/8 16:26.
 */
class GenerateCodeActivity:BaseActivity() {
    var mCreateEnglishQRCodeAsyncTask: CreateEnglishQRCodeAsyncTask?=null
    var url:String ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generate_code)
        setSupportActionBar(toolbar)
        fl_toolbar.setBackgroundColor(resources.getColor(R.color.colorAccent))
        tv_title.text="生成二维码"
        url = resources.getString(R.string.url_qrcode)
        toolbar_back.setOnClickListener({ finish() })
        btn_generatecode.setOnClickListener({_->kotlin.run {
            mCreateEnglishQRCodeAsyncTask = CreateEnglishQRCodeAsyncTask()
            mCreateEnglishQRCodeAsyncTask!!.execute(url)
        }})
    }

    override fun onDestroy() {
        super.onDestroy()
        mCreateEnglishQRCodeAsyncTask?.cancel(true);
        mCreateEnglishQRCodeAsyncTask = null;
    }


    inner class CreateEnglishQRCodeAsyncTask : AsyncTask<String, Void, Bitmap>() {

        override fun doInBackground(vararg params: String): Bitmap {
            return QRCodeEncoder.syncEncodeQRCode(params[0], BGAQRCodeUtil.dp2px(this@GenerateCodeActivity, 150f), Color.parseColor("#000000"))
        }

        override fun onPostExecute(bitmap: Bitmap?) {
            super.onPostExecute(bitmap)
            if (bitmap != null) {
                toast("生成二维码成功")
                iv_qcode.setVisibility(View.VISIBLE)
                iv_qcode.setImageBitmap(bitmap)
            } else {
                toast("生成二维码失败")
            }
        }
    }

}