package com.oycm.algorithm;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ouyangcm
 * create 2024/4/1 13:35
 */
public class App {

    public static void main(String[] args) {
        ThreadPoolExecutor executorPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
//        executorPool.execute(()->{
//            System.out.println(Thread.currentThread().getName());
//        });
        System.out.println(1 << 32);
        System.out.println(1 | 1);
    }
}
