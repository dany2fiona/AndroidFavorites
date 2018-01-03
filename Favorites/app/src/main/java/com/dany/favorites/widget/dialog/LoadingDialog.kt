package com.dany.favorites.widget.dialog

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.widget.ImageView

import com.bumptech.glide.Glide
import com.dany.favorites.R
import org.jetbrains.anko.find

/**
 * Created by dan.y on 2016/12/13.
 */
class LoadingDialog : Dialog {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, theme: Int) : super(context, theme) {}

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        mLoadingImageView = mProgrssDialog?.find(R.id.ivLoading)/*.findViewById(R.id.ivLoading)*//* as ImageView*/
        Glide.with(mContext).load(R.mipmap.loading).asGif().into(mLoadingImageView!!)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        mLoadingImageView = null
        mProgrssDialog = null
        System.gc()
    }

    companion object {
        private var mProgrssDialog: LoadingDialog? = null
        private var mLoadingImageView: ImageView? = null
        private var mContext: Context? = null

        fun createProgrssDialog(context: Context): LoadingDialog? {
            mContext = context
            mProgrssDialog = LoadingDialog(context,
                    R.style.loading_view_dialog)
            mProgrssDialog?.setContentView(R.layout.dialog_loading_view)
            mProgrssDialog?.window?.attributes?.gravity = Gravity.CENTER
            mProgrssDialog?.setCanceledOnTouchOutside(false)
            //        mProgrssDialog.setCancelable(false);
            return mProgrssDialog
        }
    }

}
