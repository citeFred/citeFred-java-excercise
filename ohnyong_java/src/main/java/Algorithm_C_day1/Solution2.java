package Algorithm_C_day1;

import java.util.HashMap;

public class Solution2 {
    public boolean solution(String[] phone_book) {
        // 각 전화번호를 해시맵에 저장하고,
        // 해당 전화번호의 접두어가 해시맵에 이미 존재하는지 여부를 확인하는 방식
        // 해시맵 객체 생성
        HashMap<String, Integer> map = new HashMap<>();

        // 해시맵에 전화번호들을 해시맵은 put으로 저장
        //해시맵은 key:value 형태로 저장되야 해서 뒤에 1은 더미값으로 여기선 의미없는값.
        //해시맵은 순서를 보장하지않는다. = 순서가없다. 그냥 key:value로 저장되어있다.
        for (String phoneNum : phone_book) {
            map.put(phoneNum, 1);
        }

        // 각 전화번호에 대해 접두어인 경우가 있는지 확인
        //배열에서 각 전화번호를 가져와서 phoneNum으로 지정
        //현재 전화번호의 모든 접두어를 검사하기 위한 루프를 시작
        //검사 자체는 맵에서 진행하기 위해서 "단순 복제" 된 케이스이다.
        //불필요한 추가 코드, 복제로 보여질수도있지만
        //성능적 측면을 고려해서 사용되어야 할것같다.
        //각 전화번호에 대해 모든 접두어를 해시맵에 저장하므로 O(N * M)의 시간 복잡도
        for (String phoneNum : phone_book) {
            for (int i = 1; i < phoneNum.length(); i++) {
                String prefix = phoneNum.substring(0, i);
                if (map.containsKey(prefix)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String a = "44";
        String b = "123";
        String c = "1235";
        String[] phone_book = {a, b, c};
        System.out.println(sol.solution(phone_book));
    }
}

/*
기본 for loop를 사용한 배열 검사:
시간 복잡도: O(N^2)
각 전화번호에 대해 모든 접두어를 검사하므로, 중첩된 루프 때문에 O(N^2)의 시간 복잡도를 갖습니다.

Arrays.sort를 사용한 정렬된 배열 검사:
시간 복잡도: O(N log N)
먼저 전화번호 배열을 정렬하므로 O(N log N)의 시간이 듭니다.
이후에는 정렬된 배열에서 이진 탐색을 사용하여 중복된 접두어를 검사하므로 O(N log N)의 시간이 걸립니다.

해시맵을 사용한 방법:
시간 복잡도: O(N * M)
각 전화번호에 대해 모든 접두어를 해시맵에 저장하므로 O(N * M)의 시간 복잡도를 갖습니다.
여기서 M은 전화번호의 평균 길이입니다.


종합적으로, 각 방법의 성능은 입력 데이터의 크기와 특성에 따라 다르며
일반적으로는 Arrays.sort를 사용한 정렬된 배열 검사가 가장 효율적일 수 있습니다.
*/