import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Test05 {

    int a=5;
    {
        System.out.println("父类初始化块");
    }
    static {
        System.out.println("父类静态初始化块");
    }

    public Test05(){
        System.out.println("父类构造器");
    }
    public void bear(){
        System.out.println("xixi");
    }
    public static void main(String[] args) {
        Test05 t1=new Test05();
        Test051 t2=new Test051();
        Test05 t3=new Test051();
        System.out.println(t3.a);


    }
}
class Test051 extends Test05{
    int a=3;
    static {
        System.out.println("子类静态初始化块");
    }
    {
        System.out.println("子类初始化块");
    }
    public Test051(){
        System.out.println("子类构造器");
    }
    @Override
    public void bear(){
        System.out.println("haha");
    }

    public static void main(String[] args) {
        Test05 t=new Test051();

        t.bear();
        System.out.println(t.a);
    }
}