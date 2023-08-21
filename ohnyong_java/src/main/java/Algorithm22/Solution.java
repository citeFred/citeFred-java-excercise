package Algorithm22;
/*
* 약수의 개수와 덧셈
문제 설명
두 정수 left와 right가 매개변수로 주어집니다.
* left부터 right까지의 모든 수들 중에서,
* 약수의 개수가 짝수인 수는 더하고,
*  약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.
* 입출력 예
left	right	result
13	    17  	43
24	    27  	52
* */

public class Solution {
    public int Solution(int left, int right){
        ////left~right 까지의 모든 수면 3 9이면 3,4,5,6,7,8,9라는 것이다. 배열이 필요하다.
        ////그럼 배열의 길이부터 초기화에 필요하다 두 값의 차는 배열의 크기로 정해질 수 있다.
        //int length = right - left;
        //
        ////배열이 필요하다 length로 길이를 초기화하자.
        //int[] arr = new int[length];
        ////이제 배열그릇은 준비되었다. 값들을 넣어야 하는데, 최소, 최대값은 있지만 중간 값들이 없다.
        ////중간 값들은 없어도 시작과 끝을 알기 때문에 어떤 수의 시작을 최소로, 끝을 최대로하고
        ////중간 값들은 시작부터 ++로 증가하면 된다. 멈추는 기준은 최대값을 기록한 이후다.
        //
        ////규격이 초기화된 배열을 순회한다.
        ////뭔가 첫 값을 넣어두어야 멈추는 지점만 설정 할 수 있을 것 같다.
        //
        ////다시한번 규칙을 보자
        ////idx 0 -> 3 => left
        ////idx 1 -> 4 => left+1 or arr[0]+1
        ////idx 2 -> 5 => left+2 or arr[1]+1
        //// ...
        ////idx 7 -> 9 => right
        ////이를 통해 반복진행중인 i값에서 배열에 할당 될 값은
        //// arr[i-1]+1이라는 규칙을 찾아냈다.
        ////
        //    arr[0] = left;
        //for(int i=1;i<arr.length;i++){//첫 idx를 채웠기 때문에 i는 1부터 시작한다.
        //    arr[i] = arr[i-1]+1;
        //}
        //// 그럼 새로운 배열에 딱 원하는 숫자들만 쌓여있다. 누적해서 더하자.
        //// 위와 같이 하고 싶지만 배열의 시작이 다르기 때문에 이 부분을 합칠 수 없는 구조다.
        //
        ////약수라 홀수있것만 음수로 바꾸기 위해서 이곳에서 다시 작성한다. 실수가 표현되어야 정확히 약수인지 확인 할 수 있다.
        ////double 배열로 하나를 복사하자.
        //double[] arrDouble = new double[arr.length];
        //for(int i=0;i<arrDouble.length;i++) {
        //    arrDouble[i] = arr[i];
        //}
        ////나눌 값을 준비해야 한다. 1부터 최대값까지 준비 {1,2,3,4,5,...,39} 처럼
        //int max = (int)arrDouble[arrDouble.length];
        //double[] divNum = new double[max];
        //for(int i=0;i<divNum.length;i++){
        //    divNum[i] = i;
        //    }
        //for(int i=0;i<arrDouble.length;i++) {
        //    if(arrDouble[i]%divNum[i] == )
        //}
        //for(int i=0; i<arr.length; i++) {
        //
        //    if(arr[i]%)
        //}
        //int answer = 0;
        //for(int i=0; i<arr.length; i++){
        //    //이제 약수에 따라서 더할지 뺄지를 결정해야 한다.
        //    //약수가 뭐였는지 기억이 안난다. 수학이 부족하다.
        //    // 10은 1, 5, 10으로 3개다. => 홀수기 때문에 뺀다.
        //    // 7은 1, 7로만 나누어진다 => 짝수기때문에 더한다.
        //        //그럼 약수를 어떻게 구할 것인가.
        //        // 10이라 치면 결국 1~10까지 나눠서 정수인 것만 == 나머지가 없는 것만 숫자를 세야한다.
        //        // 그런데 각 index마다 위 작업을 해야 한다.
        //            // 그럼 빼야하는 것만 -> 홀수만 부호를 음수로 만들 수 있지 않을까?
        //            // 음수는 어떻게 만들까? 10은 -10이 되야 한다. 3도 -3이 되야 한다 두개의 차이는 -j*2이다.
        //    //for(int j=0;j<arr.length; j++){
        //    //    if(arr[j]%)
        //    //여기까지 작성하다가 이것은 외부에서 해야될 것 같은 느낌이 들었다.
        //    }
        //
        //    answer += arr[i];
        //}

        //뭔가 접근이 많이 잘못되었다.
        //
        int answer = 0;

        for (int i = left; i <= right; i++) { //최소값부터 최대값까지 반복문을 돌린다.13부터,  이제14다  이제 15다
            int divisors = 0; // 약수의 개수를 저장할 변수를 초기화

            // 1부터 i까지 모든 숫자로 나눠보며 약수를 찾음 // 우선 최소값일 때, 13일때, 14일때, 15일때
            for (int j = 1; j <= i; j++) { //j는 1부터 시작해서 최소값까지 13까지 돈다. 맞다. 14까지돈다. 15까지 돈다.
                if (i % j == 0) { // 13%1이 0인가? 맞다 div = 1. ~~~ 가다가 13%13은 1이다. div =2 14%1=0이고, 14%2=0, 14%7=0, 14%14=0, 15%1=0, 15%5=0, 15%15 = 0
                    divisors++; //13일때 div는 2다, 14일때 div은 4,  15일땐 3이다.
                }
            }

            // 약수의 개수에 따라 더하거나 빼기
            if (divisors % 2 == 0) { // 짝수인 경우 div%2는 2%2라 0이다 그럼 answer에 아직 i인 13이 더해진다. 14도 4개로 더해진다. 15는 3개라 통과
                answer += i;
            } else { // 홀수인 경우 15는 여기서 들어온다. 15가 뺴진다.
                answer -= i;
            }
        }

        return answer;
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        int left = 13;
        int right = 17;
        System.out.println(solution.Solution(left, right));
    }
}
