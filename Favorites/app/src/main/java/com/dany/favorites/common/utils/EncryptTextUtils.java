package com.dany.favorites.common.utils;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import android.widget.ImageView;



/**
 * Created by dan.y on 2017/2/7.
 */

public class EncryptTextUtils {

    /**
     * 通用切换明文和密文显示密码
     * @param et
     * @param iv
     * @param isEyeOpen
     */
    public static void changeCodeEyestate(EditText et, ImageView iv, boolean isEyeOpen){
        if(isEyeOpen){
            //如果选中，显示密码
            et.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            et.setSelection(et.getText().toString().length());
//            iv.setImageResource(R.mipmap.code_eye_open);
        }else{
            //否则隐藏密码
            et.setTransformationMethod(PasswordTransformationMethod.getInstance());
            et.setSelection(et.getText().toString().length());
//            iv.setImageResource(R.mipmap.code_eye_close);
        }
    }

    //默认密文
    public static void closeCodeEye(EditText et){
            //隐藏密码
            et.setTransformationMethod(PasswordTransformationMethod.getInstance());
            et.setSelection(et.getText().toString().length());
    }
}
