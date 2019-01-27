package cn.com.gzx.strategy.impl;

import cn.com.gzx.strategy.QuackBehavior;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        //什么都不做，不会叫
        System.out.println("什么都不做，不会叫");
    }
}
