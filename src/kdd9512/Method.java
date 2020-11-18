package kdd9512;


/**
 * /* 파일명 : SungJukV2c
 * 작성일 : 2020.11.17
 * <p>
 * 프로그램설명 : 성적처리 프로그램 v3.
 * 학생 3명의 데이터를 이용.
 * 100점 만점. 100~90, 89~80, 79~70, 69~60, 59~0 기준으로 학점 부여.
 * 학점기준 : 수,우,미,양,가.
 * switch문으로 학점을 계산하도록 함.
 * 변수명 : name, kor, eng, mat, sum, mean, grd.
 * 이름, 국어, 영어, 수학, 총점, 평균, 등급.
 * 단, 이하의 조건을 만족시켜야 한다.
 * 1. 성적처리 결과 출력시, 출력문을 단 하나만 사용할 것.
 * 2. Math.round()를 이용하여 소수점 둘째 자리까지 값을 반올림 할 것.
 * <p>
 * 성적처리 기능을 구현함으로써
 * 코드가 길어지고 내용파악이 어려워 지는 것을 방지하기 위해
 * 함수(메서드)로 재정의하여 코드를 개선.
 */

//메서드
//특정 작업을 수행하기 위해 작성한 명령어들의 묶음
//C의 함수와 비슷한 성격을 가지는 프로그래밍 요소
//입력값을 통해 무언가를 하고 그 결과를 도출하는수학의 함수(블랙박스)

//메서드의 목적
//프로그램을 작성하다보면 반복적으로 쓰인 코드를 종종 볼 수 있는데,
//효율적으로 작성하려면 반복문으로 처리하면 되겠으나,
//반복문이 반복된다면 구조가 필연적으로 복잡해지고
//코드 해석 및 유지보수가 난감해질 수 있다.

//메서드를 적용하면 기능별로 모듈화를 적용하므로, 프로그램의 가독성이 개선되어
//협업시에 유용하며, 유지보수에도 유리하다는 이점을 갖는다.
//한마디로 "보기 편하다".


public class Method {
    /**
     * 간단한 인사말 출력 메서드
     * public : 접근제한자, 외부 클래스가 이 메서드를 사용허가 여부
     * public 은 너도나도 다 쓸 수 있다는 뜻.
     * static :  정적 메서드 생성.
     * void : 공허값(형이 없다). 메서드가 반환하는 값이 없음.
     */
    public static void sayHello() {//메서드1
        System.out.println("Hello, world!");

    }

    public static void sayHello2() {//메서드2
        for (int i = 0; i < 3; i++) {
            System.out.println("Hello, world!!");
        }// Hello, world! 3번 출력.
    }


    //간단한 인사말을 출력하는 메서드 : sayHello3
    //단, 인사말은 언제든 변경하도록 재작성.
    //매개변수를 정의하는 것으로 인사말이 변한다.
    //변수값은 호출할 시 지정하여 변경함.
    //인삿말 출력을 메서드가 바로 하는게 아니라 호출한 대상으로 넘기기 때문.
    public static void sayHello3(String msg) {

        System.out.println(msg);

    }

    public static String sayHello4(String name) {
        return name;//String 값을 품게끔 조정한다.
        //return : 메서드 내에서 처리한 값을 외부로 보낸다.
        //return 시 값의 type(sayHello4 옆 괄호 내부) 과 메서드의 return type(static "String")은
        //반드시 일치해야 한다.
    }

    // 두 개의 정수를 매개변수로 선언하고
    // 사칙연산한 결과를 출력하는 메서드 : computeNum
    // ? + ? = ?
    // ? - ? = ?
    // ? * ? = ?
    // ? ÷ ? = ?
    public static Integer computeNum(int a, int b);{


        String fmt1 = "%d + %d = %d\n";
        String fmt2 = "%d - %d = %d\n";
        String fmt3 = "%d * %d = %d\n";
        String fmt4 = "%d / %d = %d\n";

        String result =
                String.format(fmt1, a,b,a+b) +
                        String.format(fmt2, a,b,a-b) +
                        String.format(fmt3, a,b,a*b) +
                        String.format(fmt4, a,b,a/b);
    }


   /* public static Integer computeNumAdd(int a, int b) { //값 일치를 위해 입력한 Integer = int
        int add=a+b;
        return add;
    }
    public static Integer computeNumSub(int a, int b) {
        int sub=a-b;
        return sub;
    }
    public static Integer computeNumMul(int a, int b) {
        int mul=a*b;
        return mul;
    }
    public static Integer computeNumDiv(int a, int b) {
        int div=a/b;
        return div;
    }*/ //나의 답

// 둘 이상의 정수를 매개변수로 선언하고, 그 정수를 범위로 설정하여
// 모든 수의 합을 구하고 출력하는 메서드 : computeAllSum
// ex) 5, 1 -> 1+2+3+4+5 = 15

    public static void computeAllSum(int x, int y) {
        int min = x;
        int max = y;
        int sum = 0;
        String fmt = "%d와 %d의 총합 : %d\n";// 출력양식.
        if(x>y) { min = y; max = x; }
        for(int i = min ; i <= max ; ++i) {
            sum += i;
        }
        System.out.printf(fmt,min,max,sum);

    }//모범답안



    //   메서드 정의
// 접근제한자 리턴값 메서드명(타입 매개변수명) {
// 메서드 몸체  }

    public static void main(String[] args) {
        // 인사말 출력 메서드 호출(call)
        sayHello();
        sayHello2();
        sayHello3("Hello, world!!!!");
        sayHello3("Hello, world!!!!!!!");
        sayHello3("Hello, world!!!!!!!!");
        //괄호 안에 입력값만 쓰면 변수명은 자동으로 입력되므로, 변수명은 쓰지 않도록 한다.
        String result = sayHello4("ㅁㄴㅇㄹ");
        System.out.println(result);
        //return을 적용한 메서드는 이하에 출력명령을 줘야 출력된다.

        /*int sum = computeNumAdd(6,8);
        System.out.println(sum);
        int sub = computeNumSub(12,6);
        System.out.println(sub);
        int mul = computeNumMul(6,7);
        System.out.println(mul);
        int div = computeNumDiv(16,2);
        System.out.println(div);
        int allSum = computeAllSum(1,5);
        System.out.println(allSum);*/ //나의 답.
        computeAllSum(1,5);
        computeAllSum(5,1);

    }

}