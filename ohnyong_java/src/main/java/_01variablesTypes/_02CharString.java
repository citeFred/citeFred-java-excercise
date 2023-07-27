package _01variablesTypes;

public class _02CharString {
    public static void main(String[] args){
//        char a = '안';
//        char b = '녕';
//        char c = '안녕';
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);

        String c = new String("안녕");
        String d = new String("안녕");
        String e = "안녕";
        String f = "안녕";

        System.out.println(c);
        System.out.println(c==d);
        System.out.println(e==f);
        System.out.println("hash c:"+System.identityHashCode(c));
        System.out.println("hash d:"+System.identityHashCode(d));
        System.out.println("hash e:"+System.identityHashCode(e));
        System.out.println("hash f:"+System.identityHashCode(f));
    }
}
