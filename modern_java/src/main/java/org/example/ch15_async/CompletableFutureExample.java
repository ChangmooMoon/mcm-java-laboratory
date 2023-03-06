package org.example.ch15_async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {

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
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        CompletableFuture<Long> a = new CompletableFuture<>();
        CompletableFuture<Long> b = new CompletableFuture<>();
        CompletableFuture<Long> c = a.thenCombine(b, (y, z) -> y + z);
        executorService.submit(() -> a.complete(f()));
        executorService.submit(() -> b.complete(g()));

        System.out.println(c.get());

        executorService.shutdown();
    }
}
