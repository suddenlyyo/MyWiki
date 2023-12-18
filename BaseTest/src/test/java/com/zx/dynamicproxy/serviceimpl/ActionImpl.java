package com.zx.dynamicproxy.serviceimpl;

import com.zx.dynamicproxy.service.Action;


public class ActionImpl implements Action {
    @Override
    public String eat() {
        return "在吃了！";
    }
}
