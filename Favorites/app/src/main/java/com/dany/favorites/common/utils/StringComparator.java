package com.dany.favorites.common.utils;

import java.util.Comparator;

/**
 * Created by dan.y on 2016/12/14.
 */

public class StringComparator implements Comparator<String> {
    /*
     * int compare(Object o1, Object o2) 返回一个基本类型的整型，
     * 返回负数表示：o1 大于o2，
     * 返回0 表示：o1和o2相等，
     * 返回正数表示：o1小于o2。
     */
    public int compare(String o1, String o2) {
        return (o1.toLowerCase()).compareTo(o2.toLowerCase());
    }
}
