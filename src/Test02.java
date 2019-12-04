import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Test02 {


    public static void main(String[] args) {
        Test02 test02=new Test02();
        test02.getAgfe(1);

    }
    int age=10;
    public int setAge(){
        age-=2;
        return age;
    }
    public void getAgfe(int a){
        a=setAge();
        System.out.println("年龄:"+a);
    }
}
