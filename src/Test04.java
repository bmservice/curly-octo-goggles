public class Test04 {
    public void test(int a){
         a=5;
        System.out.println("test"+a);
    }
    public static void main(String[] args) {
       Test04 t=new Test04();
       int a=3;
       t.test(a);
        System.out.println("main"+a);

    }
}
