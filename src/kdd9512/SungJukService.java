package kdd9512;

import java.util.Scanner;

/** 파일명 : SungJukV2b
 * 작성일 : 2020.11.20
 *
 * 프로그램설명 : 성적처리 프로그램 v5.
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
public class SungJukService {
        /*
        * 성적 데이터 스캐너 입력 메서드.
        * @return 키보드로 입력받은 성적데이터 SungJukVO
        * */
    public SungJukV0 readSungJuk(){//return 하려는 요소가 class타입이므로 public 다음에 class명을 써넣어준다
        //변수 값 종류 선언.
        String name;
        int kor,mat,eng;

        Scanner scan = new Scanner(System.in);

        System.out.print("이름 : ");
        name = scan.nextLine();
        System.out.print("국어성적 : ");
        kor = scan.nextInt();
        System.out.print("수학성적 : ");
        mat = scan.nextInt();
        System.out.print("영어성적 : ");
        eng = scan.nextInt();

        return new SungJukV0(name,kor,eng,mat,0,0,' ');
        // 입력된 값을 받아야 하므로 각각의 변수명을 알맞게 기입하고, sum, mean, grd는
        // 여기서 구하는 것이 아니니 이하의 공식을 적용하게끔 초기화만 시켜둔다.

    }//readSungJuk

    /*
     * 입력받은 성적에 대해
     * 총점, 평균, 학점을 계산하는 메서드
     */
    public void computeSungJuk(SungJukV0 sj) {
        sj.setSum ( sj.getKor() + sj.getMat() + sj.getEng());
        sj.setMean ((double)sj.getSum() / 3);
        //입력받은 값으로 sum, mean 처리.
        //주의점 : 기존 변수의 이름을 setXxx 혹은 getXxx형식으로 바꿔준다.
        switch ((int) (sj.getMean() / 10)) { //수식 쓰는 방식을 알아둘 것. switch ((변환값)(수식)){}
            case 10:
            case 9:
                sj.setGrd ('수');
                break;
            //case 10에 대한 설정이 없으면 default값인 '가'로 나온다.
            case 8:
                sj.setGrd ('우');//기존 SungJukV2의 grd switch문을 바꾼 것. 기존 grd를 값을 담는 setGrd()로
                                    //변환해야 하므로 grd = '수' 는, sj.setGrd('값') 의 형태가 된다.
                break;
            case 7:
                sj.setGrd ('미');
                break;
            case 6:
                sj.setGrd ('양');
                break;
            default:
                sj.setGrd ('가');
                break;

        }//switch
    }//computeSungJuk
    /**
     * 입력한 이름, 국어, 영어, 수학과
     * 계산된 총점, 평균, 학점 등을 출력하는 메서드
     */
    String fmt = "이름 : %2s\n국어 : %2d\n수학 : %2d\n영어 : %2d\n총점 : %2d\n평균 : %s\n학점 : %2c\n";
    String result;
    public void printSungJuk(SungJukV0 sj){//출력할 성적값이 든 sj 를 괄호안에 입력한다
        result = String.format(fmt, sj.getName(), sj.getKor(), sj.getMat(), sj.getEng(),
                sj.getSum(),sj.getMean(),sj.getGrd());
        //역시 생성자 sj의 값을 끌어와야 하므로 기존의 변수값을 전부 sj.getXxx 형식으로 전부 수정한다.
        System.out.println(result);

    }//printSungJuk 끝
}
