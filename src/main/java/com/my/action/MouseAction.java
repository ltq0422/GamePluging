package com.my.action;

import com.my.config.Config;
import com.my.config.Key;
import com.my.config.LEAVE;
import com.my.config.Mouse;

import java.awt.*;

public class MouseAction implements Runnable {
    @Override
    public void run() {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        while(true)
        {
            if(Mouse.isDown() && Key.isAction())
            {
                LEAVE leave = Key.getLeave();
                if(leave.getInfo() == 1)
                {
                    Point point=MouseInfo.getPointerInfo().getLocation();
                    robot.mouseMove(point.x,point.y + Config.height_lv1);
                    try {
                        Thread.sleep(Config.time_lv1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(leave.getInfo() == 2)
                {
                    Point point=MouseInfo.getPointerInfo().getLocation();
                    robot.mouseMove(point.x,point.y + Config.height_lv2);
                    try {
                        Thread.sleep(Config.time_lv2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(leave.getInfo() == 3)
                {
                    Point point=MouseInfo.getPointerInfo().getLocation();
                    robot.mouseMove(point.x,point.y + Config.height_lv3);
                    try {
                        Thread.sleep(Config.time_lv3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }




//                Point point=MouseInfo.getPointerInfo().getLocation();
//                robot.mouseMove(point.x,point.y + 12);
//                try {
//                    Thread.sleep(20);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }


            }
        }
    }
}
