package Algorithm40;

import java.util.Arrays;

/*가장 가까운 같은 글자
문제 설명
문자열 s가 주어졌을 때, s의 각 위치마다 자신보다 앞에 나왔으면서, 자신과 가장 가까운 곳에 있는 같은 글자가 어디 있는지 알고 싶습니다.
예를 들어, s="banana"라고 할 때,  각 글자들을 왼쪽부터 오른쪽으로 읽어 나가면서 다음과 같이 진행할 수 있습니다.

b는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
a는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
n은 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
a는 자신보다 두 칸 앞에 a가 있습니다. 이는 2로 표현합니다.
n도 자신보다 두 칸 앞에 n이 있습니다. 이는 2로 표현합니다.
a는 자신보다 두 칸, 네 칸 앞에 a가 있습니다. 이 중 가까운 것은 두 칸 앞이고, 이는 2로 표현합니다.
따라서 최종 결과물은 [-1, -1, -1, 2, 2, 2]가 됩니다.

문자열 s이 주어질 때, 위와 같이 정의된 연산을 수행하는 함수 solution을 완성해주세요.

제한사항
1 ≤ s의 길이 ≤ 10,000
s은 영어 소문자로만 이루어져 있습니다.
입출력 예
s	result
"banana"	[-1, -1, -1, 2, 2, 2]
"foobar"	[-1, -1, 1, -1, -1, -1]*/
public class Solution {
    public int[] Solution(String s){
        char[] charArray = s.toCharArray(); // charArray로 바꿔
        int[] result = new int[charArray.length]; //결과 여기다 저장해 문자갯수만큼 크기지정해
        for (int i=0;i<charArray.length;i++){ // 문자를 하나씩 순환해. b->a->n->a->n->a
            char tempChar = charArray[i]; // 선택된 문자 잠시보관하고
            int matchedPlaceNum = -1; // 만나는 위치 초기값을 -1로 설정,

            for (int j = i - 1; j >= 0; j--) {//문자를 하나씩 또 순환할꺼야 만약 b면 i=0일거고 쭉 지나가도 없어. 다시 수정, 가장 가까운것을 찾아야하기때문에,
                //가장 가까운것의 기준은 현재 선택된 문자로부터고, 선택된 문자로부터 0까지 감소하면서 갈꺼야, 처음 만나면 브레이크로 기록하고 도망가
                if(tempChar == charArray[j]){ //만약에 위 선택된문자랑, 같은것이 있으면, 바로멈춰 그 자리를 기억해
                    matchedPlaceNum = i-j; //만약 i=3(4번째)인 'a'면, j가1일때(2번째) 처음만나잖아, 3-1 = 2야.
                    break;
                }
            }
            result[i] = matchedPlaceNum;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "banana";
        Solution sol = new Solution();

        String answer = Arrays.toString(sol.Solution(s));
        System.out.println(answer);
    }
}
