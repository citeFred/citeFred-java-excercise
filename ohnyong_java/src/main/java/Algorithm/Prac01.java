package Algorithm;

import java.util.HashMap;
import java.util.Map;

public class Prac01 {
    public static void main(String[] args) {
        //Big O 표기법으로 보는 시간 복잡도(Time Complexity)의 종류와 예제 코드의 형태
        //알고리즘의 로직을 코드로 구현할 때, 시간 복잡도를 고려한다는 것은
        //‘입력값의 변화에 따라 연산을 실행할 때, 연산 횟수에 비해 시간이 얼마만큼 걸리는가?’라는 말이다.
        //효율적인 알고리즘을 구현한다는 것은 바꾸어 말해 입력값이 커짐에 따라 증가하는 시간의 비율을 최소화한 알고리즘을 구성했다는 이야기이다.
        //그리고 이 시간 복잡도는 주로 빅-오 표기법을 사용해 나타낸다.


        //1) O(1) : constant time 상수 시간
        //- 일정한 시간이 소요됨
        //-- 데이터(==n==input)가 늘어나더라도, 직접 idx를 지정하고 있기 때문에 해당 로직의 수행 시간은 일정하다.
        int[] constArr = {0, 10, 20, 30};
        System.out.println(constArr[0]);
        System.out.println(constArr[3]);


        //2) O(n) : linear time 선형 시간
        //- 입력 데이터 크기에 비례해서 처리 시간이 소요됨
        //-- 아래 Arr에 데이터(==n==input)가 추가 될 수록 정비례로 로직 수행 시간이 늘어 날 것이다.
        int[] linearArr = {0, 10, 20, 30};
        for (int i = 0; i < linearArr.length; i++) {
            System.out.println(linearArr[i]);
        }
        //아래와 같이 for문이 하나 더 있더라도 중첩되어 있지 않고 별개로 수행되기 때문에,
        //0(n)으로 일정하다. O(2n)이라도 상수는 뺀다 ===> 0(n)
        for (int j = 0; j < linearArr.length; j++) {
            System.out.println(linearArr[j]);
        }


        //3) O(n^2) : quadratic time 번역하면 이차 복합도, 다차 복합도라고 불린다.
        //이차라는 말에서 예상할 수 있듯이 데이터의 양이 증가함에 따라 제곱 꼴로 증가해가는 시간 복잡도이다.
        //반복문이 두번 있는 케이스
        int[][] quadArr = {
                {10, 20},
                {10, 20, 30, 40},
                {10}
        };
        // 조회해보자.
        for (int i = 0; i < quadArr.length; i++) {
            for (int j = 0; j < quadArr[i].length; j++) {
                System.out.println(quadArr[i][j]);
            }
        }

        //4) O(log n) == O(2^n) : 대표적으로 fibonacci 수열이 있다.
        //피보나치 수열은 앞의 두 숫자를 더하여 다음 숫자를 만들어내는 수열로,
        // 0과 1로 시작한다. 자바로 피보나치 수열을 구현하는 방법은 여러 가지가 있지만,
        // 가장 기본적인 방법과 메모이제이션(Memoization)을 활용한 방법

        // 1) 기본적인 재귀 방법
        //기본적인 재귀 방법은 성능이 좋지 않기 때문에, 입력값이 크면 계산이 오래 걸릴 수 있다.
        //구현 부분은 좀 더 복습 할 것.
        int n = 10; // 원하는 피보나치 수열의 인덱스 입력
        int result = fibonacci(n);
        System.out.println("인덱스 " + n + "의 피보나치 수는: " + result);

        // 2) Memoization 활용 방법
        //메모이제이션은 중복 계산을 피하기 위해
        //이전에 계산한 결과를 저장하여 재사용하는 방법으로,
        //피보나치 수열을 효율적으로 계산할 수 있다.
        //구현 부분은 좀 더 복습 할 것.

        // 2) Memoization 활용 방법
        Map<Integer, Integer> memo = new HashMap<>();
        result = fibonacciMemoization(n, memo);
        System.out.println("Memoization을 사용하여 인덱스 " + n + "의 피보나치 수는: " + result);
    }
    // 1) 기본적인 재귀 방법(함수 구현 부분)
    public static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
    // 2) Memoization 활용 방법(함수 구현 부분)
    public static int fibonacciMemoization(int n, Map<Integer, Integer> memo) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (memo.containsKey(n)) {
            return memo.get(n);
        } else {
            int result = fibonacciMemoization(n - 1, memo) + fibonacciMemoization(n - 2, memo);
            memo.put(n, result);
            return result;
        }
    }
}