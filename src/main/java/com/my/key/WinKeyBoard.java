package com.my.key;

import com.my.config.Key;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;



public class WinKeyBoard implements Runnable {
    private static WinUser.HHOOK hhk;
    private static WinUser.LowLevelKeyboardProc keyboardHook;
    final static User32 lib = User32.INSTANCE;
    private boolean[] on_off = null;

    public WinKeyBoard(boolean[] on_off) {
        this.on_off = on_off;
    }

    @Override
    public void run() {
        WinDef.HMODULE hMod = Kernel32.INSTANCE.GetModuleHandle(null);

        keyboardHook = new WinUser.LowLevelKeyboardProc() {
            public WinDef.LRESULT callback(int nCode, WinDef.WPARAM wParam, WinUser.KBDLLHOOKSTRUCT info) {

//                System.out.println("运行成功，控制台输出:"+info.vkCode);
                switch (info.vkCode){
                    case 112:
                        Key.lv1();
                        break;
                    case 113:
                        Key.lv2();
                        break;
                    case 114:
                        Key.lv3();
                        break;
                    case 115:
                        if(info.flags == 0)
                        {
                            if(Key.isAction())
                            {
                                Key.stop();
                            }else{
                                Key.start();
                            }
                        }
                        break;
                }


                return lib.CallNextHookEx(hhk, nCode, wParam, info.getPointer());
            }
        };
        hhk = lib.SetWindowsHookEx(User32.WH_KEYBOARD_LL, keyboardHook, hMod, 0);
        int result;
        WinUser.MSG msg = new WinUser.MSG();
        while ((result = lib.GetMessage(msg, null, 0, 0)) != 0) {

        }
        lib.UnhookWindowsHookEx(hhk);
    }
}