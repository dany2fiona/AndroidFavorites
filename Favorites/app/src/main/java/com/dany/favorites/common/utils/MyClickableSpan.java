package com.dany.favorites.common.utils;

import android.text.TextPaint;
import android.text.style.ClickableSpan;

/**
 * 不带下划线可以设置字体颜色和背景色的超链接样式
 * Created by dan.y on 2016/12/22.
 */

public abstract class MyClickableSpan extends ClickableSpan {
    private int textColor;
    private int bgColor;

    public MyClickableSpan(int textColor, int bgColor) {
        this.textColor = textColor;
        this.bgColor = bgColor;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setColor(textColor);
        ds.setUnderlineText(false);
        ds.setAntiAlias(true);
        ds.bgColor = bgColor;
    }
}
