package kdd9512;

/**객체 지향 프로그래밍 개요
 * 모든 데이터를 객체로 취급하여 소프트웨어를 개발하는 방식.
 *
 * 객체 : 실생활에서 우리가 인식하는 유/무형의 사물.
 * Ex) 집, 자동차, 인간, 급여, 주문, 동물....
 * 클래스 : 객체를 만들어 내기 위한 틀, 설계도.
 * 클래스는 객체의 상태를 나타내는 ①필드/속성과
 * 객체의 기능을 나타내는 ②메서드로 구성되어 있음.
 *
 * 클래스는 객체의 설계도 이며 실제 정보는 저장할 수 없음.
 * 실제 정보를 저장하려면 객체가 요구되며, 객체를 선언하는 과정을
 * 개체화(instanate) 라고 함.
 * 개체화를 통해 나온 결과물을 객체/인스턴스라고 하는데,
 * 클래스에 정의된 필드와 기능이 실제 메모리상에 할당된 것을 말함.
 */


public class OOP {

    public static void main(String[] args) {
        // Person 클래스 이용하여 객체 생성.
        // 클래스명 객체명 = new 생성자
        Person choi = new Person();
        Person lee = new Person();
        Person kim = new Person();
        //하나의 객체명에 다섯가지 변수가 담겨있다.
        //변수 압축이 가능하단 소리.

        //객체 변수(멤버변수)의 값 대입
        //틀은 마련되어 있으나, 값은 써주어야 하므로.
        choi.name = "최승희";
        choi.job = "의사";
        choi.age = 45;
        choi.gender = "여";
        choi.blood = "A";

        lee.name = "이미녀";
        lee.job = "골퍼";
        lee.age = 28;
        lee.gender = "여";
        lee.blood = "O";

        kim.name = "김미남";
        kim.job = "교수";
        kim.age = 47;
        kim.gender = "남";
        kim.blood = "AB";

        //멤버변수 출력
        System.out.println(choi.name);
        System.out.println(choi.job);
        System.out.println(choi.age);
        System.out.println(choi.gender);
        System.out.println(choi.blood);



    }



}// OOP class 끝

// 클래스 정의 : 접근제한자 클래스명 {
//      필드
//      메서드
// }
// Ex)최승희 : 의사, 45, 여, A
//    이미녀 : 골퍼, 28, 여, O
//    김미남 : 교수, 47, 남, AB
class Person { //데이터 저장을 위한 틀.
    String name;
    String job;
    int age;
    String gender;
    String blood;

}