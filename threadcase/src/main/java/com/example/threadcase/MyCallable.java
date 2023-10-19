package com.example.threadcase;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.util.StopWatch;

import java.util.concurrent.*;

public class MyCallable implements Callable<String>{
    private String name;
    public MyCallable(String name){
        this.name=name;
    }
    @Override
    public String call() throws Exception {
        //       1s【秒】 = 1000ms【毫秒】
        //  1ms【毫秒】 = 1000μs【微秒】
        //   1μs【微秒】 = 1000ns【纳秒】
        //  1ns 【纳秒】= 1000ps【皮秒】
        // stopWatch统计开始与结束耗时时间，等价于end-start
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("测试stopWatch");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            System.out.println("调用者:" + name +", 线程名称:"+Thread.currentThread().getName()+", i:"+ i);
        }
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        stopWatch.stop();
        System.out.println("耗时"+(end-start));
        System.out.println(stopWatch.prettyPrint());
        return name+"成功啦";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

    }

}
class firstMethodCallable{
    public static void main(String[] args) {
        // Callable两种执行方式
        // 第一种，FutureTask类同时实现了两个接口，Future和Runnable接口，所以它既可以作为Runnable被线程执行，又可以作为Future得到Callable的返回值
        FutureTask<String> futureTaskA = new FutureTask<>(new MyCallable("A"));
        new Thread(futureTaskA).start();
        new Thread(new FutureTask<>(new MyCallable("B"))).start();
        try {
            System.out.println("futureTaskA执行结果"+futureTaskA.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
class secondMethodCallable{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 第二种方式 创建一个线程池
        ExecutorService executor = Executors.newCachedThreadPool();
//        ThreadPoolExecutor executor1 = new ThreadPoolExecutor();
//        executor1.execute();
//        executor1.submit()
        Executors.newFixedThreadPool(2);
        // submit即可以处理runnable接口，也可以callable, 有返回值callable，没有runnabl
        // callable接口
        Future<String> future1 = executor.submit(() -> {
            TimeUnit.SECONDS.sleep(5);
            System.out.println("处理业务逻辑...");
            return "CallableTest";
        });
        System.out.println("submit方法有返回值"+future1.get());
        // runnabl接口
        Future<?> future2 = executor.submit(() -> {
            System.out.println("处理业务逻辑...");
        });
        System.out.println("submit方法没有返回值"+future2.get());
        // 等价写法
        Future<?> future3 = executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("处理业务逻辑...");
            }
        });
        System.out.println("submit方法没有返回值另一种写法"+future3.get());

        // execute 方法只能处理runnable接口
        executor.execute(()->{
            System.out.println("处理业务逻辑...");
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("处理业务逻辑...");
            }
        });
        executor.shutdown();
    }
}