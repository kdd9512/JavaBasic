package kdd9512;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 성적처리 추상클래스를 상속해서 만든 클래스
 */

public class SungJukV10Service {

    public SungJukV10Service() {
    }

    public void displayMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------\n")
                .append("성적 처리프로그램 v9\n")
                .append("-------------------\n")
                .append("1. 성적 데이터 입력\n")
                .append("2. 성적 데이터 조회\n")
                .append("3. 성적 데이터 상세조회\n")
                .append("4. 성적 데이터 수정\n")
                .append("5. 성적 데이터 삭제\n")
                .append("0. 프로그램 종료\n")
                .append("-------------------\n")
                .append("원하시는 작업은 ? [0,1,2,3,4,5] : ");

        System.out.print(sb);

    }

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

        SungJukV0 sj = new SungJukV0(name, kor, mat, eng, 0, 0, '가');

        computeSungJuk(sj);

        // 최종적으로 처리한 성적데이터를 sungjuk테이블에 저장하기 위해
        // SungJukDAO의 insertSungJuk 메서드를 호출,
        // 매개변수로 성적데이터를 넘김.
        // DAO = data access object
        String result = SungJukV10DAO.insertSungJuk(sj);
        System.out.println(result);

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

    public void readSungJuk() {
        String fmt = "번호:%s, 이름:%s, 국어:%d, 수학:%d, 영어:%d\n";
        StringBuilder sb = new StringBuilder();

        ArrayList<SungJukV0> sjs = SungJukV10DAO.selectSungJuk();

        for (SungJukV0 sj : sjs) {
            String result = String.format(fmt, sj.getSjno(), sj.getName(), sj.getKor(),
                    sj.getMat(), sj.getEng(), sj.getRegdate().substring(0, 10)); // 0000-00-00
            sb.append(result);
        }

        System.out.println(sb.toString());
    }

    public void readOneSungJuk() {
        String fmt = "\n 번호 : %2s, 이름 : %2s\n" +
                "국어 : %2d, 수학 : %2d, 영어 : %2d\n총점 : %2d, 평균 : %.1f\n" +
                "학점 : %2c, 등록일 : %2s\n\n";

        //상세조회할 학생 이름 입력 받음.
        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 성적번호 : ");
        String sjno = sc.nextLine();

        SungJukV0 sj = SungJukV10DAO.selectOneSungJuk(sjno);
        String result = String.format(fmt, sj.getSjno(),
                sj.getName(), sj.getKor(), sj.getMat(),
                sj.getEng(), sj.getSum(), sj.getMean(),
                sj.getGrd(), sj.getRegdate());

        System.out.println(result);

    }

    public void modiftSungJuk() {
        SungJukV0 sj = new SungJukV0(); // return할 값 담을 sj

        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 성적번호 : ");
        sj.setSjno(sc.nextInt());
        System.out.print("수정할 국어성적 : ");
        sj.setKor(sc.nextInt());
        System.out.print("수정할 수학성적 : ");
        sj.setMat(sc.nextInt());
        System.out.print("수정할 영어성적 : ");
        sj.setEng(sc.nextInt()); // 입력받는거.

       computeSungJuk(sj); // 계산해서 합/평균/등급 값을 sj에

        String result = SungJukV10DAO.updateSungJuk(sj);
        System.out.println(result);
    }

    public void deleteSungJuk() {
        Scanner sc = new Scanner(System.in);

        System.out.print("삭제할 성적번호 : ");
        int sjno = sc.nextInt();

        String result = SungJukV10DAO.removeSungJuk(sjno);
        System.out.println(result);

    }
}