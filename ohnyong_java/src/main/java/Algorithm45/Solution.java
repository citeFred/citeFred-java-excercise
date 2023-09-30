package Algorithm45;

import java.util.ArrayList;
import java.util.Arrays;

/*카드 뭉치
문제 설명
코니는 영어 단어가 적힌 카드 뭉치 두 개를 선물로 받았습니다.
 코니는 다음과 같은 규칙으로 카드에 적힌 단어들을 사용해
  원하는 순서의 단어 배열을 만들 수 있는지 알고 싶습니다.

원하는 카드 뭉치에서 카드를 순서대로 한 장씩 사용합니다.
한 번 사용한 카드는 다시 사용할 수 없습니다.
카드를 사용하지 않고 다음 카드로 넘어갈 수 없습니다.
기존에 주어진 카드 뭉치의 단어 순서는 바꿀 수 없습니다.

예를 들어

첫 번째 카드 뭉치에 순서대로
["i", "drink", "water"],

두 번째 카드 뭉치에 순서대로
["want", "to"]가 적혀있을 때

["i", "want", "to", "drink", "water"] 순서의
단어 배열을 만들려고 한다면

첫 번째 카드 뭉치에서 "i"를 사용한 후
두 번째 카드 뭉치에서 "want"와 "to"를 사용하고
첫 번째 카드뭉치에 "drink"와 "water"를 차례대로 사용하면
원하는 순서의 단어 배열을 만들 수 있습니다.

문자열로 이루어진 배열 cards1, cards2와 원하는 단어 배열 goal이 매개변수로 주어질 때, cards1과 cards2에 적힌 단어들로 goal를 만들 있다면 "Yes"를, 만들 수 없다면 "No"를 return하는 solution 함수를 완성해주세요.

제한사항
1 ≤ cards1의 길이, cards2의 길이 ≤ 10
1 ≤ cards1[i]의 길이, cards2[i]의 길이 ≤ 10
cards1과 cards2에는 서로 다른 단어만 존재합니다.
2 ≤ goal의 길이 ≤ cards1의 길이 + cards2의 길이
1 ≤ goal[i]의 길이 ≤ 10
goal의 원소는 cards1과 cards2의 원소들로만 이루어져 있습니다.
cards1, cards2, goal의 문자열들은 모두 알파벳 소문자로만 이루어져 있습니다.

입출력 예
cards1	                cards2	            goal	                            result
["i", "drink", "water"]	["want", "to"]	["i", "want", "to", "drink", "water"]	"Yes"
["i", "water", "drink"]	["want", "to"]	["i", "want", "to", "drink", "water"]	"No"
입출력 예 설명

입출력 예 #1
본문과 같습니다.

입출력 예 #2
cards1에서 "i"를 사용하고
cards2에서 "want"와 "to"를 사용하여
 "i want to"까지는 만들 수 있지만 "water"가 "drink"보다
  먼저 사용되어야 하기 때문에 해당 문장을 완성시킬 수 없습니다.
  따라서 "No"를 반환합니다.


  뭔가 1 에선 1 -> 2의 1,2 -> 다음 1의 2,3 처럼 이어 달리기같이 움직인다. XXXX
  아니다 검색을 통해서 하나씩 사용해야하는 방식이다. i값을 건너 뛸 수 없다.
  */
public class Solution {
    public String Solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes"; // 답은 Yes를 초기화해두고, 아래 내용에 걸리면 No로 할당 될 수도 있다.

        //card1과 2를 모두 ArrayList로 바꿔서 동적으로 배열크기를 잡아주자.
        ArrayList cards1List = new ArrayList(Arrays.asList(cards1));
        ArrayList cards2List = new ArrayList(Arrays.asList(cards2));
        //리스트를 통해 remove를 활용해서 하나씩 매칭되면 지워나가기
        //둘다 지워지지않는다면? No반환하기

        //goal 배열을 순회하면서,(현재는 2개단어)
        for(int i=0; i < goal.length; i++) {
            if( cards1List.size() > 0 && goal[i].equals(cards1List.get(0))){
                cards1List.remove(0); //카드1이 내용이 남았으면서, goal의 단어와 리스트1의 첫번째 내용과 값이 같으면(동일한 단어가있으면 제거)
            } else if (cards2List.size() > 0 && goal[i].equals(cards2List.get(0))){ //카드2도 마찬가지로 제거
                cards2List.remove(0);
            } else { //혹시나 위 카드1,2 둘다 없으면 바로 answer에 No반환
                answer = "No";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        //두개의 카드(String) 뭉치(배열)2개와 goal이 넘어간다.
        String[] cards1 = {"i","drink","water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i","want", "to","drink","water"};

        Solution sol = new Solution();
        System.out.println(sol.Solution(cards1,cards2,goal));

    }


}
