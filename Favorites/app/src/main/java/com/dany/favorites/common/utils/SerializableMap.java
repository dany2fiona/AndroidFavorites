package com.dany.favorites.common.utils;

import java.io.Serializable;
import java.util.Map;

/**
 * 序列化map供Bundle传递map使用
 * Created by dan.y on 2017/6/5.
 */

public class SerializableMap implements Serializable {
    private Map<String,Object> map;

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
