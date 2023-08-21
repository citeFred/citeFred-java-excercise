package Algorithm19;
/*
* 가운데 글자 가져오기
문제 설명
단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

재한사항
s는 길이가 1 이상, 100이하인 스트링입니다.
* */
public class Solution {
    public String Solution(String s){
        //가운데 글자를 반환해야 한다

        //1. String을 char[] 로 만들자.
        //hello면 char[] = {h,e,l,l,o};가 된다.
        //2. 길이를 알 수 있다. = 문자열의 길이 최대값을 알아야 한다. strLength
        //길이가 5다.
        //3. 가운데 값을 알 수 있다.
        //가운데값은 길이/2 인데, 2가지 경우로 나눠진다.

            //방법 1)
            //가운데 값은 정수가 아니다 == double로 가야 한다.
            //5글자면 5/2는 2.5이다. 내림처리를 하면, 3으로 index = 2와 같다.
            //6글자면 6/2는 3이다. 내림처리해도 3이게 되는데, 정수라면 3과 3-1을 뽑아야 한다.

            //방법 2)
            //또는 이미 5, 6처럼 길이로부터 정할 수 있다.
            //5는 홀수이다. 5%2 로 나머지가 1인 경우,
            //idx가 5/2인 것을 추출하면 int로 나누기 때문에 자동적으로 index 2를 선택 할 수 있다.
            //6은 짝수이다. 6%2 로 나머지가 0인 경우,
            //idx가 6/2인 것을 추출하면 실수가 아니기 때문에 일단 index 3을 선택 할 수 있고 그 옆 글자인 index 3 -1을 추가로 선택하면 된다.

        //나는 선택해야 된다 어떤것이 편할까.
        //첫번째 방법은 실수와 정수를 왔다갔다한다. 비효율적이다.
        //두번째 방법은 길이로부터 홀수 짝수를 단순 나머지 연산자%를 통해서 구할 수 있다. 직관적이다. <<<선택

        //--------------------------------
        //방법 2) 를 선택했다. 코드로 옮겨보자.

        //1. String을 char[] 로 만들자.
        char[] arr = s.toCharArray();

        //방법 2)
        //또는 이미 5, 6처럼 길이로부터 정할 수 있다.
        //System.out.println(arr.length);
        //문자 배열로 변환한 arr에 향상된 for문을 써보자.
        int strLength = 0;
        for(int a : arr){
            strLength++;
        }

        int centerIdx = strLength / 2;
        int centerIdxLeft = centerIdx - 1;
        String answer = "";

        //5는 홀수이다. 5%2 로 나머지가 1인 경우,
        if(strLength%2 == 1){
            //idx가 5/2인 것을 추출하면 int로 나누기 때문에 자동적으로 index 2를 선택 할 수 있다.
            answer = String.valueOf(arr[centerIdx]);
        }
        //6은 짝수이다. 6%2 로 나머지가 0인 경우,
        else if(arr.length%2 == 0){
             //idx가 6/2인 것을 추출하면 실수가 아니기 때문에 일단 index 3을 선택 할 수 있고 그 옆 글자인 index 3 -1을 추가로 선택하면 된다.
            answer = String.valueOf(arr[centerIdxLeft])+String.valueOf(arr[centerIdx]);
        }

        return answer;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "Helalo";
        System.out.println(solution.Solution(s));
    }
}
