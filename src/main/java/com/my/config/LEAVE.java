package com.my.config;

public enum LEAVE {
    LV1(1),LV2(2),LV3(3);

    int info;
    LEAVE(int info)
    {
        this.info = info;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }
}
