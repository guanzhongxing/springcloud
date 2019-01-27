package cn.com.gzx.strategy.impl;

import cn.com.gzx.strategy.FlyBehavior;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        //实现所有有翅膀的鸭子的飞行行为
        System.out.println("实现所有有翅膀的鸭子的飞行行为");
    }
}
