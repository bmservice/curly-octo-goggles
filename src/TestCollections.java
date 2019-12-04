import java.util.ArrayList;
import java.util.List;

public class TestCollections extends Thread{
    List<String> list=new ArrayList<String>();
    @Override
    public void run() {
       for (int i=0;i<10;i++){
           System.out.println("当前线程:"+Thread.currentThread().getName());
           list.add("a");
       }
       for (int i=0;i<10;i++){
           list.remove("a");
       }
    }

    public static void main(String[] args) {
        new TestCollections().start();
        new TestCollections().start();

    }
}
