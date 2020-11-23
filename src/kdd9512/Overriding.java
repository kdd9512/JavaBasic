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
        Animal a = new Animal();
        //부모클래스 객체화. 추상클래스에서는 이는 언제나 표본이고 자식 클래스에서 이를 정의한다.

        System.out.println(ct.cry());
        System.out.println(dg.cry());
        System.out.println(a.cry());
    }

}
class Animal{// 상속관계에 있는 클래스에는 protected 를 붙힌다. 원래기준을 수정 못하게 하기위함.
    protected String cry(){return "동물이 웁니다";}
    //추상클래스로 만들 경우, 이게 없어도 작동한다.
    // protected 가  abstract로 바뀌고 값을 담을 수 없기 때문에(=객체화 불가능) return값은 사라지지만.
}
class Cat extends Animal{ //오버라이드 구현 CTRL + SPACE 후 검색.
    @Override
    protected String cry() {return "야옹";}
}
class Dog extends Animal{
    @Override
    protected String cry() {return "멍";}
}
