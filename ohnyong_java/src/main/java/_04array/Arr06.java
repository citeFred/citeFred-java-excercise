package _04array;

public class Arr06 {
    public static void main(String[] args) {
        //다차원 배열 Multidimensional Array
        //1) 기본 배열 생성
        int[][] array = new int[2][3];

        //1-1) 배열에 element 초기화(초기값) 반복문으로 넣기
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                System.out.println("출력값 : "+ i +", "+ j);
                array[i][j] = 0; //0으로 초기화하기
                /*i가 0일때,
                * j0 반복문진입 아직 i0, j0
                * 끝나서 j++로1 근대 아직 i0
                * 끝나서 j++로2 근대 아직 i0
                * 끝나서 j++3었는데, array의 [i].length가 2야
                * j조건이 2보다 작아야되 맨첨에 생성할때 i는2칸, j는 3칸이자나
                * 근대 저게 칸이지 사실 0, 1, 2로 3칸이지
                * 그래서 j가 3이되버렸는데 조건에 안맞아 그럼 끝나버리는거지
                * 그래서 j반복을 탈출해 그럼 i돌던거 돌아야지
                * i++로 1이되
                * 다시j로 들어와 j는 0부터 다시하지
                * 그럼 i는 1이됫고, j는 0이지아직
                * 그래서 1,0이찍히고 또 j반복문이 돌아야지
                * j만 1이되고 아직 i는 1인 반복문안쪽인거지
                * 이게 반복되 그래서 아래처럼 나오는거야
                * */
            }
        }
        //2) 가변 배열 생성
        int[][] array2 = new int[3][];

        //배열 원소(element)마다 각기 다른 크기로 지정
        array2[0] = new int[2];
        array2[1] = new int[4];
        array2[2] = new int[1];
        //반복문으로 조회(초기값 넣지 않았으니,int형이라 0일거임)
        //초기화 해볼까 20으로 다넣어보겠음.
        for(int i=0;i< array2.length;i++){
            for(int j=0;j<array2[i].length;j++){
                array2[i][j] = 20;
                System.out.println(array2[i][j]);
            }
        }

        //3) 생성, 초기화값 할당까지 한번에
        int[][] array3 = {
                {10, 20},
                {10, 20, 30, 40},
                {10}
        };
        // 조회해보자.
        for(int i=0;i<array3.length;i++){
            for(int j=0;j<array3[i].length;j++){
                System.out.println(array3[i][j]);
            }
        }
    }
}
