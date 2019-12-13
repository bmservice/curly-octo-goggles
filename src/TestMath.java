import java.util.Random;

public class TestMath {
    public static void main(String[] args) {
        System.out.println("floor"+Math.floor(-1.3));
        System.out.println("ceil"+Math.ceil(4.5));
        System.out.println("round"+Math.round(2.5));
        System.out.println("sqrt"+Math.sqrt(3.6));

        System.out.println(new Random().nextInt(10));
    }
}
