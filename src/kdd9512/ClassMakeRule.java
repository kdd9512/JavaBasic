package kdd9512;
/**
 * 클래스 종류
 * VO/DTO : ValueObject, DataTransfer Object.
 * 계층간 데이터교환을 위한 자바빈즈를 의미
 * 값만 저장하기 위해 생성하는 클래스. 주로 데이터베이스 테이블의 각 열과 연계해서 작성함.
 * <p>
 * DAO : Data Access Object
 * 데이터베이스를 이용, 데이터를 추가/조회/수정/삭제하는 기능을 전담하는 클래스
 * VO 클래스와 연계하여 작성함.
 * 인터페이스로 기능을 정의하고, 클래스로 구현함.
 * <p>
 * Service : 비지니스 로직 터리를 담당.
 * VO로 저장된 DAO로 넘기기 전에 처리해야 하는 일반적인 작업을 기능으로
 * = 전처리
 * <p>
 * 일반적 3tier 프로그래밍 흐름
 * J2EE 개발에 최적화된 방식.
 * VO -> Service -> DAO */
public class ClassMakeRule {
    public static void main(String[] args) {
        //세금계산을 위한 객체 생성.
        Computetax choi = new Computetax(3500, 1);

        System.out.println(choi.manageTax());

        choi = new Computetax(7800, 0);
        System.out.println(choi.manageTax());
    }
}
class Computetax { //클래스 내부 변수를 private 로 지정하여 암호화.
    private int salary; //월급
    private int isMarried; // 긍정은0 부정은 1

    public Computetax() {}//기본 생성자.

    public Computetax(int salary, int isMarried) {//생성자. 일종의 양식이며, 이 틀을 기준으로 값만 입력하게끔 하는 것이다.
        this.salary = salary;
        this.isMarried = isMarried;
    }

    public void setSalary(int salary) {//setter 자동완성은 ALT +INSERT
        this.salary = salary;
    }

    public void setIsMarried(int isMarried) {
        this.isMarried = isMarried;
    }

    public int getSalary() {//getter. 자동완성은 ALT +INSERT
        return salary;
    }

    public int getIsMarried() {
        return isMarried;
    }

    public double manageTax() {//세금계산.

        double tax = 0.0; //결과를 받을 새 변수 tax 의 값 초기화.
        if (isMarried == 0) {//기혼일 때 조건
            if (salary < 6000)
                tax = salary * 0.15;
            else
                tax = salary * 0.35;
        } else if (isMarried == 1) { //미혼일 때 조건
            if (salary < 3000)
                tax = salary * 0.10;
            else
                tax = salary * 0.25;
        }
        return tax; //tax 값 반환.
    }

}//class끝







