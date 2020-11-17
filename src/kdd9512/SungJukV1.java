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
 */
public class SungJukV1 {
    public static void main(String[] args) {
        String name = "지현";
        int kor = 99, eng = 98, mat = 99;
        int sum = 0;
        double mean = 0.0;
        char grd =  '가';

        sum = kor+mat+eng;
        mean = sum/3;

        Scanner scan = new Scanner(System.in);

        System.out.println("이름 = " + name);
        System.out.println("국어 = " + kor);
        System.out.println("수학 = " + mat);
        System.out.println("영어 = " + eng);
        System.out.println("-------------");
        System.out.println("총점 = " + sum);
        System.out.println("평균 = " + mean);
        System.out.println("등급 = " + grd);
        /*if(mean<=100 && mean <=90){
            System.out.println("수");
        }else if(mean<=89 && mean <=80){
            System.out.println("우");
        }else if(mean<=79 && mean <=70){
            System.out.println("미");
        }else if(mean<=69 && mean <=60){
            System.out.println("양");
        }else if(mean<=59 && mean <=0){
            System.out.println("가");

        }*/
    }
}
