package kdd9512;

/**
 * 메서드 다중정의
 * 객체지향 3대 중요개념(캡슐화, 상속, 다형성) 중 하나인 " 다형성 " 에 해당.
 * 같은 이름의 메서드를 중복해서 정의 가능한 것을 의미함.
 * 한 클래스에 같은 이름의 메서드가 2개 이상 존재하는 것이 가능.
 * 단, 메서드의 서명이 서로 다르게 정의되어 있어야 한다는 조건이 있음
 */
public class OverLoading {
    public static void main(String[] args) {
        NonOverloading nol = new NonOverloading();
        ApplyOverloading aol = new ApplyOverloading();

        System.out.println(nol.sumInt(15,15));
        System.out.println(nol.sumDoub(15.2,232.11));
        System.out.println(nol.sumInt2(15,25,35));
        System.out.println(aol.sum(12,22));
        System.out.println(aol.sum(55.15,25.1));
        System.out.println(aol.sum(121,333,151));

    }
}
class NonOverloading {

    //간단한 덧셈 프로그램

    //1. 정수 2개를 더하는 프로그램
    public int sumInt(int a, int b) {
        return a + b;
    }

    //2. 실수 2개를 더하는 프로그램
    public double sumDoub(double a, double b) {
        return a + b;
    }

    //3. 정수 3개를 더하는 프로그램
    public int sumInt2(int a, int b, int c) {
        return a + b + c;

    }
}
    // 메서드 오버로딩이 구현되지 않은 경우,
    // 생성한 메서드마다 이름을 제각각으로 정해야하기에
    // 개발자가 일일히 기억해서 사용해야 하는 불편함이 존재한다.
    // 메서드명 중복을 허용하지 않기 떄문.


class ApplyOverloading {
        public int sum(int a, int b) {
            return a + b;
        }

        public double sum(double a, double b) {
            return a + b;
        }

        public int sum(int a, int b, int c) {
            return a + b + c;
        }

    }
    //메서드 다중정의를 적용하면,
    //위와 같이 메서드의 이름을 하나로 통일해서 작성할 수 있다.
    //내용이 다르다면, 일일히 메서드명을 다르게 지어줄 필요가 없다.
    //단, 메서드를 어떻게 호출할지만 알고 있으면 됌.

