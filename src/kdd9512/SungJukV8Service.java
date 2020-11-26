package kdd9512;

import javax.xml.soap.SOAPConnectionFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * 성적처리 추상클래스를 상속해서 만든 클래스
 */

public class SungJukV8Service extends SungJukV8GenericService {

    //멤버변수 선언
    //입력받은 모든 성적데이터를 저장하는 동적배열 변수
    List<SungJukV0> sjdata = new ArrayList<>();

    @Override
    /**
     * 이름과 성적데이터를 입력받아
     * 총점,평균,학점을 계산한 뒤,
     * 동적배열에 추가.
     */
    public void newSungJuk() {
        String name;
        int kor, eng, mat; // 변수들 초기화
        Scanner sc = new Scanner(System.in);

        System.out.print("이름 : ");
        name = sc.nextLine();
        System.out.print("국어성적 : ");
        kor = sc.nextInt();
        System.out.print("수학성적 : ");
        mat = sc.nextInt();
        System.out.print("영어성적 : ");
        eng = sc.nextInt();

        //입력받은 성적데이터를 동적배열에 저장(저장한 값은 V0에서 제시한대로 처리), 객체화.
        SungJukV0 sj =
                new SungJukV0(name, kor, eng, mat, 0, 0, ' ');
        //모든 항목에 대해 값을 입력해야 에러가 안뜸. 일단 공값

        // 총점,평균,학점을 계산. 이 객체를 일단 V0으로 가지고 감.
        // V0에 생성자가 있으므로 입력한 값을 V0에 준비된 대로 집어넣음.
        // 그 값은 동적배열이 될 것이고 그 동적배열이 객체 sj가 되는 것.
        computeSungJuk(sj);

        //처리된 성적데이터를 동적배열에 저장.
        sjdata.add(sj);

    }

    @Override
    /**
     * 저장된 성적데이터들 중,
     * 번호, 이름, 국, 영, 수 만 뽑아서
     * 리스트형태로 출력.
     */
    public void readSungJuk() {
        String fmt =
                "이름 : %2s, 국어 : %2d, 수학 : %2d, 영어 : %2d\n";

        //동적배열로 저장된 데이터들을 출력
        //각 요소를 순회할 수 있도록 Iterator 선언.
        Iterator<SungJukV0> iter = sjdata.iterator();// 동적배열을 이터레이터 iter로 선언.

        while (iter.hasNext()) {//다음 데이터가 없을 때 까지 계속 넣음. boolean (T/F) 으로 표기함
            // (있으면 true값이 되어 가져오고 없으면 false가 되어 종료)
            SungJukV0 sj = iter.next();//iterator 내의 값을 순회하여 가져옴.

            System.out.printf(fmt, sj.getName(), sj.getKor(), sj.getMat(), sj.getEng());
        }


    }

    @Override
    /**
     * 상세조회할 학생 이름을 입력받아
     * 이름, 국어, 수학, 영어, 총점, 평균, 학점 을 출력.
     */
    public void readOneSungJuk() {
        String fmt = "\n이름 : %2s\n국어 : %2d, 수학 : %2d, 영어 : %2d\n총점 : %2d, 평균 : %.1f\n학점 : %2c\n\n";

        //상세조회할 학생 이름 입력 받음.
        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 학생의 이름 : ");
        String name = sc.nextLine();

        //이름으로 데이터 검색 후 결과출력.
        for (SungJukV0 sj : sjdata) {// 향상for문. 변수 sj : 배열명 sjdata(성적입력으로 받은 값을 저장중)
            if (sj.getName().equals(name))  //getName에 입력된 값과 입력받은 값 name을
                                             // .equals()함수로 비교함.
                System.out.printf(fmt, sj.getName(), sj.getKor(), sj.getMat(),
                        sj.getEng(), sj.getSum(), sj.getMean(), sj.getGrd());
            break;// 출력 완료했으므로 돌아갈 이유가 없으니 여기서 짜른다. 짜른 뒤 다시 메뉴로 돌아감.
        }


    }

    @Override
    public void removeSungJuk() {
        super.removeSungJuk();
    }

    @Override
    public void modifySungJuk() {
        super.modifySungJuk();
    }

    /**
     * 성적 처리 프로그램의 메뉴 출력 기능
     */

    public void displayMenu() {
        StringBuilder sb = new StringBuilder();//화면 디자인 작성.
        sb.append("-------------------\n")
                .append("성적 처리프로그램 v8\n")
                .append("-------------------\n")
                .append("1. 성적 데이터 입력\n")
                .append("2. 성적 데이터 조회\n")
                .append("3. 성적 데이터 상세조회\n")
                .append("4. 성적 데이터 수정\n")
                .append("5. 성적 데이터 삭제\n")
                .append("0. 프로그램 종료\n")
                .append("-------------------\n")
                .append("원하시는 작업은 ? [0,1,2,3,4,5] : ");
        //StringBuilder를 이용하여 화면디자인.
        //이 형태를 기억해야 한다.
        System.out.print(sb);
        //출력은 sb만 하면 끝.
    }


    public void computeSungJuk(SungJukV0 sj) {
        // 위에서 마련한 객체 sj 를 가지고 이하의 메서드 실행.
        // 여기서 소괄호 안에 그냥 sj만 쓰면 안되고, 생성자가 어디 있는지도 같이 입력해줘야 함.
        sj.setSum(sj.getKor() + sj.getMat() + sj.getEng());
        sj.setMean((double) sj.getSum() / 3);
        switch ((int) (sj.getMean() / 10)) {
            case 10:
            case 9:
                sj.setGrd('수');
                break;
            case 8:
                sj.setGrd('우');
                break;
            case 7:
                sj.setGrd('미');
                break;
            case 6:
                sj.setGrd('양');
                break;
            default:
                sj.setGrd('가');
                break;

        }
    }


}