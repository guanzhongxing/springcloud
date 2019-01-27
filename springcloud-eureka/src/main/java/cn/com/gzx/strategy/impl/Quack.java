package cn.com.gzx.strategy.impl;

import cn.com.gzx.strategy.QuackBehavior;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        //实现呱呱叫的鸭子
        System.out.println("实现呱呱叫的鸭子");
    }
}
