package com.example.threadcase;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
import org.springframework.boot.context.properties.bind.Name;

public class MyThread extends Thread{
    private String name;
    public MyThread(String name){
        this.name=name;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("调用者:" + name +", 线程名称:"+this.getName()+", i:"+ i);
        }

    }

    public static void main(String[] args) {
        new MyThread("A").start();
        new MyThread("B").start();
    }
}
