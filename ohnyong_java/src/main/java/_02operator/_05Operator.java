package _02operator;

public class _05Operator {
    public static void main(String[] args) {
        //        - 산술 연산자Arithmetic Operators : +, -, *, /, %, <<, >>
        //        - 비교 연산자Comparison operators : >, <, >=, <=, ==, !=
        //        - 논리 연산자Logical operators : &&, ||, !
        //        - 대입 연산자Assignment Operators : =, ++, --
        //        - 기타 연산자 : (type), ? :, instance of
        //x + y = z
        int x = 5;
        int y = 10;
        int z = x = y;
        System.out.println(z);

        //        산술 연산자
        System.out.println(4 + 2); //6
        System.out.println(4 - 2); //2
        System.out.println(4 * 2); //8
        System.out.println(5 / 2); //2
        System.out.println(4 / 2); //2
        System.out.println(4 % 2); //0
        System.out.println(4 % 2); //0

        //        우선순위 연산
        System.out.println(2 + 2 * 4); // 10 *가 먼저 됨
        System.out.println((2 + 2) * 4); // 16 ()가 먼저 됨

        //        변수를 이용한 연산
        int a = 2;
        int b = 10;
        int c;

        c = a + b;
        System.out.println(c); //12
        c = b - a;
        System.out.println(c); //8
        c = b / a;
        System.out.println(c); //5
        c = b % a;
        System.out.println(c); //0

        //        비교 연산자
        //        true or false
        System.out.println(10 > 9); //true
        System.out.println(10 >= 9); //true
        System.out.println(10 < 9); //false
        System.out.println(10 <= 9); //false
        System.out.println(10 == 9); //false
        System.out.println(10 != 9); //true
        System.out.println(10 != 10); //false

        //        논리 연산자
        //        비교 연산의 결과값으로 받을 수 있는 boolean 값을 연결하는 연산자
        //        조건을 연결 하였을 때 boolean 값들을 조합하여 true or false 값인 boolean값을 출력
        //        &&, ||, !
        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag3 = false;

        System.out.println(flag1);
        System.out.println(flag2);
        System.out.println(flag3);

        //        1) 피 연산자 중 **하나라도** true이면 true => ||  (or)
        System.out.println(flag1 || flag2); //true
        System.out.println(flag1 || flag2 || flag3);//true
        //        2) 피 연산자 중 **모두** true이면 true => &&  (and)
        System.out.println(flag1 && flag2);//true
        System.out.println(flag1 && flag2 && flag3);//false

        System.out.println((5 > 3) && (3 > 1));//true
        System.out.println((5 > 3) && (3 < 1));//false
        System.out.println((5 > 3) || (3 < 1));//true
        System.out.println((5 > 3) || (3 < 1));//true

        //        논리 부정 연산자 (! : NOT)
        System.out.println(!flag1); //false
        System.out.println(!flag3); //true
        System.out.println(!(5 == 5));//false
        System.out.println(!(5 == 3));//true


        //        대입 연산자
        //        변수를 바로 연산해서 그 자리에서 저장(대입하는) 연산자
        //        =(기본 대입 연산자), +=, -=, *= ...(복합 대입 연산자)
        int number = 10;
        number = number + 2;
        System.out.println(number);

        number = number - 2;
        System.out.println(number);

        number = number * 2;
        System.out.println(number);

        number = number / 2;

        System.out.println(number);

        number = number % 2;
        System.out.println(number);

        //복합대입연산자
        number += 2;
        System.out.println(number);

        number -= 3;
        System.out.println(number);
        number *= 3;
        System.out.println(number);
        number /= 3;
        System.out.println(number);
        number %= 5;
        System.out.println(number);

        number++;
        System.out.println(number);
        number--;
        System.out.println(number);

        //++, -- 사용 시 주의할 점
        int aa = 10;
        int bb = 10;
        int val = ++aa + bb--; // 11+9 =20
        System.out.println(val); //but 21 cuz 11+10 then bb->9
        System.out.println(aa);//11
        System.out.println(bb);//9 then bb->9  bb-- <<--

        //기타 연산자
        //1) 형변환 연산자
        int intNumber = 93 + (int) 98.8;
        System.out.println(intNumber);
        double doubleNumber = (double) 93 + 98.923;
        System.out.println(doubleNumber);
        //2) 삼항 연산자 ***
        //비교 연산자와 항상 함께 쓰인다.
        //비교연산자의 결과 : true or false ->이 결과에 따라 결정되는 무언가!
        int xx = 1;
        int yy = 9;

        //xx가 yy랑 다른가? -> 다릅니다. -> false
        boolean bbb = (xx == yy) ? true : false;
        System.out.println(bbb); //false

        //xx가 yy랑 같지 않지? -> 같지 않습니다 -> 정답
        String s = (xx != yy) ? "정답" : "오답";
        System.out.println(s);//정답

        //xx가 yy보다 작니? -> 작습니다 -> xx=값을 출력해
        int min = (xx < yy) ? xx : yy;
        System.out.println(min);

        //3) instance of(3주차 -> 클래스와 객체 배울때 자세히)
        //Class, 객체를 배워야 한다.
        //피 연산자가 조건에 명시된 클래스의 객체인지 비교하여
        //맞으면 -> true
        //틀리면 -> false


        //연산자의 우선순위
        //연산자의 우선순위 : 산술 > 비교 > 논리 > 대입
        //-- 연산자가 열개 함께 있는 연산을 계산 할 때는 우선순위가 있다.
        //--위 우선순위에 따라서 최종적인 응답값이 결정
        //단, 괄호로 감싸주면 괄호안의 연산이 최우선순위로 계산
        int e = 2;
        int f = 9;
        int g = 10;
        boolean result = e < f && f < g;//맞음, 맞음 -->&& true
        System.out.println(result);
        result = e + 10 < f && f < g;//틀림, 맞음 -->&&  false &&는 1개라도 아니면 아님 *생각
        System.out.println(result);
        result = e + 2 * 3 > g;//*먼저 8 ->아님 false
        System.out.println(result);

        //연산자의 형변환(자동 - Promotion)
        short h = 10;
        int i = 20;
        int j = h + i; //
        long lx = 30L;
        long lz = j + lx;

        float fh = h;
        float fi = i;
        float fz = j;

        System.out.println(lz);
        System.out.println(fh);
        System.out.println(fi);
        System.out.println(fz);

        //비트연산
        //    -Byte 를 8등분 한것이 Bit(2진수)
        //    -bit = 0, 1 둘중의 하나의 값만을 저장하는 컴퓨터가 저장(표현)가능한 가장 작은 단위
        //-컴퓨터의 가장 작은 단위인 Bit이기 때문에 연산중에는 Bit연산이 가장 빠름
        //-물론 이전에 배운대로 0,1 값으로 산술연산하거나, 비교연산을 할 수 있지만 비트 연산을 통해 자리수를 옮길 수도 있음
        //이처럼 Bit의 자리수를 옮기는 것을 비트연산이라고 함
        //'<<'(왼쪽으로 자리수 옮기기), '>>'오른쪽으로 자리수 옮기기
        //0, 1은 2진수 값이기 때문에,
        //  -자리수를 왼쪽으로 옮기는 횟수 만큼 2의 배수로 곱셈이 연산 되는 것과 동일 2^2 -> 2^3 된것이니  *2의 배수만큼 곱셈(승이하나올라간다보면됨)
        //  -자리수를 오른쪽으로 --> 2의 배수로 나눗셈 --> 2^3 -> 2^2 된것이니 /2의 배수만큼 나눗셈
        // 1010 -> 0101 이되는것은
        // 10 -> 5 라보면됨
        System.out.println(3 << 2);
        //3= 11, 2만큼 왼쪽으로 옮겨달라
        // 11(00), 옮겨져서 빈곳에 00이 생긴다
        // 2^3 + 2^2 + 0 + 0 = 8+ 4 + 0 + 0 = 12
        System.out.println(3 << 1);
        // 11 을 1만큼 왼쪽
        // 11(0)
        // 2^2+2^1+0 = 4+2+0 = 6
    }

}

