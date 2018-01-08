package com.dany.favorites.ui.activity.t2.zxingdemo

import android.content.Context
import android.os.Bundle
import android.os.Vibrator
import android.view.View
import com.dany.favorites.R
import com.dany.favorites.common.utils.ALog
import com.dany.favorites.global.BaseActivity
import com.dany.libs.qrcode.core.QRCodeView
import kotlinx.android.synthetic.main.activity_qrcode.*
import kotlinx.android.synthetic.main.layout_navback.*
import kotlinx.android.synthetic.main.toolbar_backandtitle.*
import org.jetbrains.anko.toast

/**
 *Created by dan.y on 2018/1/8 15:44.
 */
class QRcodeActivity:BaseActivity(),View.OnClickListener, QRCodeView.Delegate{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrcode)
        setSupportActionBar(toolbar)
        fl_toolbar.setBackgroundColor(resources.getColor(R.color.colorAccent))
        tv_title.text="扫描二维码"
        toolbar_back.setOnClickListener(this)
        zxingview.setDelegate(this)
        btn_open_flash.setOnClickListener(this)
        btn_close_flash.setOnClickListener(this)
        btn_barcode.setOnClickListener(this)
        btn_qrcode.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()
        zxingview.startCamera()
        zxingview.showScanRect()
        zxingview.startSpot()
    }

    override fun onDestroy() {
        zxingview.onDestroy()
        super.onDestroy()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.toolbar_back ->{finish()}
            R.id.btn_open_flash ->{zxingview.openFlashlight()}
            R.id.btn_close_flash ->{zxingview.closeFlashlight()}
            R.id.btn_barcode ->{zxingview.changeToScanBarcodeStyle()}
            R.id.btn_qrcode ->{zxingview.changeToScanQRCodeStyle()}
        }
    }

    @Suppress("DEPRECATION")
    private fun vibrate() {
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(200)
    }

    override fun onScanQRCodeOpenCameraError() {
        ALog.e("dan.y", "打开相机出错")
    }

    override fun onScanQRCodeSuccess(result: String?) {
        ALog.d("dan.y", "result:" + result)
        toast(result!!)
        vibrate()
        zxingview.startSpot()
    }


}