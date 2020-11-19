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

        // 기본 생성자로 초기화된 변수 확인.
        System.out.println(choi.name);
        System.out.println(kim.name);
        System.out.println(lee.name);

        //하나의 객체명에 다섯가지 변수가 담겨있다.
        //변수 압축이 가능하단 소리.

        //매개변수 생성자를 이용한 객체 생성 및 초기화.
        Person song = new Person("승희","의사",45,"여","A");





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

    // 기존것은 각 변수별로 값을 일일히 써야 해서 불편함.
    //-> 생성자를 이용하여 이러한 불필요한 반복작업을 줄이는 것이 가능함.

    //  생성자 constructor
    //  멤버변수 값을 초기화시키는 특수한 메서드.
    //  public 클래스명 (매개변수,...){
    //        변수 초기화
    //  }
    //기본 생성자. 이게 기본값이 되는 것.
    public Person(){
        name = "홍길동";
        job = "무사";
        age = 18;
        gender = "남";
        blood = "O";


    }
    // 매개변수를 사용하는 생성자.
    // 매개변수명과 멤버변수명이 같은 경우
    // 변수가림 shadowing 현상이 발생함.(앞의 값이 뒤의 값을 가려버리는 현상.)
    // 클래스의 멤버변수임을 명확히 표기하기 위해
    // 변수명 앞에 this 라는 키워드를 추가 작성한다.

    public Person(String name, String job, int age, String gender, String blood) {
        this.name = name;
        this.job = job;
        this.age = age;
        this.gender = gender;
        this.blood = blood;
        //초기화. 메서드 내용에 주목.
    }
}