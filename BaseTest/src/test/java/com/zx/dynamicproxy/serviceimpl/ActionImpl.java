package com.zx.dynamicproxy.serviceimpl;

import com.zx.dynamicproxy.service.Action;


public class ActionImpl implements Action {
    @Override
    public void eat() {
        System.out.println("在吃了!");
    }
}
