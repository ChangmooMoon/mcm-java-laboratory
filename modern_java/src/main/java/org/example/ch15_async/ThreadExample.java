package org.example.ch15_async;

public class ThreadExample {

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

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> System.out.println(f()));
        Thread t2 = new Thread(() -> System.out.println(g()));

        t1.start();
        t2.start();
        t1.join();
        t2.join();

//        System.out.println(f());
//        System.out.println(g());
    }
}
