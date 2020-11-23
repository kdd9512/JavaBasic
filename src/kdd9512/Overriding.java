package kdd9512;

/**
 * 메서드 재정의 override
 * 객체지향 중요 3대개념중 다형성에 해당
 * 상속관계에 있는 상위클래스의 메서드를
 * 하위클래스에서 같은 이름의 메서드로 다시 작성하는 것.
 * 즉, 상속받은 메서드를 새로 정의해서 사용한다.
 *
 */

public class Overriding {
    public static void main(String[] args) {
        Animal ct = new Cat();
        Animal dg = new Dog();
        System.out.println(ct.cry());
        System.out.println(dg.cry());

    }

}
class Animal{// 상속관계에 있는 클래스에는 protected 를 붙힌다. 원래기준을 수정 못하게 하기위함.
    protected String cry(){return "동물이 웁니다";}
}
class Cat extends Animal{ //오버라이드 구현 CTRL + O
    @Override
    protected String cry() {return "야옹";}
}
class Dog extends Animal{
    @Override
    protected String cry() {return "멍";}
}