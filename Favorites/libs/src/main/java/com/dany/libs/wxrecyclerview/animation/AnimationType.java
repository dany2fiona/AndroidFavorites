package com.dany.libs.wxrecyclerview.animation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.dany.libs.wxrecyclerview.BaseQuickAdapter.ALPHAIN;
import static com.dany.libs.wxrecyclerview.BaseQuickAdapter.CUSTOMIN;
import static com.dany.libs.wxrecyclerview.BaseQuickAdapter.SCALEIN;
import static com.dany.libs.wxrecyclerview.BaseQuickAdapter.SLIDEIN_BOTTOM;
import static com.dany.libs.wxrecyclerview.BaseQuickAdapter.SLIDEIN_BOTTOM_TOP;
import static com.dany.libs.wxrecyclerview.BaseQuickAdapter.SLIDEIN_LEFT;
import static com.dany.libs.wxrecyclerview.BaseQuickAdapter.SLIDEIN_LEFT_RIGHT;
import static com.dany.libs.wxrecyclerview.BaseQuickAdapter.SLIDEIN_RIGHT;


/**
 * Created by boby on 2016/12/11.
 */
@IntDef({ALPHAIN, SCALEIN, SLIDEIN_BOTTOM, SLIDEIN_LEFT, SLIDEIN_RIGHT, SLIDEIN_LEFT_RIGHT, SLIDEIN_BOTTOM_TOP, CUSTOMIN})
@Retention(RetentionPolicy.RUNTIME)
public @interface AnimationType {

}
