package cn.com.gzx.strategy.impl;

import cn.com.gzx.strategy.FlyBehavior;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        //什么都不做，不会飞
        System.out.println("什么都不做，不会飞");
    }
}
