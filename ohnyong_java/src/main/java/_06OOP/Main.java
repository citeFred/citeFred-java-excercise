package _06OOP;

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
        System.out.println(calculator1);
        //calculator1.toString()
    }
}
