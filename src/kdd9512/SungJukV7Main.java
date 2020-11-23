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
 * 부모 클래스 : SungJukV7
 * 인터페이스 : ISungJukV7
 * 중간고사 MidSungJuk2 : 국어kor, 영어eng, 수학mat
 * 기말고사 FinalSungJuk2 : 국어 영어 수학, 미술art, 과학sci
 * 성적입력 : readSungJuk
 * 성적처리 : computeSungJuk
 * 결과출력 : printSungJuk
 */
public class SungJukV7Main{
    public static void main(String[] args) {
        MidSungJuk2 msj2 = new MidSungJuk2();
        msj2.readSungJuk();
        msj2.computeSungJuk();
        msj2.printSungJuk(); //중간

        FinalSungJukV7 fsj2 = new FinalSungJukV7();
        fsj2.readSungJuk();
        fsj2.computeSungJuk();
        fsj2.printSungJuk(); //기말
    }
}
abstract class SungJukV7 {
    protected String name;
    protected int kor, eng, mat;
    protected int sum;
    protected double mean;
    protected char grd;

    public SungJukV7() { }

    public SungJukV7(String name, int kor, int eng, int mat) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;

    }//입력받아야 하는 값은 이름,국,영,수.

    //protected 이므로 setter/getter 설정한다.
    public void setName(String name) {
        this.name = name;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    public String getName() {
        return name;
    }

    public int getKor() {
        return kor;
    }

    public int getEng() {
        return eng;
    }

    public int getMat() {
        return mat;
    }

}

interface ISungJukV7{//인터페이스
    void readSungJuk();
    void computeSungJuk();
    void printSungJuk();
}

class MidSungJuk2 extends SungJukV7 implements ISungJukV7 {
    @Override
    public void readSungJuk() {
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
    @Override
    public void computeSungJuk() {

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

    @Override
    public void printSungJuk() {
        System.out.printf("\n========중간 성적========\n");
        String fmt = "이름 : %2s\n국어 : %2d\n수학 : %2d\n영어 : %2d\n총점 : %2d\n평균 : %.2f\n학점 : %2c\n";
        String result = String.format(fmt, name, kor, mat, eng, sum, mean, grd);
        System.out.println(result);
    }

}

class FinalSungJukV7 extends SungJukV7 implements ISungJukV7 {
    protected int art, sci;

    public FinalSungJukV7() { }

    public FinalSungJukV7(String name, int kor, int eng, int mat,int art, int sci) {
        this.art = art;
        this.sci = sci;
    }

    @Override
    public void readSungJuk() {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름 : ");
        name = sc.nextLine();
        System.out.print("국어성적 : ");
        kor = sc.nextInt();
        System.out.print("수학성적 : ");
        mat = sc.nextInt();
        System.out.print("영어성적 : ");
        eng = sc.nextInt();
        System.out.print("미술성적 : ");
        art= sc.nextInt();
        System.out.print("과학성적 : ");
        sci = sc.nextInt();
        //인터페이스로 양식은 공유한다지만, 값은 받아야 하므로 그냥 기존중간성적 입력에 미술, 과학을 추가한 형태를 써준다.
    }

    @Override
    public void computeSungJuk() {
        sum = kor + mat + eng + art + sci;
        mean = (double) sum / 5;
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

    @Override
    public void printSungJuk() {
        System.out.printf("\n========기말 성적========\n");
        String fmt = "이름 : %2s\n국어 : %2d\n수학 : %2d\n영어 : %2d\n미술 : %2d\n과학 : %2d\n총점 : %2d\n평균 : %.2f\n학점 : %2c\n";
        String result = String.format(fmt, name, kor, mat, eng, art, sci, sum, mean, grd);
        System.out.println(result);

    }
}



