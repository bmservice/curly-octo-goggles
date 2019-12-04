public class TestThreadLocal extends Thread{
    private TH th;
    public TestThreadLocal(TH th,String name){
        super(name);
        this.th=th;

    }

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            if(i==6){
                th.setName(getName());
            }
            System.out.println(th.getName()+"账户的i值"+i);
        }
    }

    public static void main(String[] args) {
        TH th=new TH("初始名");
        new TestThreadLocal(th,"甲").start();
        new TestThreadLocal(th,"乙").start();
    }
}
class TH{
    private ThreadLocal<String> name=new ThreadLocal<>();
    public TH(String str){
        this.name.set(str);
        System.out.println("---"+this.name.get());
    }

    public String  getName() {
        return name.get();
    }

    public void setName(String str) {
       this.name.set(str);
    }

    @Override
    public String toString() {
        return "TH{" +
                "name=" + name +
                '}';
    }
}
