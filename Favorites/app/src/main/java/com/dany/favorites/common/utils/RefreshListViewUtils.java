package com.dany.favorites.common.utils;

import android.text.format.DateUtils;

import com.dany.favorites.global.FavorApp;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshListView;


/**
 * Created by dan.y on 2016/12/26.
 */

public class RefreshListViewUtils {

    public static void initRefreshListView(PullToRefreshListView refreshListView, Mode mode){//上拉下拉模式
        refreshListView.setMode(mode);
        refreshListView.getLoadingLayoutProxy(true, true).setLoadingDrawable(null);
        if (mode.equals(Mode.BOTH)){
            refreshListView.getLoadingLayoutProxy(true, false).setReleaseLabel(
                    "松开即刻刷新");
            refreshListView.getLoadingLayoutProxy(false, true).setReleaseLabel(
                    "松开加载更多");
        }else if(mode.equals(Mode.PULL_FROM_START)){
            refreshListView.getLoadingLayoutProxy(true, false).setReleaseLabel(
                    "松开即刻刷新");
        }
        changeRefreshTime(refreshListView);
    }

    public static void changeRefreshTime(PullToRefreshListView refreshListView) {
        String label = DateUtils.formatDateTime(FavorApp.Companion.getInstance(),
                System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME
                        | DateUtils.FORMAT_SHOW_DATE
                        | DateUtils.FORMAT_ABBREV_ALL);
        refreshListView.getLoadingLayoutProxy(true, true).setLastUpdatedLabel(
                label);
    }

    //解决有网和无网两次刷新间隔很短照成的无网加载失败但提示title布局常在消失不了
    public static void onRefreshComplete(final PullToRefreshListView refreshListView){
        refreshListView.postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshListView.onRefreshComplete();
            }
        }, 100);
    }

}
