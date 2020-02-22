package edu.nyu.cs9053.homework10;

/**
 * User: blangel
 */
public class MiddleAgesFortification extends AbstractConcurrencyFactorProvider implements Fortification<Thread> {
    
    private final MyThreadPool myThreadPool;
    
    protected MiddleAgesFortification(int concurrencyFactor) {
        super(concurrencyFactor);
        myThreadPool = new MyThreadPoolImp(concurrencyFactor);
    }
   
    @Override
    public void handleAttack(AttackHandler handler) {
        myThreadPool.submit(new Runnable() {
            @Override
            public void run() {
                handler.soldiersReady();
            }
        });
     
    }
    
    @Override
    public void surrender() {
        myThreadPool.stop();
    }
    
}
