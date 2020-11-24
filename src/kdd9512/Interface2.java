package kdd9512;

/**
 * 인터페이스는 대상을 바라보는 관점에서 설명할 수 있음
 * 1. 식당에서 주문을하려는 고객 입장에서
 * "메뉴 A" 는 하나의 메뉴임. -> 단순정보이며, 복잡한 정보가 불요
 *
 * 2. 식당에서 조리를 하는 조리사 입장에서
 * "메뉴 A" 를 생산하기 위해 필요한 작업이므로 복잡한 정보를 요구함.
 *
 * 3. 식당에서 고객과 조리사를 관리하는 점주 입장에서
 * "메뉴 A"는 하나의 상품.
 * -> 하나의 사업이므로 식당운영에 필요한 정보가 요구됌.
 *
 * 같은 대상이라도 자신의 입장에서 바라보는 시선이 다름.
 * -> 프로그래밍 세계에서는 특정 대상에 대해 누구나 동일한 시선을
 * 제공해야 할 필요가 있음.
 *  = 인터페이스를 강제하는 것이 가능함.
 *
 * 대부분의 음식점에서 "메뉴 A" 를 요리하고 있음
 * 하지만, 조리사의 역량에 따라 기본을 유지하면서 제각각의 결과믈울
 * 만들어 내는 것이 가능.
 * 식당 별, 조금의 차이는 존재하나,
 */

/*기본 베이스 클래스.
 1. 인터페이스를 구현하면 자식클래스에는 추상메서드를 반드시 재정의해야 함.
    만일 재정의하고 싶지 않거나, 그럴 필요가 없는데도 재정의해야 하는 단점이 존재
    - > 이 경우, 추상클래스를 통해 임의로 구현한 후, 이 추상클래스를 상속해서
    클래스를 만드는 것이 편리함. 이를 기본 클래스라고 함.
 */

    //실질적인 예.
    //github.com/javaee/servlet-spec
    //src/main/java/javax/Servlet -> Servlet.java
    //src/main/java/javax/Servlet -> GenericServlet.java
//src/main/java/javax/Servlet/http -> HttpServlet.java


public class Interface2 {
    public static void main(String[] args) {
        Cat4 c4 = new Cat4();
        Dog4 d4 = new Dog4();

        System.out.println(c4.cry());
        System.out.println(d4.cry());

    }

}
class Animal4 {
    protected int height;
    protected int weight;

}
interface  Animal4Action {
    String cry();
}
class Animal4Base extends Animal4 implements Animal4Action{

    @Override
    public String cry() { return "동물이 웁니다"; }
}
class Cat4 extends Animal4Base { }
class Dog4 extends Animal4Base {
    @Override
    public String cry() {return "멍";}// 새로운 값을 원한다면 역시 이전과 같이 오버라이딩 하여 값을 재설정.
}

//재정의 되어 있는 것을 끌어온것이기 때문에, 여기서 또 값을 넣어 정의할 필요가 없음. 이미 안에 클래스와 인터페이스가 설정되어 있음.