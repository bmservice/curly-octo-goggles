import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TestThread  extends Thread {
    public TestThread(String name){
        super(name);
    }

    @Override
    public void run() {
        int i=0;
        for (;i<10;i++){
            System.out.println(getName()+"#"+i);
        }
    }

    public static void main(String[] args) throws Exception{
        new TestThread("线程").start();
        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"#"+i);
            if(i==5){
                TestThread t=new TestThread("被join线程:");
                t.start();
                t.join();
            }
        }
    }
}
