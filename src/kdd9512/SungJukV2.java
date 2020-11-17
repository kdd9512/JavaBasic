package kdd9512;

import java.util.Scanner;

/**
/* 파일명 : SungJukV2
 * 작성일 : 2020.11.17
 *
 * 프로그램설명 : 성적처리 프로그램 v1.
 * 이름, 국어, 영어, 수학점수를 설정하면,
 * 총점, 평균, 학점을 계산, 결과를 출력.
 *
 * 100점 만점. 100~90, 89~80, 79~70, 69~60, 59~0 기준으로 학점 부여.
 * 학점기준 : 수,우,미,양,가.
 * switch문으로 학점을 계산하도록 함.
 * name, kor, eng, mat, sum, mean, grd.
 * 이름, 국어, 영어, 수학, 총점, 평균, 등급.
 *
 *
 */
public class SungJukV2 {
    public static void main(String[] args) {
        String name = "";
        int kor, eng, mat;
        int sum = 0;
        double mean = 0.0;
        char grd = ' ';
        grd = ' ';
        //변수선언

        //처리
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
        mean = Double.parseDouble(String.format("%.2f",mean));
        //2. double값으로 변환하기 위해서는 Double.parseDouble(String.format(형식지정자, 변수들));
        //   이렇게 하면 아예 처음부터 mean값이 변환되어서 들어가므로 밑에서 출력명령을 하나하나 고치지 않아도 된다.

        // 값 출력
        System.out.println("이름 = " + name);
        System.out.println("국어 = " + kor);
        System.out.println("수학 = " + mat);
        System.out.println("영어 = " + eng);
        System.out.println("-------------");
        System.out.println("총점 = " + sum);
        //System.out.println("평균 = "+ mean);
        //System.out.printf("\n평균 = %.2f\n ",mean); // 1. printf 로 출력방식을 조정하여 소수점을 자르게 한다.
        System.out.println("평균 = "+ mean);
        System.out.println("학점 = " + grd);

    }
}
