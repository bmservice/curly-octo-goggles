public class TestPriority extends Thread{
    public TestPriority(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println(getName()+"#"+getPriority()+"#"+i);
        }
    }

    public static void main(String[] args) {
        Thread.currentThread().setPriority(6);
        for (int i=0;i<20;i++){
            if (i==5){
            TestPriority t1=new TestPriority("haha");
            t1.start();
            System.out.println("优先级"+t1.getPriority());
            t1.setPriority(MIN_PRIORITY);
        }
            if (i==10){
                TestPriority t2=new TestPriority("xixi");
                t2.start();
                System.out.println("优先级"+t2.getPriority());
                t2.setPriority(MAX_PRIORITY);
            }
        }
    }
}
