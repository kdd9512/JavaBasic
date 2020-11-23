package kdd9512;

/**
 * 인터페이스
 * 추상메서드와 상수만으로 구성된 특수클래스.
 * 어떤 클래스를만들 때, 추상메서드를 통해
 * 기본 틀을 제공하여 그 규칙에 맞는 코드를 짤 수 있게 해 주는 역할.
 * 한마디로 서류 양식만을 제공하는 클래스.
 *
 * **접근자는 무조건 public 으로 고정.**
 *
 * 클래스와는 달리 다중상속을 지원한다.
 *
 * 작성 시,  interface 를 사용.
 * 구현 시, implements 를 사용
 *
 */
public class Interface {
    public static void main(String[] args) {
        Cat3 ct3 = new Cat3();
        Dog3 dg3 = new Dog3();
        Murloc mrl = new Murloc();

        System.out.println(ct3.cry());
        System.out.println(dg3.cry());
        System.out.println(mrl.cry());
    }
}
class Animal3{
    protected int weight;
    protected int height;
}

interface Animal3Action {
    //=public static String COLOR = "brown";
    String COLOR = "brown";

    abstract String cry();//규칙에 맞는 코드를 짤 수 있게끔 틀만 제공함. 그렇기에 cry() 안의 내용은 없는 것.
    // = 그냥 변수유형 변수명 만 제시하여 String cry(); 로 써도 가능하다.
    // 이 경우, 원문 public abstract String cry(); 을 축약한 효과가 나옴.

    // protected abstract String cry(); 는 허용하지 않는다.
    // 애초에 양식을 제공하기 위해 존재하는 클래스인데 그 역할이 불가능해 지기 때문
}
class Cat3 extends Animal3 implements Animal3Action {//불완전메서드 작성 뒤 ALT + ENTER 후 Animal3Action 오버라이드.

    //Animal3의 하위클래스(extends)이며, Animal3Action 메서드로 이를 구현함(implements){}
    @Override
    public String cry() {
        return "야_옹";
    }
}//하나하나 다 끊어줘야 한다. 이 괄호는 Cat3를 닫는 중괄호.
class Dog3 extends Animal3 implements Animal3Action{
    @Override
    public String cry() {
        return "ㅁㅓㅇ";
    }
}
class Murloc extends Animal3 implements Animal3Action{

    @Override
    public String cry() {///멀록[...]
        return "아옳옳옳";
    }
}

//다소 코드가 복잡해질 순 있으나, 유지보수가 매우 간편해지는 명확한 장점이 있는 방법이다.
