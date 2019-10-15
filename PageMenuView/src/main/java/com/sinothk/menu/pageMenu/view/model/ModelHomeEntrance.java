package com.sinothk.menu.pageMenu.view.model;

/**
 * Author: Mr.xiao on 2017/5/23
 *
 * @mail:xhb_199409@163.com
 * @github:https://github.com/xiaohaibin
 * @describe:菜单项实体类
 */
public class ModelHomeEntrance {

    private String name = "";
    private int image;

    public ModelHomeEntrance(String name, int image) {
        this.image = image;
        this.name = name;
    }


    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
