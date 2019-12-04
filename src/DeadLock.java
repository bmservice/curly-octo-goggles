import javax.sound.midi.Soundbank;

public class DeadLock implements Runnable{
    A a=new A();
    B b=new B();
    public void init(){
        Thread.currentThread().setName("主线程");
        a.foo(b);
        System.out.println("进入主线程后");
    }
    @Override
    public void run() {
        Thread.currentThread().setName("副线程");

        b.bar(a);
        System.out.println("进入线程后");
    }

    public static void main(String[] args) {
        DeadLock d=new DeadLock();
        new Thread(d).start();
        d.init();
    }
}
class A{
    public synchronized void foo(B b){
        System.out.println("线程名"+Thread.currentThread().getName());
        try {
        Thread.sleep(100);
        }catch (Exception e){
            e.printStackTrace();
        }
        b.last();
    }
    public synchronized void last(){
        System.out.println("死锁");
    }
}
class B{
    public synchronized void bar(A a){
        System.out.println("当前线程名"+Thread.currentThread().getName());
        try {
            Thread.sleep(100);
        }catch (Exception e){
            e.printStackTrace();
        }
        a.last();
    }
    public synchronized void last(){
        System.out.println("死锁");
    }
}