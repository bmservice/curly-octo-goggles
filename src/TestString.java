public class TestString {

    public static void main(String[] args) {
        StringBuilder s=new StringBuilder();
        s.append("hello");
        System.out.println(s.toString());
        s.insert(5," java");
        System.out.println(s.toString());
        s.replace(5,6,",");
        System.out.println(s.toString());
        s.delete(5,6);
        System.out.println(s.toString());
        s.reverse();
        System.out.println(s.toString());
        StringBuilder s2=new StringBuilder("stringbuilder");
        System.out.println(s2.capacity());
        s2.append("helloworldhelloworldiamastudenthelloworldiamastudentsfyuguih");
        System.out.println(s2.length());
        System.out.println(s2.capacity());
    }
}

