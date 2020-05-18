package com.my.main;

import com.my.action.MouseAction;
import com.my.key.WinKeyBoard;
import com.my.mouse.MouseHook;

public class Main {
    public static void main(String[] args) {

        System.out.println("加载配置...");

        MouseHook mh = new MouseHook();
        WinKeyBoard wb = new WinKeyBoard(null);
        MouseAction ma = new MouseAction();

        new Thread(mh).start();
        new Thread(wb).start();
        new Thread(ma).start();

        System.out.println("初始化成功...");
        System.out.println("请勿关闭本窗口！");
    }
}
