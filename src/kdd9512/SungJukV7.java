package kdd9512;

import java.util.Scanner;

/**
 * 파일명 SungJukV7Main
 * 작성일 20201123
 * <p>
 * 프로그램 설명 : 성적처리 프로그램 V7
 * 중간고사와 기말고사 성적처리 프로그램을 만들려고 함
 * SungJukV6 토대로 중간고사 성적과 기말고사 성적 클래스를
 * interface 를 이용하여 작성.
 * <p>
 * 부모 클래스 : SungJukV6
 * 인터페이스 : ISungJukV6
 * 중간고사 MidSungJuk2 : 국어kor, 영어eng, 수학mat
 * 기말고사 FinalSungJuk2 : 국어 영어 수학, 미술art, 과학sci
 * 성적입력 : readSungJuk
 * 성적처리 : computeSungJuk
 * 결과출력 : printSungJuk
 */
public class SungJukV7 {
    public static void main(String[] args) {
        MidSungJuk2 msj2 = new MidSungJuk2();

        msj2.computeSungJuk();
        msj2.readSungJuk();
        msj2.printSungJuk();
    // 중간까지는 되는데....

    }

}
class SungJukV6 {
    protected String name;
    protected int kor, eng, mat;
    protected int sum;
    protected double mean;
    protected char grd;
}

interface ISungJukV6 {
    String fmt();

}

class MidSungJuk2 extends SungJukV6 implements ISungJukV6 {
    //위에 빈껍데기 fmt 인터페이스 생성. 이하에서 return 으로 fmt 내부 구조를 작성.
    @Override
    public String fmt() {
        return "이름 : %2s\n국어 : %2d\n수학 : %2d\n영어 : %2d\n총점 : %2d\n평균 : %.2f\n학점 : %2c\n";
    }

    protected void readSungJuk() {
        Scanner sc = new Scanner(System.in);

        System.out.print("이름 : ");
        name = sc.nextLine();
        System.out.print("국어성적 : ");
        kor = sc.nextInt();
        System.out.print("수학성적 : ");
        mat = sc.nextInt();
        System.out.print("영어성적 : ");
        eng = sc.nextInt();


    }

    protected void computeSungJuk() {

        sum = kor + mat + eng;
        mean = (double) sum / 3;
        switch ((int) (mean / 10)) {
            case 10:
            case 9:
                grd = '수';
                break;
            case 8:
                grd = '우';
                break;
            case 7:
                grd = '미';
                break;
            case 6:
                grd = '양';
                break;
            default:
                grd = '가';
                break;

        }
    }

    protected void printSungJuk() {
        System.out.printf("\n========중간 성적========\n");
        String result = String.format(fmt(), name, kor, mat, eng, sum, mean, grd);
        System.out.println(result);
    }

}



