package com.my.config;

public class Mouse {
    private volatile static boolean Down;
    static {
        Down = false;
    }
    public  synchronized static void down() {
        Down = true;
    }
    public synchronized static void up() {
        Down = false;
    }

    public static synchronized boolean isDown() {
        return Down;
    }

    public static synchronized void setDown(boolean down) {
        Down = down;
    }
}
