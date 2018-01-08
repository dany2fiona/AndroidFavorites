package com.dany.favorites.ui.activity.t2

import android.graphics.Bitmap
import android.graphics.BitmapRegionDecoder
import android.graphics.Color
import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import android.support.v7.graphics.Palette
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.dany.favorites.R
import com.dany.favorites.common.utils.ScreenUtils
import com.dany.favorites.global.BaseActivity
import kotlinx.android.synthetic.main.activity_loadbigimage.*
import kotlinx.android.synthetic.main.toolbar_backandtitle.*
import kotlinx.android.synthetic.main.layout_navback.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.io.IOException



/**
 * Created by dan.y on 2017/6/26.
 */
class LoadBigImageActivity : BaseActivity(),View.OnClickListener{
    val url:String = "http://oqcg00khx.bkt.clouddn.com/03700148979_parameter"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loadbigimage)
        setSupportActionBar(toolbar)
        tv_title.text = "Load big image"
        toolbar_back.setOnClickListener(this)
        showWaiting()
        Log.d("dan.lbi","start::${System.currentTimeMillis()}")
        var decoder: BitmapRegionDecoder? = null
        try {
            doAsync {
                var path:String = Glide.with(this@LoadBigImageActivity).load(url).downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).get().absolutePath
                Log.d("dan.pa","path:${path}")
                decoder = BitmapRegionDecoder.newInstance(path, false)
//        val ism :InputStream = assets.open("t_bb_03700148979_parameter.jpg")
//        decoder = BitmapRegionDecoder.newInstance(ism, false)
                val picWidth = decoder!!.width
                val picHeight = decoder!!.height
                val heightLimit = 4096  // 不同系统上限不一样
                var height = picHeight
                val rect = Rect(0, 0, picWidth, 0)
                var bo = false
                while (height > 0) {
                    if (height >= heightLimit) {
                        rect.set(rect.left, rect.bottom, rect.right, rect.bottom + heightLimit)
                        height -= heightLimit
                    } else {
                        rect.set(rect.left, rect.bottom, rect.right, rect.bottom + height)
                        height = 0
                    }
                    val childBitmap = decoder!!.decodeRegion(rect, null)
                    if (Build.VERSION.SDK_INT >= /*Build.VERSION_CODES.LOLLIPOP*/21 &&!bo) {setStatusAndToolbarColor(childBitmap);                      bo=true}
                    // 对切割出来的子图片处理，比如展示
                    // ...
                    uiThread {
                        val iv: ImageView = ImageView(this@LoadBigImageActivity)
                        ll_big.addView(iv)
                        Log.d("dan.lbi","------iv--::${System.currentTimeMillis()}--")
                        val para = iv.getLayoutParams()
                        val imageWidth = childBitmap.width
                        val imageHeight = childBitmap.height
                        val heightscr = ScreenUtils.getScreenWidth(this@LoadBigImageActivity) * imageHeight / imageWidth
                        para.height = heightscr
                        para.width = ScreenUtils.getScreenWidth(this@LoadBigImageActivity)
                        iv.setImageBitmap(childBitmap)
                        stopWaiting()
                    }
                }
            }
            Log.d("dan.lbi","end::${System.currentTimeMillis()}")
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            if (decoder != null) {
                decoder!!.recycle()
            }
        }

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.toolbar_back -> finish()
            else -> {}
        }
    }

    fun setStatusAndToolbarColor(bitmap:Bitmap){
        Palette.from(bitmap).generate(Palette.PaletteAsyncListener { palette ->
            run{
                var a:Palette.Swatch ?= palette.mutedSwatch
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP/*21*/ ) {
                    Log.d("dan.2y",a?.rgb.toString())
//                    fl_toolbar.setBackgroundColor(Color.parseColor("#ffb8b0b0"))//ffb8b0b0
                    var rgb:Int ?= a?.rgb
                    if(rgb!=null){
                        fl_toolbar.setBackgroundColor(colorEasy(rgb))//ffb8b0b0
                        activity_main.setBackgroundColor(colorEasy(rgb))//ffb8b0b0
//                        if (Build.VERSION.SDK_INT >= 21) {
//                            val window = this@LoadBigImageActivity.getWindow()
//                            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//                            window.setStatusBarColor(colorEasy(rgb))
//                            //底部导航栏
////                            window.setNavigationBarColor(colorEasy(rgb));
//                        }
                    }
                }
            }
        })
    }

    private fun colorEasy(RGBValues: Int): Int {
        var red = RGBValues shr 16 and 0xff
        var green = RGBValues shr 8 and 0xff
        var blue = RGBValues and 0xff
        if (red == 0) {
            red = 10
        }
        if (green == 0) {
            green = 10
        }
        if (blue == 0) {
            blue = 10
        }
        red = Math.floor(red * (1 + 0.1)).toInt()
        green = Math.floor(green * (1 + 0.1)).toInt()
        blue = Math.floor(blue * (1 + 0.1)).toInt()
        return Color.rgb(red, green, blue)
    }

}