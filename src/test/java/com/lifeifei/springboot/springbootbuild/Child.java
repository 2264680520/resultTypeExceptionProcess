package com.lifeifei.springboot.springbootbuild;

public class Child extends Father{

    public Child() {
        super("飞机");
    }

    public void show2(){
        System.out.println(this.getName());
    }

}
