package kdd9512;

/**
 * 추상 클래스
 * 추상 메서드를 포함하는 클래스
 * 추상 메서드 : 메서드의 선언부만 있고, 몸체가 없는 메서드.
 * 메서드의 몸체는 이것을 상속하는 자식(=하위) 클래스에서 정의함.
 * 따라서, 추상클래스는 불완전 클래스이므로, 객체화할 수 없음.
 * 추상 메서드나 추상 클래스는  abstract 라는 키워드를 사용함.
 *
 * 1. 부모클래스를 상속하고 싶지 않을때.
 * 2. 어차피 오버라이딩 해서 만들 메서드라면 굳이 부모클래스가 필요하지 않을 수 있음.
 *     그떄 사용.
 *
 */
public class AbstractClass {
    public static void main(String[] args) {
//        Animal2 a1 = new Animal2();
        Cat2 c2 = new Cat2();
        Dog2 d2 = new Dog2();
        System.out.println(c2.cry());//이처럼 그냥 이전에 객체 끌어오듯 아래에서 메서드만 오버라이드 하고 그걸 선언하는 식이다
        System.out.println(d2.cry());//기본클래스를 요구하지 않기 때문에 가능한 것.
    }
}

abstract class Animal2 {
    protected  int weight;
    abstract String cry(); //추상 메서드. () 뒤를 보면 메서드인데도 {} 가 없다. 일종의 그냥 '틀'.
}
class Cat2 extends Animal2 {
    @Override
    String cry() {//불완전한 클래스를 오버라이딩.
        return "야옹";//
    }
}
class Dog2 extends Animal2{
    @Override
    String cry() {
        return "멍";
    }
}