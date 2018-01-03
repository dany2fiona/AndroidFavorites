package com.dany.favorites.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dan.y on 2018/1/3 9:44.
 */

public class RoboBean implements Parcelable {
    /**
     * code : 100000
     * text : 　　每个人都有可能犯错误，人们时常看到，有些人像中了魔一样，就会捕风捉影。
     　　伊索曾提到的一只狗就有类似这些人的经历。这只狗看到猎物的倒影映在水面上，就性急地朝影子扑了过去。河面上浪花四溅，差点没把狗淹死，狗费了老大的劲才游上岸边，这时它的猎物和影子一同消失得无影无踪。
     */

    private int code;
    private String text;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.code);
        dest.writeString(this.text);
    }

    public RoboBean() {
    }

    protected RoboBean(Parcel in) {
        this.code = in.readInt();
        this.text = in.readString();
    }

    public static final Parcelable.Creator<RoboBean> CREATOR = new Parcelable.Creator<RoboBean>() {
        @Override
        public RoboBean createFromParcel(Parcel source) {
            return new RoboBean(source);
        }

        @Override
        public RoboBean[] newArray(int size) {
            return new RoboBean[size];
        }
    };
}
