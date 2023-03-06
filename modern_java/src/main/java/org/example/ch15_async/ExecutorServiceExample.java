package org.example.ch15_async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {

    public static Long f() {
        long start = System.currentTimeMillis();
        Long ret = 0L;
        for (int i = 0; i < 1000000; i++) {
            ret += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("f(): " + (end - start));
        return ret;
    }

    public static Long g() {
        long start = System.currentTimeMillis();
        Long ret = 0L;
        for (int i = 0; i < 10000000; i++) {
            ret += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("g(): " + (end - start));
        return ret;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Long> y = executorService.submit(ExecutorServiceExample::f);
        Future<Long> z = executorService.submit(ExecutorServiceExample::g);

        System.out.println(y.get());
        System.out.println(z.get());

        executorService.shutdown();
    }
}
