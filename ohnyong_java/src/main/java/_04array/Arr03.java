package _04array;

public class Arr03 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = a; // 얕은 복사(Shallow Copy)
        System.out.println(b[0]);

        b[0] = 4;
        System.out.println(b[0]);
        System.out.println(a[0]);
        // Shallow Copy는 a[]와 b[]의 각 주소값이 같은 값을 바라보고 있기 때문에
        // 1개만 변경해도 원본도 같이 변경 된다.

    }
}
