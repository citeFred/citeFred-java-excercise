package Algorithm15;

public class Solution {
    int result;
    String transStr; // int n 정수값을 문자열로 변환-숫자를 자리마다 분리하고싶어서.
    /*
    자릿수 더하기
input
자연수 N이 주어지면,


N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
예를들어 N = "123" 이면 1 + 2 + 3 = 6을
{char} {char} {char}
  1      2      3
String transStr;

output
return 하면 됩니다.

제한사항
N의 범위 : 100,000,000 이하의 자연수
*/
    public Solution(){

    }
    public int calculate(int n){
        transStr = Integer.toString(n);
        for(int i=0;i<transStr.length();i++){
            result += Integer.parseInt(transStr.substring(i, i+1));
        }
        System.out.println(result);

        return result;
    }
}
