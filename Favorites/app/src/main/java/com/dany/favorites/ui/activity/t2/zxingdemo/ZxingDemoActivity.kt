package com.dany.favorites.ui.activity.t2.zxingdemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.dany.favorites.R
import com.dany.favorites.global.BaseActivity
import kotlinx.android.synthetic.main.layout_navback.*
import kotlinx.android.synthetic.main.toolbar_backandtitle.*
import kotlinx.android.synthetic.main.activity_zxingdemo.*
import org.jetbrains.anko.toast

@Suppress("DEPRECATION")
/**
 *Created by dan.y on 2018/1/5 17:28.
 */
class ZxingDemoActivity:BaseActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zxingdemo)
        setSupportActionBar(toolbar)
        fl_toolbar.setBackgroundColor(resources.getColor(R.color.colorAccent))
        activity_main.setBackgroundColor(resources.getColor(R.color.colorAccent))
        btn_long_press.setOnClickListener(this)
        btn_select_album.setOnClickListener(this)
        btn_qrcode.setOnClickListener(this)
        btn_generatecode.setOnClickListener(this)

        tv_title.text = "二维码功能组"
        toolbar_back.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var intent: Intent?
        when(v?.id){
            R.id.toolbar_back -> finish()
            R.id.btn_long_press -> {
                intent = Intent(this@ZxingDemoActivity,LongPressActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_select_album -> {
                intent = Intent(this@ZxingDemoActivity,SelectAlbumActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_qrcode -> {
                intent = Intent(this@ZxingDemoActivity,QRcodeActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_generatecode -> {
                toast("生成二维码")
            }
            else -> {}
        }
    }
}