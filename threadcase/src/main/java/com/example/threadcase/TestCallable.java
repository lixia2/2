package com.example.threadcase;

import java.util.concurrent.*;

class TestRunnable implements Runnable{
    @Override
    public void run() {
/*        try {
            int  a = 10/0;
        }catch (Exception e){
            e.printStackTrace();
        }*/
        int  a = 10/0;
    }
}
class TestCallable implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int  a = 10/0;
        return 1;
    }
}
class test{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // submit方法不会打印异常，execute会打印异常
        // try catch 捕获异常程序会接着往下走，throws不会
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<?> submit = executorService.submit(new TestRunnable());
        System.out.println(submit.get());
        System.out.println("1");
        executorService.submit(new TestCallable());
        System.out.println("2");
//        executorService.execute(new TestRunnable());
    }
}