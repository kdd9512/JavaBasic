package kdd9512;

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
        String name = "";
        String grd = "";
        int kor = 99, eng = 98, mat = 99;
        int sum = kor+eng+mat;
        int mean = sum/3;

        if(mean<=100 && mean <=90){
            grd = "수 입니다";
        }else if(mean<=89 && mean <=80){
            grd = "우 입니다";
        }else if(mean<=79 && mean <=70){
            grd = "미 입니다";
        }else if(mean<=69 && mean <=60){
            grd = "양 입니다";
        }else if(mean<=59 && mean <=0){
            grd = "가 입니다";
        }
        System.out.printf("학생명 : %2s, 총점 : %2d, 평균 = %2d, 학점 : %2s",name,sum,mean,grd);
    }
}
