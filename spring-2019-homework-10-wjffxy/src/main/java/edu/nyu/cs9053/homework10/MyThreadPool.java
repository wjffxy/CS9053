package edu.nyu.cs9053.homework10;

public interface MyThreadPool {
    
    void submit(Runnable runnable);
    
    void stop();
}
