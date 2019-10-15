package com.sinothk.plugin.menu.pageMenu.demo;

import android.app.Application;

import com.sinothk.plugin.menu.pageMenu.demo.utils.ScreenUtil;

/**
 * Author: Mr.xiao on 2017/5/24
 *
 * @mail:xhb_199409@163.com
 * @github:https://github.com/xiaohaibin
 * @describe:
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ScreenUtil.init(this);
    }
}
