package com.dany.favorites.common.glide

import android.content.Context

import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator
import com.bumptech.glide.module.GlideModule

/**
 * Created by dan.y on 2017/6/22
 */
class MyGlideModule : GlideModule {
    override fun applyOptions(context: Context, builder: GlideBuilder) {
        val calculator = MemorySizeCalculator(context)
        val defaultMemoryCacheSize = calculator.memoryCacheSize
        val defaultBitmapBoolSize = calculator.bitmapPoolSize
        val customMemoryCacheSize = (1.2 * defaultMemoryCacheSize).toInt()
        val customBitmapBoolSize = (1.2 * defaultBitmapBoolSize).toInt()
        builder.setMemoryCache(LruResourceCache(customMemoryCacheSize))
        builder.setBitmapPool(LruBitmapPool(customBitmapBoolSize))
        builder.setDiskCache(ExternalCacheDiskCacheFactory(context, "image_cache", 150 * 1024 * 1024))
        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888)
    }

    override fun registerComponents(context: Context, glide: Glide) {

    }
}
