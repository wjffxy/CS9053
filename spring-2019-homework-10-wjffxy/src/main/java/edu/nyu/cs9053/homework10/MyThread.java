package edu.nyu.cs9053.homework10;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class MyThread extends Thread {
    
    private static final Runnable DEFAULT_NULL_RUNNABLE = null;
    private final AtomicBoolean canRunning;
    private final BlockingQueue<Runnable> taskQueue;
    
    public MyThread(BlockingQueue<Runnable> taskQueue) {
        if (taskQueue == null) {
            throw new IllegalArgumentException("task queue can not be null");
        }
        this.taskQueue = taskQueue;
        canRunning = new AtomicBoolean(true);
    }
    
    @Override
    public void run() {
        Runnable runnable = DEFAULT_NULL_RUNNABLE;
        while (!Thread.currentThread().isInterrupted()) {
            try {
                runnable = taskQueue.poll(5, TimeUnit.SECONDS);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
                break;
            }
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (RuntimeException re) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(re);
                }
            }
        }
    }
    
    public synchronized void terminate() {
        this.interrupt();
    }
    
}
