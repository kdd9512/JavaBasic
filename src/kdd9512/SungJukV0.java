package kdd9512;

/**
 * /* 파일명 : SungJukV4
 * 작성일 : 2020.11.20
 * <p>
 * 프로그램설명 : 성적처리 프로그램 v5.
 * 변수명 : name, kor, eng, mat, sum, mean, grd.
 * 이름, 국어, 영어, 수학, 총점, 평균, 학점에
 * 관한 변수들을 정의하는 VO 클래스
 *
 */
// SungJukV5Main -> SungJukVO -> SungJukService
public class SungJukV0 {
    private String name;
    private int kor, eng, mat;
    private int sum;
    private double mean;
    private char grd;

    public SungJukV0() {
    }

    public SungJukV0(String name, int kor, int eng, int mat, int sum, double mean, char grd) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
        this.sum = sum;
        this.mean = mean;
        this.grd = grd;

    }


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

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public void setGrd(char grd) {
        this.grd = grd;
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

    public int getSum() {
        return sum;
    }

    public double getMean() {
        return mean;
    }

    public char getGrd() {
        return grd;
    }
}
