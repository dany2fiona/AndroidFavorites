package com.dany.favorites.common.utils;

import android.text.format.DateUtils;

import com.dany.favorites.global.FavorApp;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;


/**
 * Created by dan.y on 2016/12/29.
 */

public class RefreshScrollViewUtils {

    public static void initRefreshScollView(PullToRefreshScrollView refreshScrollView, Mode mode){//上拉下拉模式
        refreshScrollView.setMode(mode);
        refreshScrollView.getLoadingLayoutProxy(true, true).setLoadingDrawable(null);
        if (mode.equals(Mode.BOTH)){
            refreshScrollView.getLoadingLayoutProxy(true, false).setReleaseLabel(
                    "松开即刻刷新");
            refreshScrollView.getLoadingLayoutProxy(false, true).setReleaseLabel(
                    "松开加载更多");
        }else if(mode.equals(Mode.PULL_FROM_START)){
            refreshScrollView.getLoadingLayoutProxy(true, false).setReleaseLabel(
                    "松开即刻刷新");
        }
        changeRefreshTime(refreshScrollView);
    }

    public static void changeRefreshTime(PullToRefreshScrollView refreshScrollView) {
        String label = DateUtils.formatDateTime(FavorApp.Companion.getInstance(),
                System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME
                        | DateUtils.FORMAT_SHOW_DATE
                        | DateUtils.FORMAT_ABBREV_ALL);
        refreshScrollView.getLoadingLayoutProxy(true, true).setLastUpdatedLabel(
                label);
    }

    //解决有网和无网两次刷新间隔很短照成的无网加载失败但提示title布局常在消失不了
    public static void onRefreshComplete(final PullToRefreshScrollView refreshScrollView){
        refreshScrollView.postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshScrollView.onRefreshComplete();
            }
        }, 100);
    }

}
