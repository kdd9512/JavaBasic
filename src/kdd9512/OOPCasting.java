package kdd9512;

/**
 * 클래스/인터페이스 형변환
 * 특정 객체가 자식클래스/인터페이스 타입에서
 * 부모클래스/인터페이스 타입 또는 반대로 형변환하는 것을 의미함.
 */
public class OOPCasting {
    public static void main(String[] args) {
        Unit u1 = new Unit();
        Marine m1 = new Marine();
        Firebat f1 = new Firebat();

        u1.attack();
        m1.attack();
        f1.attack();

        Unit unit = new Marine();
        // Marine 객체가 자동으로 Unit 객체로 형변환.
        // 자식 객체가 부모 객체로 형변환 되었다.
        // 이처럼 상속관계에 있는 클래스 간의 객체 생성시
        // 자식클래스 타입의 객체를 부모클래스 타입의 객체로
        // 선언하는 경우를 "업캐스팅(Upcasting)" 이라고 한다.
        unit.attack();



       // Firebat f2 = (Firebat) new Unit();
        // Unit 객체를 Firebat 객체로 변환하려면
        // 앞에 (객체명)을 추가하여 명시적 형변환이 필요함.
        // 부모클래스타입의 객체를 자식클래스타입의 객체로
        // 선언하는 경우를 "다운캐스팅(Downcasting)" 이라고 한다.
        // 컴파일 시에는 오류가 없다고 나오나
        // 실제 실행하면 오류가 발생한다.
        //f2.attack();

        // Marine m3 = new Marine();

        Marine m2 = (Marine) unit;
        // Unit 객체변수를 Marine 객체변수로 다운캐스팅

        m2.attack();
        // 이건 실행된다.
        // -> unit 변수는 Marine 객체를 Unit 객체로 만든 것(=업캐스팅)이기 때문.(업캐스팅 참고. 대소문자 구분 주의)
        // 따라서, Marine 객체로의 형변환이 가능.


    }

}

class Unit {
    protected int hp;
    protected int ap;

    public void attack() {
        System.out.println("공격중");
    }
}

class Marine extends Unit {
    @Override
    public void attack() {
        System.out.println("공격1");
    }
}

class Firebat extends Unit {
    @Override
    public void attack() {
        System.out.println("공격2");
    }
}


