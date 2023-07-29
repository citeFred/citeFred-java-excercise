package _06OOP;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Car car0 = new Car(); //<-- 클래스의 기본 생성자를 호출하여 객체를 생성했다. 인스턴스를 호출, 인스턴스화 했다고도 부른다.
        System.out.println(car0); // _06OOP.Car@251a69d7  <-- 주소값이 출력된다.
        car0.gasPedal(80.51);
        System.out.println("car0의 속도는 : "+car0.speed);

        //-------------------

        //배열로 생성해보고 각 객체의 속성을 변경 해보자.
        Car[] carArray = new Car[3];

        Car car1= new Car();
        car1.changeGear('P');
        carArray[0] = car1;
        Car car2 = new Car();
        car2.changeGear('N');
        carArray[1] = car2;
        Car car3 = new Car();
        car3.changeGear('D');
        carArray[2] = car3;

        for (Car car:carArray){
            System.out.println("car.gear : "+ car.gear);
        }


        //예습 클래스도 여기에 객체를 생성해보자.
        _01Prac_HowToMakeClass calculator1 = new _01Prac_HowToMakeClass();
        Scanner sc = new Scanner(System.in);
        System.out.println(calculator1);
        System.out.println("Num1 입력");
        calculator1.num1 = sc.nextInt();
        System.out.println("Num2 입력");
        calculator1.num2 = sc.nextInt();
        calculator1.Summary(calculator1.num1, calculator1.num2);
        System.out.println(calculator1.sum);

        //---------------------------
        System.out.println("-------초기값 설정 테스트 내부 접근--------");
        Car car = new Car(); // 객체 생성

        //초기값 기본 값 확인 : 초기값을 준 것은 그 값이 들어가고, 아닌 값은 default value가 set 된다.
        System.out.println("--------------------");
        System.out.println("car.model : "+car.model); //<- 내부에서 초기화 한 것
        System.out.println("car.model : "+car.color);
        System.out.println("--------------------");
        System.out.println("car.model : "+car.speed);
        System.out.println("car.model : "+car.gear);
        System.out.println("car.model : "+car.lights);//<- 내부에서 초기화 한 것
        System.out.println("--------------------");
        System.out.println("car.model : "+car.tire);//<- 내부에서 초기화 한 것
        System.out.println("car.model : "+car.door);

        System.out.println("-------초기값 설정 테스트 외부 접근--------");
        //필드 사용(<-외부 접근 외부에서(메인에서) 객체 내 초기화 한 것
        car.color = "blue";
        car.speed = 100;
        car.lights = false;//<- 내부에서 초기화 한 것인데 외부에서 한번 더 필드 변경한 것
        System.out.println("car.model : "+car.color);
        System.out.println("car.model : "+car.speed);
        System.out.println("car.model : "+car.lights);//<- 외부에서 재설정하여 이것이 적용 된다.
    }
}
