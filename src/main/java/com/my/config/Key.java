package com.my.config;

public class Key {
    private volatile static LEAVE Leave;

    private volatile static boolean Action;

    static {
        Action = false;
        Leave = LEAVE.LV1;
    }

    public synchronized static void lv1()
    {
        Leave = LEAVE.LV1;
    }
    public synchronized static void lv2()
    {
        Leave = LEAVE.LV2;
    }
    public synchronized static void lv3()
    {
        Leave = LEAVE.LV3;
    }

    public synchronized static void start()
    {
        Action = true;
    }
    public synchronized static void stop()
    {
        Action = false;
    }

    public synchronized static LEAVE getLeave() {
        return Leave;
    }

    public synchronized static void setLeave(LEAVE leave) {
        Leave = leave;
    }

    public synchronized static boolean isAction() {
        return Action;
    }

    public synchronized static void setAction(boolean action) {
        Action = action;
    }
}
