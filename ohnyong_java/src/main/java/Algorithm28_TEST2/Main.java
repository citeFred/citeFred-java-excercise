package Algorithm28_TEST2;
/*
😃 **2번 문제) Triangular Output (2점)**
😃 설명) 첫째 줄에 정수 n이 주어진다. (0≤n≤100)
### 출력
다음 예제와 같이 삼각형 모양으로 ‘*’을 출력하세요.
n=3
->
*****
 ***
  *
 ***
*****

n=5
->
*********
 *******
  *****
   ***
    *
   ***
  *****
 *******
*********
(공백의 개수와 별의 개수를 정확하게 확인해주시길 바랍니다. 🙆🏻‍♂️)
*/
public class Main {

    public void solution(int star) {
        // "*"과 " "을 star라는 정수 따라 조건으로 구분해서 출력시켜야 한다.
        //결과적으로 공백과 별을 조건에 따라 붙이는 식으로 간다.
        String starStr = "*"; //별
        String spaceStr = " "; //공백

        //위에서부터 그리기, star 3, 2 , 1
        for (int i=star ; i>=1; i--) {//<<-- 행을 표현,

            //i=star입력값에 따라 가고, 예로 3인경우 3 -> 2 -> 1 될 때 종료
            //공백출력
            //첫번쨰 바퀴에서는 i=3;i>=1;i++
            //공백이 없다.      j=2;2>=3;j-- <<실행안됨,
            //별만있다.         j=1;1<=5;j++ <<5번 실행됨, *****가 찍힘
            //줄바꿈 이후,
            //두번째 바퀴       i=2;i>=1;i++
            //공백이 생긴다.    j=2;2>=2;j-- <<같기 때문에 1회실행,
            //별은?             j=1;1<=3;j++ <<j가 1,2,3까지 증가해도 실행되니 3회실행.

            //열을 표현, j=2 ; j>=3; j--
            //공백출력 부분입니다.
            for (int j=star-1; j>=i; j--) { // i=3인 상태에서 공백은 1개로 j는 star-1개로 시작한다 j=2 -> 1 -> 0 될 때 종료
                System.out.print(spaceStr); //
            }
            //별출력 //j1 1 < 5 ; j++
            for (int j=1; j<=2*i-1; j++) {
                System.out.print(starStr); //5
            }
            System.out.println();
        }
//5줄의 연산을 수행하게 됩니다.
        //만나는 지점 반전 시작 i 2 -> 3 ,
        for (int i=2; i<=star; i++) {
            //공백출력
            for (int j=1; j<=star-i; j++) {
                System.out.print(spaceStr);
            }
            //별출력
            for (int j=1; j<=2*i-1; j++) {
                System.out.print(starStr);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Main method = new Main();
        int star = 3;
        method.solution(star);
    }
}