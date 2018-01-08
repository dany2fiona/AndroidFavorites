package com.dany.favorites.common.task

import android.content.Context
import android.graphics.Bitmap
import android.os.AsyncTask
import android.text.TextUtils
import com.dany.libs.qrcode.zxing.QRCodeDecoder
import org.jetbrains.anko.toast

/**
 *Created by dan.y on 2018/1/8 14:20.
 */
class DecodeQRCodeAsyncTask(val context: Context,val listener:Listener): AsyncTask<Bitmap, Void, String>() {

    override fun doInBackground(vararg params: Bitmap?): String {
        return QRCodeDecoder.syncDecodeQRCode(params[0])
    }

    override fun onPostExecute(result: String?) {
        if(TextUtils.isEmpty(result)){
            context.toast("未发现二维码")
        }else{
            context.toast(result!!)
            //解析成功后的action
            listener.onTaskSuccessed(result)
        }
    }

    public interface Listener{
         fun onTaskSuccessed(content:String)
    }
}