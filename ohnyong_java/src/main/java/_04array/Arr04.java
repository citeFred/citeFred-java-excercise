package _04array;

import java.util.Arrays;

public class Arr04 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = Arrays.copyOf(a, a.length); // 깊은 복사(Deep Copy)
        System.out.println(b[0]);

        b[0] = 4;
        System.out.println(b[0]);
        System.out.println(a[0]);
        // Deep Copy는 a[]를 통해 새로운 배열 객체 b[]를 생성 했기 때문에
        // 각각 주소값이 각자의 값을 바라보고 있기 때문에
        // 1개만 변경하면 변경한 대상의 배열의 값만 변경된다.

    }
}
