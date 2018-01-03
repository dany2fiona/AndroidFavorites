package com.dany.favorites.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dan.y on 2016/12/14.
 */

public class Utility {
    /**
     *Validate telephone
     *@param mobiles
     * return
     */
    public static boolean isMobileNum(String mobiles){
        Pattern p = Pattern.compile(
                "^((13[0-9])|(14[5,7])|(15[^4,\\D]|(17[0136-8])|(18[0-9])))\\d{8}$"
        );
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }


    public static String encryptPhoneNo(String phoneNo){
        int first = 3;
        int end = 7;
        StringBuffer sb = new StringBuffer();
        sb.append(phoneNo.substring(0,first));
        sb.append("****");
        sb.append(phoneNo.substring(end,phoneNo.length()));
        return sb.toString();
    }


    //"欧洲红酒12瓶"---->"欧洲红酒"
    public static String convertStkcode2Name(String stkcode){
        StringBuffer sb = new StringBuffer();
        if(stkcode!=null && !stkcode.equals("")){
            char num[] = stkcode.toCharArray();
            for (int i=0;i<num.length;i++){
                if(!Character.isDigit(num[i])){
                    sb.append(num[i]);
                }else{
                    break;
                }
            }
        }
        return sb.toString();
    }


    //判断输入是中文还是英文
    // GENERAL_PUNCTUATION 判断中文的"号
    // CJK_SYMBOLS_AND_PUNCTUATION 判断中文的。号
    // HALFWIDTH_AND_FULLWIDTH_FORMS 判断中文的，号
    /**
     * 是否是中文
     * @param c
     * @return
     */
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

    /**
     * 是否是英文
     * @param
     * @return
     */
    public static boolean isEnglish(String charaString){
        return charaString.matches("^[a-zA-Z]*");
    }

    public static boolean isChinese(String str){
        String regEx = "[\\u4e00-\\u9fa5]+";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        if(m.find())
            return true;
        else
            return false;
    }

    /**
     * 1.2--->1.2.0
     * 1-->1.0.0
     * @param version
     * @return
     */
    public static String formatVersionString(String version){
        if(version.length() == 1) version += ".0.0";
        else if(version.length() == 3) version += ".0";
        return version;
    }

}
