package Algorithm20;

import java.util.Arrays;

/*수박수박수박수박수박수?
문제 설명
길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요.
 예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.


제한 조건
n은 길이 10,000이하인 자연수입니다.
입출력 예
n	return
3	"수박수"
4	"수박수박"
 */
public class Solution {
    public String Solution(int n){
        //5가 들어오면, "수박수박수"라는 문자열을 가지게 된다.
        //String에 뭔가 추가하는 기능이 있을것 같지만 기억이 안난다.
        //객체니까 add같은게 있지 않을까? 불확실하다.

        //단순히 당장 생각나는 것은
        //char[] 배열을 만들고, 0,2,4,6 처럼 짝수 index에는 수를 넣고
        // 1,3,5,7 같은 홀수 index에는 박을 넣으면 되지 않을까?
        //출력은 String으로 나가야 하니까 변환해야된다. valueOf(arr[짝])+valueOf(arr[홀])

        //우선 n개의 캐릭터 배열을 만들자. 지금 샘플은 5니까 5개 공간으로 초기화될 것이다.
        //char[] arr = new char[n]; //char배열 선택은 잘못된 선택이었다.
        String[] arr = new String[n];


        //홀수와 짝수를 구분해야 한다.
        //홀수 index에는 hol이라는 charactor 요소를 넣어주고 짝에는 jjak을 넣어줄 것이다.
        String hol = "박";
        String jjak = "수";
        //반복문을 통해 arr을 순회한다. 하면서 if 홀이면 홀을 넣어준다 반대는 반대다.
        //우선 홀수를 구하는 방법은 %연산에서 나머지가 1인 경우다.
        //그런데 0인경우를 생각하자 index는 0부터 시작한다. 함께가야 한다.

        //for(int i=0;i<arr.length;i++){
        //    if(i%2 == 1){
        //        arr[i] = "홀";
        //        arr[i] = "ㄱ";
                //지금보니 한글의 조합 자체는 문자열이다. 한글자라고 char가 아니었던 것이다.
                //그럼 어떻게 넣어야 하는가? char[]조차 쓸모가 없어지려고 한다.
                //String 배열로 다시 변경하자.
        //    }
        //}
        for(int i=0; i<arr.length; i++){
            if(i%2 ==1){
                arr[i] = hol; //위 char선택은 생각이 짧았다.
                // 영어의 A한글자는 char지만 한글의 가 는 String이다 오히려 ㄱ은 가능하지 않을까?
                // 테스트해봤지만 불가능하다. 애초에 한글 자체가 String이다.
            }else if(i%2 == 0){
                arr[i] = jjak;
            }
        }
        //for(re : arr){ //짝을 향상 for문을 쓰려 했는데 index가 될 i를 어떻게 뽑아 쓰는지 모르겠다.
        //    int i=0; //이렇게 별도로 뽑아야 하는가? 그럼 이 케이스에서는 향상for문이 큰 의미가 없어보인다.
        //    if(i%2 == 0){
        //        arr[i] = jjak;
        //    }
        //    i++; //이것까지 써주면 사실 향상for문의 의미가 없다. 오히려 가시성이 떨어지는것 같다.
        //}
        //String answer = String.valueOf(arr); // 앗 String 배열은 참조값이 출력된다. 나는 실제 문자열이 필요한데.
        //이것을 값을 뽑아서 String 타입의 데이터로 만들어야 한다.
        //말그대로 배열 Arrays를 String으로 toString으로 기억하자.
        // 어떤 배열을 - to 무엇으로.
        //String answer = Arrays.toString(arr); //배열형식으로 출력되고있다. 문제의 출력 조건과 다르다.


    //    > Task :Solution.main()
        //[수, 수, 박, 수, 박]
        //출력하고 나니 조건을 잘못 생각했다. 0,1,2,3,4 중에 0, 2, 4에 수가들어가야하고, 1,3,... 에 박이들어가야 한다.
        //조건식을 변경하자. 이런 실수는 줄여야 한다.

    //    > Task :Solution.main()
        //[수, 박, 수, 박, 수]
        //아직도 문제가 있다. 문제에서는 "수박수박수" 처럼 출력되어야 한다.
        //방법은 for문으로 또 arr을 돌리면서 answer에 +=누적시키는 방법도 있었다. 알면서 응용을 못했다.
        //하지만 또 다른 방법을 GPT가 추천해줬다.
        //String.join(arr); Join 메소드이다. 문자열 배열의 값들만 합쳐서 하나의 문자열로 만들어 주는것 같다. 유용하다.
        String answer = String.join("",arr); //하지만 인자로 String[] 이 못들어간다. char[]는 들어가는것 같다. //아니다 앞에 delimiter라는 것에 빈""를 넣고, 문자열을 넣으니까 들어가진다. delimiter는 뭐지?
        //delimiter는 문자열 배열을 합칠 때 각 요소 사이에 넣을 것을 말한다.
        //예로 내가 원하는 문자열이 "수-박-수-박-수"일 경우 String answer = String.join("-",arr); 처럼 표현하면 문자열 배열 요소가 합쳐질때마다 "-"가 붙게 된다.
        return answer;

    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int n = 5; //sample
        System.out.print(solution.Solution(n)); //테스트용
    }
}
