public abstract class Activite implements Runnable{
    
    private boolean alive;
    private long delay;
    
    public Activite() {
        setAlive(true);
        this.setDelay(100);
    }
    
    public boolean isAlive() {
        return this.alive;
    }
    
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
    public long getDelay() {
        return this.delay;
    }
    
    public void setDelay(long delay) {
        this.delay = delay;
    }
    
    public void start() {
        Thread t = new Thread(this);
        t.start();
    }
    
    public void stop() {
        this.setAlive(false);
    }
    
    protected abstract void action();
    
    public void run() {
        try{
            while(isAlive()){
                action();
                Thread.sleep(getDelay());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }  
}
