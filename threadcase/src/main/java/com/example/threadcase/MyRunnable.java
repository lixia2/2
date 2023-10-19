package com.example.threadcase;

public class MyRunnable implements Runnable{
    private String name;
    public MyRunnable(String name){
        this.name=name;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("调用者:" + name +", 线程名称:"+Thread.currentThread().getName()+", i:"+ i);
        }
    }

    public static void main(String[] args) {
        new Thread(new MyRunnable("A")).start();
        new Thread(new MyRunnable("B")).start();
    }
}
