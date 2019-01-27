package cn.com.gzx.strategy.impl;

import cn.com.gzx.strategy.Duck;

public class MallardQuck extends Duck {

    public MallardQuck() {
    }

    public static void main(String[] args) {
        MallardQuck mallardQuack = new MallardQuck();
        mallardQuack.setFlyBehavior(new FlyWithWings());
        mallardQuack.setQuackBehavior(new MuteQuack());
        mallardQuack.performFly();
        mallardQuack.performQuack();
    }

    @Override
    public void display() {
        //显示不同鸭子的颜色
        System.out.println("显示不同鸭子的颜色");
    }
}
