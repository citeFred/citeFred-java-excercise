package Algorithm41;
/*푸드 파이트 대회
문제 설명
수웅이는 매달 주어진 음식을 빨리 먹는 푸드 파이트 대회를 개최합니다.
이 대회에서 선수들은 1대 1로 대결하며, 매 대결마다 음식의 종류와 양이 바뀝니다.

대결은 준비된 음식들을 일렬로 배치한 뒤,
한 선수는 제일 왼쪽에 있는 음식부터 오른쪽으로,
다른 선수는 제일 오른쪽에 있는 음식부터 왼쪽으로 순서대로 먹는 방식으로 진행됩니다.
중앙에는 물을 배치하고, 물을 먼저 먹는 선수가 승리하게 됩니다.

이때, 대회의 공정성을 위해 두 선수가 먹는 음식의 종류와 양이 같아야 하며, 음식을 먹는 순서도 같아야 합니다.
또한, 이번 대회부터는 칼로리가 낮은 음식을 먼저 먹을 수 있게 배치하여 선수들이 음식을 더 잘 먹을 수 있게 하려고 합니다.
이번 대회를 위해 수웅이는 음식을 주문했는데, 대회의 조건을 고려하지 않고 음식을 주문하여 몇 개의 음식은 대회에 사용하지 못하게 되었습니다.

예를 들어, 3가지의 음식이 준비되어 있으며,
칼로리가 적은 순서대로 1번 음식을 3개,
2번 음식을 4개,
3번 음식을 6개 준비했으며,
물을 편의상 0번 음식이라고 칭한다면,
두 선수는 1번 음식 1개, 2번 음식 2개, 3번 음식 3개씩을 먹게 되므로 음식의 배치는 "1223330333221"이 됩니다.
따라서 1번 음식 1개는 대회에 사용하지 못합니다.

수웅이가 준비한 음식의 양을 칼로리가 적은 순서대로 나타내는 정수 배열 food가 주어졌을 때, 대회를 위한 음식의 배치를 나타내는 문자열을 return 하는 solution 함수를 완성해주세요.

제한사항
2 ≤ food의 길이 ≤ 9
1 ≤ food의 각 원소 ≤ 1,000
food에는 칼로리가 적은 순서대로 음식의 양이 담겨 있습니다.
food[i]는 i번 음식의 수입니다.
food[0]은 수웅이가 준비한 물의 양이며, 항상 1입니다.
정답의 길이가 3 이상인 경우만 입력으로 주어집니다.
입출력 예
food	result
[1, 3, 4, 6]	"1223330333221"
[1, 7, 1, 2]	"111303111"*/


class Solution {
    /*시도했는데 풀어내지못해서 질답게시판 다른 개발자의 코드를 참고하고
     해당 코드를 리뷰형식으로 진행
    * 문제가 길어서 핵심을 찾아내는 연습이 더 필요한듯*/
    public String solution(int[] food) {
        String answer = ""; // 답변 반환변수 초기화
        StringBuffer left = new StringBuffer(); // 왼쪽부터가는 1번선수 변수 StringBuffer() 초기화
        StringBuffer right = new StringBuffer(); // 오른쪽부터가는 2번선수 변수 StringBuffer() 초기화
        // 여기서 StringBuffer쓰는 이유?
        //StringBuffer는 가변(mutable) 문자열을 다루기 위한 클래스로, 문자열을 효율적으로 연결하고 수정할 수 있게 해줍니다.
        //이 클래스를 사용하면 문자열 연결 작업이 문자열 복사 없이 직접 데이터를 수정하므로 성능이 향상됩니다.

        // 전체적으로 리뷰한 결과 스트링버퍼를 궂이 사용 안해도 다른 컬렉션을 사용해도 될것같았다.
        // ChatGPT와의 2차리뷰 답변
        // Q. 음 로직상 StringBuffer가 필수적인건 아닌것 같은데? 그냥 컬렉션중에 하나를 사용해도 되지않을까
        // A. ChatGPT : 네, 로직상으로는 StringBuffer를 사용하지 않고 다른 방법으로도 해결할 수 있습니다. StringBuffer 대신에 다른 자료 구조를 사용할 수 있습니다.
        // 예를 들어, ArrayList를 사용하여 왼쪽과 오른쪽의 음식을 각각 저장하고 마지막에 문자열로 변환할 수 있습니다.


        // 문제에서는 음식을 먹을 때 칼로리가 적은 순서대로 먹어야 하기 때문에,
        // 모든 음식의 수를 짝수로 만들어야 한다.
        // 이를 위해 홀수인 음식의 수를 하나 줄이는 것이 코드에서 수행
        for(int i = 1 ; i < food.length; i++){
            if(food[i] % 2 !=0){
                food[i] -= 1;
            }
        }

        // 음식 배열 food에서 위 짝수로 갯수를 맞춘 각 음식의 수를 이용하여 물과 음식을 번갈아가면서 나열하는 작업을 수행하는 반복문
        // 반복문을 통해 음식의 수를 절반으로 나눈 number 변수를 계산하고,
        // 이 값을 이용하여 왼쪽 선수가 먹을 음식을 left 문자열에 추가
        // number가 0이 될 때까지 해당 음식을 추가하며, 이 작업을 모든 음식에 대해 수행
        for(int i = 1; i < food.length; i++){
            int number = food[i] / 2;
            while(number != 0){
                left.append(i);
                number--;
            }
        }

        // String value = left.toString();는 left라는 StringBuffer 객체를 String으로 변환하여 새로운 문자열 value에 저장
        // 이것을 이용하여 right를 작업하기 위한것임 아래 반복문으로 연결
        String value = left.toString();
        // 아래 반복문은 앞서 생성한 value 문자열을 거꾸로 순회
        // 각 문자를 right 문자열에 추가하는 역순 추가 작업을 수행하는 부분
        for(int i = value.length() -1; i >= 0; i--){
            right.append(value.charAt(i));
        }

        // 이제 순서대로 left에 쌓인 문자열 + "0" + right에 쌓인 문자열 로 answer를 채움
        answer += left;
        answer += "0";
        answer += right;
        return answer;
    }


    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};
        Solution sol = new Solution();

        String answer = sol.solution(food);
        System.out.println(answer);
    }
}
