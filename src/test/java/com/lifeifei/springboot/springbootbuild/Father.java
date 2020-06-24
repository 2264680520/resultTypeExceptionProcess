package com.lifeifei.springboot.springbootbuild;

public class Father {
    public Father(String name) {
        this.name = name;
    }

    private String name;

    public void show(){
        System.out.println(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
