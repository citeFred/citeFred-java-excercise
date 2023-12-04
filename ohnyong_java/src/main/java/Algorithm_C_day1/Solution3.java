package Algorithm_C_day1;

import java.util.HashMap;

/*
완주하지 못한 선수

문제 설명
수많은 마라톤 선수들이 마라톤에 참여하였습니다.
단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와
완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
!!완주하지 못한 선수의 이름을 return !!하도록 solution 함수를 작성해주세요.

제한사항
마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
completion의 길이는 participant의 길이보다 1 작습니다.
참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
참가자 중에는 동명이인이 있을 수 있습니다.

입출력 예
participant	completion	return
["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"
입출력 예 설명
예제 #1
"leo"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #2
"vinko"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #3
"mislav"는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.

*/


// 생각 :  각각 맵에 넣고 비교해서 있으면 빼자? 무조건 -1이라고하니까
// 참가자는 항상 1개 요소가 더있을 것이고 빼다보면 1개남지않을까? 그걸 String으로 출력하면 되지않을까?
public class Solution3 {
    public String solution(String[] completion, String[] participant){
        HashMap<String, Integer> comMap = new HashMap<>();
        HashMap<String, Integer> parMap = new HashMap<>();

        // completion 배열의 이름을 completionMap에 추가
        for (String name : completion) {
            //comMap.put(name, 1); // 동명이인에 대한 처리가 안된다..
            // 동명이인에 대한 처리는 다른 자료 참고
            comMap.put(name, comMap.getOrDefault(name, 0) + 1);
        }
        // participant 배열의 이름을 participantMap에 추가
        for (String name : participant) {
            //parMap.put(name, 1);
            parMap.put(name, parMap.getOrDefault(name, 0) + 1);
        }
        // 두 맵을 비교하고 빼기
        for (String name : comMap.keySet()) {
            if (!parMap.containsKey(name) || comMap.get(name) > parMap.get(name)) {
                return name;
            }
        }
        return "Nobody's left";
    }

    public static void main(String[] args){
        Solution3 sol = new Solution3();
        String[] completion = {"leo", "kiki", "eden"};
        String[] participant = {"eden", "kiki"};
        System.out.println(sol.solution(completion, participant));
    }
}
