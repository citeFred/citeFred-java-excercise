package _04array;

public class Arr08 {
    public static void main(String[] args) {
        //최대값 구하기 연습
        int[] arr = {3, 4, 8, 23, 1};

        //최대값 초기화 세팅(아직 최대값 아님, 비교를 위해 기준점을 잡는다고 생각해야 된다.)
        int max = arr[0];

        //최대값 구하기 로직 - 하나씩 비교를 시작하자
        for (int num:arr){
            if(num>max){ //만약 idx[0]부터 시작해서 넣은 값인 num이, 초기화한 max보다 크면,
                max = num; //num을 max에 넣자. 를 반복하는 것이 모든 element를 하나씩 점진적으로 비교.
            }
        }
        System.out.println("idx 0 element를 초기값으로 설정하고 옆으로  하나씩 비교를 하고 맞으면 max에 넣었더니 최대값은 : "+max);

        //최소값 구하기 연습
        int[] arr2 = {51,2,15,123,6,19,9};

        int min = arr2[0];
        //일단 기준점을 idx[0]인 element 51을 기준으로 잡는다. 왜? for문을 idx 0부터 시작해서 비교할꺼니까.
        //만약 idx를 5처럼 중간에서 시작해버리면, for문이 애매해진다. 기본적으로 0부터 idx++로 1개씩 가는 로직이니까
        for(int element:arr2){
            if(element<min){ // max를 구한 for문과 동일한 검색 방법. 배열의 요소를 하나씩 점진적으로 검사
                min = element;
            }
        }
        System.out.println(min);
    }
}
