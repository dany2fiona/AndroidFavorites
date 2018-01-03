package com.dany.favorites.common.utils;

import android.text.format.DateUtils;
import android.view.View;
import android.widget.ExpandableListView;

import com.dany.favorites.global.FavorApp;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshExpandableListView;


/**
 * Created by dan.y on 2017/4/20.
 */

public class RefreshExpandableListViewUtils {

    public static void initRefreshExpandableListView(PullToRefreshExpandableListView refreshListView, PullToRefreshBase.Mode mode){//上拉下拉模式
        refreshListView.setMode(mode);
        refreshListView.getLoadingLayoutProxy(true, true).setLoadingDrawable(null);
        if (mode.equals(PullToRefreshBase.Mode.BOTH)){
            refreshListView.getLoadingLayoutProxy(true, false).setReleaseLabel(
                    "松开即刻刷新");
            refreshListView.getLoadingLayoutProxy(false, true).setReleaseLabel(
                    "松开加载更多");
        }else if(mode.equals(PullToRefreshBase.Mode.PULL_FROM_START)){
            refreshListView.getLoadingLayoutProxy(true, false).setReleaseLabel(
                    "松开即刻刷新");
        }
        changeRefreshTime(refreshListView);
    }

    public static void changeRefreshTime(PullToRefreshExpandableListView refreshListView) {
        String label = DateUtils.formatDateTime(FavorApp.Companion.getInstance(),
                System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME
                        | DateUtils.FORMAT_SHOW_DATE
                        | DateUtils.FORMAT_ABBREV_ALL);
        refreshListView.getLoadingLayoutProxy(true, true).setLastUpdatedLabel(
                label);
    }

    //解决有网和无网两次刷新间隔很短照成的无网加载失败但提示title布局常在消失不了
    public static void onRefreshComplete(final PullToRefreshExpandableListView refreshListView){
        refreshListView.postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshListView.onRefreshComplete();
            }
        }, 100);
    }

    // 去掉系统默认的箭头图标 --// 点击Group不收缩
    public static void initExpandableListView(ExpandableListView listView){
        listView.setGroupIndicator(null);
        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                return true;
            }
        });
    }


}
