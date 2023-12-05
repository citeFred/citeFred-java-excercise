package Algorithm_C_day2;

import java.util.LinkedList;
import java.util.Queue;

/*
* 다리를 지나는 트럭
문제 설명
트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다.
*모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
*
*  다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며,
* 다리는 weight 이하까지의 무게를 견딜 수 있습니다.
* 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.

예를 들어, 트럭 2대가 올라갈 수 있고 무게를 10kg까지 견디는 다리가 있습니다.
*  무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.

경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
0	[]	[]	[7,4,5,6]
1~2	[]	[7]	[4,5,6]
3	[7]	[4]	[5,6]
4	[7]	[4,5]	[6]
5	[7,4]	[5]	[6]
6~7	[7,4,5]	[6]	[]
8	[7,4,5,6]	[]	[]
따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.

solution 함수의 매개변수로 다리에 올라갈 수 있는 트럭 수 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭 별 무게 truck_weights가 주어집니다. 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.

제한 조건
bridge_length는 1 이상 10,000 이하입니다.
weight는 1 이상 10,000 이하입니다.
truck_weights의 길이는 1 이상 10,000 이하입니다.
모든 트럭의 무게는 1 이상 weight 이하입니다.
입출력 예
bridge_length	weight	truck_weights	return
2	10	[7,4,5,6]	8
100	100	[10]	101
100	100	[10,10,10,10,10,10,10,10,10,10]	110
출처

※ 공지 - 2020년 4월 06일 테스트케이스가 추가되었습니다.
* */
public class Solution2 {
    // 규칙 찾아내기
    // 우선 FIFO가 필요하다 먼저들어가서 먼저 나간다. -> Queue 자료구조를 사용해야한다.
    // 최대 2대가 들어갈수있는데 truck_weights 2개가 max_weight보다 초과하면 진입안되기때문에 1개만 가야한다.
    // 1개만 통과할땐 2초가 소요된다.(time=길이)
    // 그럼 그 1개만 통과하고, 2번과 3번이 만약 max_weight보다 작으면 두개를 한번에 통과시켜도 된다.
    // 2개가 한번에 통과된다면 1초가 소요된다.(time +1)
    // 이게 파이프처럼 만약 10버티는 다리에 4가 먼저 진입하고 5가 이후에 진입해서 2대가되면, 4가먼저빠지는게 1초, 5가 빠지는게 1초, 그이후에 만약 또 4라면 1초, 마지막에 4가 한번 더 빠져나가는데 1초

    // 우선 Queue 객체는 다리라고 생각하면 되고
    // 다리에 트럭들을 순서대로 넣고 빼는것을 만드는것이 기본
    // 조건으로 Queue에 들어갈 수 있는 조건을 만들어야 한다.
    // 만약 다리에 첫번쨰요소가 들어갔다. 그럼 기본적으로 1초가 상승하고 length만큼 상승할것이다.
    // 그런데 두번째 요소가 들어 갈 수 있다면(둘을 더한값이 최대보다작다면)
    // 마지막요소의 시간만 재면된다. 따라서 +1상태에서 길이만큼 시간이 걸리는게 그 2개가 통과하는 시간이다.


    public int Solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> waitQueue = new LinkedList<>(); //대기큐
        Queue<Integer> progressQueue = new LinkedList<>(); //건너는중큐
        Queue<Integer> timeQueue = new LinkedList<>(); //시간체크용큐
        Queue<Integer> completeQueue = new LinkedList<>(); //완료큐

        // 우선 모든 차량을 대기큐에 추가
        for (int truckWeight : truck_weights) {
            waitQueue.add(truckWeight);
        }

        int minute = 0;
        int bridgeWeight = 0;
        int bridgeTruckCount = 0;

        // 다리를 완전히 지난 트럭 개수와 총 트럭 개수가 같아질 때까지 반복할 것이다.
        while (completeQueue.size() != truck_weights.length) {
            minute++;  // 시간 증가

            // 다리를 완전히 지난 트럭의 처리
            if (timeQueue.peek() != null && timeQueue.peek() == bridge_length) {
                timeQueue.poll();  // 가장 앞에 있는 트럭의 지나간 시간을 큐에서 제거
                bridgeWeight -= progressQueue.poll();  // 가장 앞에 있는 트럭의 무게를 다리 무게에서 빼기
                bridgeTruckCount -= 1;  // 다리 위의 트럭 개수 감소
                completeQueue.add(1);  // 다리를 완전히 지난 트럭의 개수 증가
            }

            // 대기 중인 트럭의 처리
            if (waitQueue.peek() != null) {
                int truck = waitQueue.peek();  // 대기 중인 트럭의 무게
                if (truck + bridgeWeight <= weight && bridgeTruckCount < bridge_length) {
                    bridgeWeight += truck;  // 다리 무게에 트럭 무게 추가
                    bridgeTruckCount++;  // 다리 위의 트럭 개수 증가
                    progressQueue.add(waitQueue.poll());  // [[[대기 중인 트럭을 다리로 이동]]]
                    timeQueue.add(0);  // 다리 위에 올라간 트럭의 지나간 시간 초기화 (0분부터 시작)
                }
            }

            // 다리 위에 있는 각 트럭의 지나간 시간 업데이트
            for (int i = 0; i < timeQueue.size(); i++) {
                timeQueue.add(timeQueue.poll() + 1);  // 다리 위에 있는 트럭의 지나간 시간을 1분씩 증가
            }
        }
        answer = minute;  // 최종 소요된 시간 저장
        return answer;
    }
    public static void main(String[] args){
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        Solution2 sol = new Solution2();
        System.out.println(sol.Solution(bridge_length,weight,truck_weights));
    }
}
