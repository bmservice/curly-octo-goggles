public class TestDeadLock extends Thread{
    private Object o1=new Object();
    private Object o2=new Object();

    public void m2(){
        synchronized (o2){
            System.out.println(Thread
            .currentThread().getName()+"获得对象o2锁");
            try {
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }
            try {
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }
            run();
        }
    }

    @Override
    public void run() {
        synchronized (o1){
            System.out.println(Thread.currentThread().getName()+"获得对象o1锁");
            try {
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }
            m2();
        }
    }

    public static void main(String[] args) {
        TestDeadLock t=new TestDeadLock();
        new Thread(t).start();
        t.m2();
    }

}
