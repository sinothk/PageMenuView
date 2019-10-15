package com.sinothk.menu.pageMenu.holder;

import android.view.View;

/**
 * time: 2019/2/17
 * mail:xhb_199409@163.com
 * github:https://github.com/xiaohaibin
 * describe:PageMenuViewHolderCreator
 * @author xiao.haibin
 */
public interface PageMenuViewHolderCreator {

    int getLayoutId();

    AbstractHolder createHolder(View itemView);
}
