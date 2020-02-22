package edu.nyu.cs9053.homework10;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyThreadPoolImp implements MyThreadPool {
    
    private final BlockingQueue<Runnable> taskQueue;
    private final MyThread[] myThreads;
    private final int concurrencyFactor;
    
    public MyThreadPoolImp(int concurrencyFactor) {
        this.concurrencyFactor = concurrencyFactor;
        taskQueue = new LinkedBlockingQueue<Runnable>(concurrencyFactor);
        myThreads = new MyThread[concurrencyFactor];
        
        for (int i=0; i< concurrencyFactor; i++) {
            myThreads[i] = new MyThread(taskQueue);
            myThreads[i].start();
        }
    }
    
    @Override
    public synchronized void submit(Runnable runnable) {
        if (runnable  == null) {
            throw new IllegalArgumentException("submit runnable can not be null");
        }
        try {
            taskQueue.put(runnable);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(ie);
        }
    }
    
    @Override
    public synchronized void stop() {
        for (MyThread myThread : myThreads) {
            myThread.terminate();
        }
    }
}

