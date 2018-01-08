package com.dany.favorites.ui.activity.t2.zxingdemo

import android.app.Activity
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import com.dany.favorites.R
import com.dany.favorites.common.task.DecodeQRCodeAsyncTask
import com.dany.favorites.global.BaseActivity
import com.dany.libs.qrcode.zxing.QRCodeDecoder
import kotlinx.android.synthetic.main.activity_select_album.*
import kotlinx.android.synthetic.main.layout_navback.*
import kotlinx.android.synthetic.main.toolbar_backandtitle.*

/**
 *Created by dan.y on 2018/1/8 13:52.
 */
class SelectAlbumActivity : BaseActivity(), DecodeQRCodeAsyncTask.Listener {
    private val ALBUM_RESULTCODE:Int = 0x1003
    var mDecodeQRCodeAsyncTask: DecodeQRCodeAsyncTask?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_album)
        setSupportActionBar(toolbar)
        fl_toolbar.setBackgroundColor(resources.getColor(R.color.colorAccent))
        tv_title.text="从图库选择二维码"
        toolbar_back.setOnClickListener({ finish() })
        btn_pick_qrcode.setOnClickListener({_-> kotlin.run{ tv_qrcode.text="";gotoGallery()}})
    }

    fun gotoGallery(){ //调用相册
        val intent = Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, ALBUM_RESULTCODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == ALBUM_RESULTCODE && resultCode == Activity.RESULT_OK && data != null){
            val selectedImage:Uri = data.data
            val filePathColumns:Array<String> = arrayOf(MediaStore.Images.Media.DATA)
            val c:Cursor = contentResolver.query(selectedImage,filePathColumns,null,null,null)
            c.moveToFirst()
            val columnIndex:Int = c.getColumnIndex(filePathColumns[0])
            val imagePath:String = c.getString(columnIndex)
            mDecodeQRCodeAsyncTask = DecodeQRCodeAsyncTask(this@SelectAlbumActivity,this)
            mDecodeQRCodeAsyncTask?.execute(QRCodeDecoder.getDecodeAbleBitmap(imagePath))
            c.close()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mDecodeQRCodeAsyncTask?.cancel(true);
        mDecodeQRCodeAsyncTask = null;
    }

    override fun onTaskSuccessed(content: String) {
       tv_qrcode.text=content
    }

}