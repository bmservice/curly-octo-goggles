public interface Test07 {
    void run();
    static void show(){
        System.out.println("static");
    }
    default void  see(){
        System.out.println("default");
    }
    default void look(){
        System.out.println("look");
    }
}
class Test071 implements Test07{

    @Override
    public void run() {
        System.out.println("run");
    }

    @Override
    public void see() {
        System.out.println("see2");
    }

    public static void main(String[] args) {
        Test07 t=new Test071();
        t.run();
        t.see();
        Test07.show();
        t.look();
    }
}