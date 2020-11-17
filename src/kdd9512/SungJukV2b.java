package kdd9512;

import java.util.Scanner;

/**
/* 파일명 : SungJukV2b
 * 작성일 : 2020.11.17
 *
 * 프로그램설명 : 성적처리 프로그램 v1.
 * 이름, 국어, 영어, 수학점수를 설정하면,
 * 총점, 평균, 학점을 계산, 결과를 출력.
 *
 * 100점 만점. 100~90, 89~80, 79~70, 69~60, 59~0 기준으로 학점 부여.
 * 학점기준 : 수,우,미,양,가.
 * switch문으로 학점을 계산하도록 함.
 * 변수명 : name, kor, eng, mat, sum, mean, grd.
 *         이름, 국어, 영어, 수학, 총점, 평균, 등급.
 * 단, 이하의 조건을 만족시켜야 한다.
 *     1. 성적처리 결과 출력시, 출력문을 단 하나만 사용할 것.
 *     2. Math.round()를 이용하여 소수점 둘째 자리까지 값을 반올림 할 것.
 */
public class SungJukV2b {
    public static void main(String[] args) {
        String name = "";
        int kor, eng, mat;
        int sum = 0;
        double mean = 0.0;
        char grd = ' ';
        grd = ' ';
        //변수선언
        String fmt = "이름 : %2s\n국어 : %2d\n수학 : %2d\n영어 : %2d\n총점 : %2d\n평균 : %s\n학점 : %2c\n";
        String result;
        //String.format을 이용하여 출력명령을 단 한번만 하기 위함.
        //fmt는 출력양식을 품는 역할이고 들어갈 값을 담기 위해 우선 쓰레기값을 품은 result라는 이름의 String을 선언한다.



        //성적데이터를 키보드로 입력받기 위해
        //Scanner 클래스 초기화. 한글쓰려면 입력을 받는게 조금 느림.
        Scanner scan = new Scanner(System.in);
        System.out.print("이름 : ");//print로 줄바꿈 없이 바로 옆에 값을 입력가능함.
        name = scan.nextLine();
        System.out.print("국어성적 : ");
        kor = scan.nextInt();
        System.out.print("수학성적 : ");
        mat = scan.nextInt();
        System.out.print("영어성적 : ");
        eng = scan.nextInt();
        //scan 설정 끝.

        sum = kor+mat+eng;
        mean = (double)sum/3;
        //입력받은 값으로 sum, mean 처리.

        switch((int)(mean/10)){ //수식 쓰는 방식을 알아둘 것. switch ((변환값)(수식)){}
            case 10 : case 9 : grd = '수'; break;
            //case 10에 대한 설정이 없으면 default값인 '가'로 나온다.
            case 8 : grd = '우'; break;
            case 7 : grd = '미'; break;
            case 6 : grd = '양'; break;
            default : grd = '가'; break;
            //학점계산은 switch 이용이 조건.
            // switch 문으로 grd처리. 줄 정리에도 주목.
        }
        //String.format(형식지정자, 변수들)
        mean = Math.round((float)(mean*100))/100.0f;
        //1. Math.round() 를 이용하여 반올림한다. 소수점을 둘째 자리까지만 인쇄하기 위해선, mean값에 먼저 100을 곱하여
        //   XX.XXX어쩌고의 값이 XXXX.X으로 변환됨과 동시에 반올림 처리가 되며, 그 값을 다시 100으로 나누어 실수로 재변환
        //   한다. 이런 식으로 소수점 둘째짜리 반올림을 만들 수 있다.
        //   (자리수가 하나 늘어날 때마다 곱하고 나누는 값은 10배 증가)
        //
        //2. double값으로 변환하기 위해서는 Double.parseDouble(String.format(형식지정자, 변수들));
        //   이렇게 하면 아예 처음부터 mean값이 변환되어서 들어가므로 밑에서 출력명령을 하나하나 고치지 않아도 된다.

        result = String.format(fmt, name, kor, mat, eng, sum, String.valueOf(mean), grd);
        // result 에는 fmt와 fmt가 품은 양식에 들어갈 값들을 순서대로 담는다.
        // 맨 왼쪽에 양식을 품은 fmt를 입력하고 그 다음부터 입력한 값이 fmt의 양식에 따라 왼쪽부터 순서대로 출력된다.
        // String.valueOf(값) = 숫자를 문자로 변환.
        // 이 문구가 추가되면 mean은 값 출력을 위한 fmt내에서의 양식에 %s를 붙혀 문자열로 출력해야 함.

        // Solid - 단일 책임의 원칙. 하나의 코드는 단 하나의 기능만 가져야 한다.

        // 값 출력
        System.out.println(result);
        //모든 양식이 이미 String.format(); 으로 다 정리가 되어 있는 값 result 만 출력하면 끝.
//        System.out.println("이름 = " + name);
//        System.out.println("국어 = " + kor);
//        System.out.println("수학 = " + mat);
//        System.out.println("영어 = " + eng);
//        System.out.println("-------------");
//        System.out.println("총점 = " + sum);
//        //System.out.println("평균 = "+ mean);
//        //System.out.printf("\n평균 = %.2f\n ",mean); // 1. printf 로 출력방식을 조정하여 소수점을 자르게 한다.
//        System.out.println("평균 = "+ mean);
//        System.out.println("학점 = " + grd);
        /*System.out.printf
                ("이름 = %2s\n국어 = %2d\n수학 = %2d\n영어 = %2d\n-------------\n총점 = %2d\n평균 = %.2f\n학점 = %c\n",
                name,kor,mat,eng,sum,mean,grd);*/
        // 위에 주석처리된 println문과 출력결과가 같다.
        // %d는 정수출력, %f는 실수출력, %.?f는 ?에 원하는 소수점 자리를 넣어 실수 소수점
        // 조절, %s는 문자열, %c는 문자출력.
        /*System.out.println("이름 = " + name + "\n" +
                            "국어 = " + kor + "\n" +
                            "수학 = " + mat + "\n" +
                            "영어 = " + eng + "\n" +
                            "총점 = " + sum + "\n" +
                            "평균 = " + mean + "\n" +
                            "학점 = " + grd);
*/
        //이처럼 가능은 한데, ""안에 넣어서 출력명령을 실행하게 되면 필연적으로 String 참조값을 많이 만들게 되기 때문에 자원효율이
        // 매우 떨어진다는 단점이 있다.



    }
}
