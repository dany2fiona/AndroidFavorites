package com.dany.favorites.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;


import java.util.List;


/**
 * Created by dan.y on 2016/12/20.
 */


public class IntentUtils {
    public final static String TAG_BUNDLE_ARGS = "tag_bundle_args";
    public final static String TAG_BUNDLE_ARGS_1 = "tag_bundle_args_1";
    public final static int TAG_INTENT_REQUEST_CODE = 0X0010;
    public final static int TAG_INTENT_RESULT_CODE = 0X0011;


//    public static void gotoLogin(Context context) {
//        Intent intent =  new Intent(context, LoginActivity.class);
//        context.startActivity(intent);
//    }
//
//    public static void gotoLoginForResult(Activity context, Bundle bundle) {
//        Intent intent =  new Intent(context, LoginActivity.class);
//         if(bundle != null){
//            intent.putExtras(bundle);
//        }
//        context.startActivityForResult(intent,TAG_INTENT_REQUEST_CODE);
//    }

    /**
     * 无返回值activity跳转公用方法
     * @param context
     * @param cls
     * @param bundle
     */
    public static void gotoNextActivity(Context context, Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(context,cls);
        if(bundle != null){
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }

    public static void gotoNextActivityForResult(Activity context, Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(context,cls);
        if(bundle != null){
            intent.putExtras(bundle);
        }
        context.startActivityForResult(intent,TAG_INTENT_REQUEST_CODE);
}

    /**
     * 跳转原生指定页面
     * @param context
     * @param url
     */
    public static SchemeIntent isSchemeValidToStartActivity(Context context, String url){
        boolean isValidInit = false;
        SchemeIntent schemeIntent = new SchemeIntent();
        if(url.startsWith("qyhapp://activity:8888/")){
            isValidInit = true;
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
            boolean isValid = !activities.isEmpty();
            isValidInit = isValidInit && isValid;
            schemeIntent.setIntent(intent);
            schemeIntent.setValid(isValidInit);
        }else{
            isValidInit = false;
            schemeIntent.setValid(isValidInit);
        }

        return schemeIntent;
    }

    public static class SchemeIntent{
        private boolean isValid;
        private Intent intent;

        public SchemeIntent() {
        }

        public SchemeIntent(boolean isValid, Intent intent) {
            this.isValid = isValid;
            this.intent = intent;
        }

        public boolean isValid() {
            return isValid;
        }

        public void setValid(boolean valid) {
            isValid = valid;
        }

        public Intent getIntent() {
            return intent;
        }

        public void setIntent(Intent intent) {
            this.intent = intent;
        }
    }

}
