package kdd9512;

import java.util.Scanner;

/**
/* 파일명 : SungJukV1
 * 작성일 : 2020.11.17
 *
 * 프로그램설명 : 성적처리 프로그램 v1.
 * 이름, 국어, 영어, 수학점수를 설정하면,
 * 총점, 평균, 학점을 계산, 결과를 출력.
 * 100점 만점. 100~90, 89~80, 79~70, 69~60, 59~0 기준으로 학점 부여.
 * 학점기준 : 수,우,미,양,가.
 * name, kor, eng, mat, sum, mean, grd.
 * 이름, 국어, 영어, 수학, 총점, 평균, 등급.
 *
 * 삼항연산자 :
 * (조건식)? 참일때 처리 : 거짓일 때 처리
 */
public class SungJukV1 {
    public static void main(String[] args) {
        String name = "";
        int kor, eng, mat;
        int sum = 0;
        double mean = 0.0;
        char grd = ' ';
        //변수선언


        Scanner scan = new Scanner(System.in);
        System.out.println("이름");
        name = scan.nextLine();
        System.out.println("국어성적");
        kor = scan.nextInt();
        System.out.println("수학성적");
        mat = scan.nextInt();
        System.out.println("영어성적");
        eng = scan.nextInt();

        sum = kor+mat+eng;
        mean = (double)sum/3;
        grd = (mean >= 90)? '수' : (mean >= 80)? '우' :
                (mean >= 70)? '미' : (mean >= 60)? '양' : '가' ;

        System.out.println("이름 = " + name);
        System.out.println("국어 = " + kor);
        System.out.println("수학 = " + mat);
        System.out.println("영어 = " + eng);
        System.out.println("-------------");
        System.out.println("총점 = " + sum);
        System.out.println("평균 = " + mean);
        System.out.println("학점 = " + grd);

    }
}
