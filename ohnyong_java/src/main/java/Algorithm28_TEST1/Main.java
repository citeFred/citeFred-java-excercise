package Algorithm28_TEST1;
/*
*
😃 **1번 문제) 행렬 음양 더하기! (1점)**
😃 설명)행렬이 두개 있습니다.
* 두 행렬의 절댓값을 차례대로 담은 정수 배열 arr1, arr2와
* 행렬의 부호를 차례대로 담은 불리언 배열 signs가 매개변수로 주어집니다.
* 두 행렬의 부호는 같습니다.

실제 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.

### 제한 조건
- 행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않습니다.
* */
import java.util.Arrays;

public class Main {

    //[2]계산부
    public int[][] solution(int[][] arr1, int[][] arr2, boolean[][] signs) {        // 계산기는 매개변수로 3개의 값을 받아옴. ****필요한 계산은?****
        // 예로,
        // int[][] arr1 = {{5,7,1},{2,3,5}};
        //boolean[][] signs={{true,true,false},{false,true,false}};
        // int[][] arr2 = {{5,1,6},{7,5,6}};
        // 세로로 읽어보면 5 true 5 -> 5 + 5 가되어야 한다는 말,
        // 세로로 읽어보면 1 false 6 -> 1 - 6 가되어야 한다는 말,
        // arr1과 arr2를 더해야 하는데, signs에 따라서 더하는것일 수도, 빼는 것일 수도 있다. <조건문필요
        //행의 길이                                                                         // 우선 더하는 것부터 생각해보자. <2중반복문 필요
        //초기 코드
        int answerRow = arr1.length;                                                        // 두 배열의 길이가 같다 가정하면, [{ } , { }]이면 행은 2일 것이다. arrN은 몇개의 계산할 숫자들이 나열 될 지 나타난다.
                                                                                                            //int answerRow = Math.max(arr1.length, arr2.length); //자체 테스트 케이스 추가해서 길이가 다른 경우에 대한 오류가 나타났다. 그럼 둘 중 최대값으로 정답 배열은 이것을 사용해서 생성해야 한다. 그럼 빈 부분은 0이라도 들어가게 된다.
        //열의 길이
        //초기 코드
        //int answerCol = arr1[0].length;                                                     // 두 배열의 각 요소 내부 배열(2차배열)은 [{{},{},{}} , {...}] 일 것이기 때문에 3이 나올 것이다.
        int answerCol = Math.max(arr1[0].length, arr2[0].length);// 2차배열 내부의 길이도 마찬가지다. 둘 중 최대값으로 정답 배열은 이것을 사용해서 생성해야 한다. 그럼 빈 부분은 0이라도 들어가게 된다.
        //답을 담을 배열 초기화                                                         // 따라서 arr[0]의 길이를 재는 것은 [ { {}, {}, {} } , { ... } ] 이런식으로 arr[n]에 몇개의 숫자가 있는지를 판단 할 수 있다.
        int[][] answer = new int[answerRow][answerCol];                                 //answer는 선언 할 때 초기화(길이를 지정) 해야 한다. -> 그럼 전체 배열의 크기를 우선 알아야 한다. 위로

        for(int i=0;i<answerRow;i++){                                               //arr1을 반복하면서XX --> arr1의 길이로 돌도록 했었는데, 테스트에서 false에 대한 빼기 수행에 문제가 있었다.
            for(int j=0;j<answerCol;j++){                                           //arr2를 모두 탐색하는데XX, --> 이부분도 arr2를 탐색이 아니라, 새로운 배열 answer[][]의 길이만큼 돌아야 한다.
                //계산 전에, 길이가 다른( 마치 3 + x = ) 과 같은 상황에 3 + 0이라도 되도록 해야 한다.
                //int num1 = 0; //이제 아래에서 있으면 그값을 num1에 넣고,
                //int num2 = 0; //있으면 num2에 넣고, 둘 중 없으면(배열의 길이가 다른 경우) 0이라도 넣어서 연산 하도록 초기값을 0으로 설정했다.
                //boolean flag = true; //마찬가지로, 입력자가 실수로 계산 부호를 까먹은 경우 true라도 넣어서 더하기를 강제시키자.
                //초기 코드                                                                        //더한 값을 바로 answer에 담으면 된다. 위에서 answer를 생성해두자. 위로,
                if(signs[i][j] == true) {                                           //조건문으로 sign이 true이면 더하자. 빼는것은 그 외로 하자.
                    answer[i][j] = arr1[i][j] + arr2[i][j];                         //작동
                }else{ //(signs[i][j] ==false)
                    answer[i][j] = arr1[-i][-j] + arr2[-i][-j];
                }
                //if (i<arr1.length&&j<arr1[0].length){
                //    num1 = arr1[i][j]; // ex)0, 0순환 때 arr1행과 arr1열의 길이가 같으면, num1에 그대로 넣기
                //}
                //if (i<arr2.length&&j<arr2[0].length){
                //    num2 = arr2[i][j]; // ex)0, 0순환 때 num2도 그대로 넣기
                //}
                //if (i<signs.length&&j<signs[0].length){
                //    flag = signs[i][j]; // ex) 순환 때 길이가 같은 순환을 할 때 연산도 그대로 들어감
                //}
                ////아닌 경우는 위에서 초기화 시킨 값이 그대로 들어갈것임. 0이나 true로 강제 입력될 것임.
                //if(flag){ // 연산이 true(위 조건에 따라 인풋 조건의 배열내 값이 true나 false인 것으로 할당된 것에 따라 true인 경우엔 더하기를
                //    answer[i][j] = num1+ num2;
                //}else{ //연산이 false인 경우 빼기를 진행
                //    answer[i][j] = num1 - num2;
                //}
            }
        }

        return answer;                                                              //[3] 출력부 시작
    }


    public static void main(String[] args) {
        //[1] 계산기 생성으로부터 입력부 시작
        Main method = new Main();                                                       //계산기 생성
        int[][] arr1 = {{5,7,1},{2,3,5},{2,3}};                                                   //입력값 1
        int[][] arr2 = {{5,1,6},{7,5,6},{3,2}};                                                   //입력값 2
        boolean[][] signs={{true,true,false},{false,true,false}};                           //입력값 3
        System.out.println(Arrays.deepToString(method.solution(arr1, arr2, signs))); //[3] print -> 출력부끝 / (method.solution(인자1,인자2,인자3)) -> [2] 계산부 요청
        //결과를 체크, 5 + 5 = 10 (O)
        //결과를 체크, 1 - 6 = 0 (X) --> 잘못생각했던 부분을 찾아냄(반복문은 답을 담기위해 생성한 배열의 길이만큼 돌아야 한다.)
        //결과를 체크, 1 - 6 = -5 (O) --> 잘못생각했던 부분을 수정
        //결과를 체크, 3 + 5 = 8 (O)
        //결과를 체크, 5 - 6 = -1 (O)
            //아래 배열의 길이가 같지 않다라는 조건은 매니저님 확인을 통해 구현을 멈춘 상태, 하지만 구현에 어려움이 있었기 때문에 기술매니저님에게 물어봐야 한다.
            //결과를 체크, 입력값에 각각 {2,3}과 {true,false}를 추가했는데 안되는 경우가 발생한다. 이것에 대한 처리가 필요하다.
            //결과를 체크, 반대로, signs가 {true,false,true}처럼 3개지만 입력값이 2개뿐인 경우 마지막 true의 연산에 대한 부분도 0+0이라도 수행하도록 처리해야 한다.

    }
}
