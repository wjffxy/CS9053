package edu.nyu.cs9053.homework10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * User: blangel
 */
public class ModernFortification implements Fortification<ExecutorService>, ConcurrencyFactorProvider {
    
    private final ExecutorService executor;

    private final int concurrencyFactor;

    protected ModernFortification(int concurrencyFactor) {
        this.executor = Executors.newFixedThreadPool(concurrencyFactor);
        this.concurrencyFactor = concurrencyFactor;
    }

    public void handleAttack(AttackHandler handler) {
        executor.execute(new Runnable() {
            @Override public void run() {
                handler.soldiersReady();
            }
        });
    }

    public void surrender() {
        executor.shutdown();
    }

    public int getConcurrencyFactor() {
        return concurrencyFactor;
    }

}
