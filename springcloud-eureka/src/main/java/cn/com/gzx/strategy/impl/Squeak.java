package cn.com.gzx.strategy.impl;

import cn.com.gzx.strategy.QuackBehavior;

public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        //实现吱吱叫的鸭子
        System.out.println("实现吱吱叫的鸭子");
    }
}
