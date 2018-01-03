package com.dany.favorites.common.utils;

import android.text.format.DateUtils;

import com.dany.favorites.global.FavorApp;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshWebView;


/**
 * Created by dan.y on 2016/10/22..
 */

public class RefreshWebViewUtils {

    public static void initRefreshWebView(PullToRefreshWebView refreshWebView, Mode mode){//上拉下拉模式
        refreshWebView.setMode(mode);
        refreshWebView.getLoadingLayoutProxy(true, true).setLoadingDrawable(null);
        if (mode.equals(Mode.BOTH)){
            refreshWebView.getLoadingLayoutProxy(true, false).setReleaseLabel(
                    "松开即刻刷新");
            refreshWebView.getLoadingLayoutProxy(false, true).setReleaseLabel(
                    "松开加载更多");
        }else if(mode.equals(Mode.PULL_FROM_START)){
            refreshWebView.getLoadingLayoutProxy(true, false).setReleaseLabel(
                    "松开即刻刷新");
        }
        changeRefreshTime(refreshWebView);
    }

    public static void changeRefreshTime(PullToRefreshWebView refreshWebView) {
        String label = DateUtils.formatDateTime(FavorApp.Companion.getInstance(),
                System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME
                        | DateUtils.FORMAT_SHOW_DATE
                        | DateUtils.FORMAT_ABBREV_ALL);
        refreshWebView.getLoadingLayoutProxy(true, true).setLastUpdatedLabel(
                label);
    }

    //解决有网和无网两次刷新间隔很短照成的无网加载失败但提示title布局常在消失不了
    public static void onRefreshComplete(final PullToRefreshWebView refreshWebView){
        refreshWebView.postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshWebView.onRefreshComplete();
            }
        }, 100);
    }

}
