package Algorithm35;
/*숫자 문자열과 영단어
 네오와 프로도가 숫자놀이를 하고 있습니다.
 네오가 프로도에게 숫자를 건넬 때 일부 자릿수를
 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.

다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.

1478 → "one4seveneight"
234567 → "23four5six7"
10203 → "1zerotwozero3"
이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나,
 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다.
 s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.

참고로 각 숫자에 대응되는 영단어는 다음 표와 같습니다.

숫자	영단어
0	zero
1	one
2	two
3	three
4	four
5	five
6	six
7	seven
8	eight
9	nine

예시)
s	                result
"one4seveneight"    1478
"23four5six7"   	234567
"2three45sixseven"	234567
"123"	            123
 * */
public class Solution {
    String[][] numStrArr = {
            {"0", "zero"},
            {"1", "one"},
            {"2", "two"},
            {"3", "three"},
            {"4", "four"},
            {"5", "five"},
            {"6", "six"},
            {"7", "seven"},
            {"8", "eight"},
            {"9", "nine"}
    };
    public Solution(){

    }
    String Solution(String s){
        String answer = "";

        for(int i=0; i<s.length();){ //1) s문자를 하나씩 순회 할 때, numString의 길이만큼 i가 초기화 되도록(시작점이 문자의 맨뒤로 이동하면서 다시 숫자를 만나게함)
            boolean flag = false;
            for(int j=0; j< numStrArr.length;j++){ //2)위 배열도 하나씩 순회한다. -> 비교를 위해서.
                String numNumeric= numStrArr[j][0]; //숫자로나타난 문자는 [0][0] 0 , [1][0] 1, ...
                String numString= numStrArr[j][1];//문자로나타난 숫자는 [0][1]일때 zero, [1][1] one, ...
                if(s.startsWith(numString, i)){
                    answer += numNumeric; //반환값에 숫자를 누적함,
                    i += numString.length(); //**** 이부분이 s로입력된 문자를 쭉 지나가는데 다음 문자로 커서를 이동시키기위해 i를 문자 길이만큼 초기화 시킴, 그럼 다시 위로 반복문 돌때 그다음문자를 찾게됨
                    flag = true;
                }
            }
            if(!flag){
                // s를 순회하는데
                answer += s.charAt(i);
                i++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "one4seveneight";
        System.out.println(sol.Solution(s));
    }
}
