package kdd9512;

import java.util.Scanner;

/**
 * 파일명 SungJukV6Main
 * 작성일 20201123
 * <p>
 * 프로그램 설명 : 성적처리 프로그램 V6
 * 중간고사와 기말고사 성적처리 프로그램을 만들려고 함
 * SungJukV1 토대로 중간고사 성적과 기말고사 성적 클래스를
 * 상속을 이용하여 작성하시오
 * <p>
 * 중간고사MidSungJuk : 국어kor, 영어eng, 수학mat
 * 기말고사FinalSungJuk : 국어 영어 수학, 미술art, 과학sci
 * 성적처리 : computeSungJuk
 * 결과출력 : printSungJuk
 */

public class SungJukV6Main {
    public static void main(String[] args) {
        MidSungJuk msj = new MidSungJuk();

        msj.readSungJuk();
        msj.computeSungJuk();
        msj.printSungJuk();

        FinalSungJuk fsj = new FinalSungJuk();
        fsj.readSungJuk();
        fsj.computeSungJuk();
        fsj.printSungJuk();

    }
}// 메인함수는 별개이므로 여기서 잘라준다.

    class MidSungJuk { //여기서부터가 시작. 중간고사 성적을 입력해야 하므로 새 클래스 MidSungJuk 을 새로생성.
        protected String name;
        protected int kor, eng, mat;
        protected int sum;
        protected double mean;
        protected char grd;
        protected MidSungJuk() {
        }

        public MidSungJuk(String name, int kor, int eng, int mat, int sum, double mean, char grd) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.mat = mat;
            this.sum = sum;
            this.mean = mean;
            this.grd = grd;
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
            String fmt = "이름 : %2s\n국어 : %2d\n수학 : %2d\n영어 : %2d\n총점 : %2d\n평균 : %.2f\n학점 : %2c\n";
            String result = String.format(fmt, name, kor, mat, eng, sum, mean, grd);
            System.out.println(result);
        }

    }
    class FinalSungJuk extends MidSungJuk {
        int art,sci;

        public FinalSungJuk() {//기본클래스
        }

        public FinalSungJuk(String name, int kor, int eng, int mat, int sum, double mean, char grd, int art, int sci) {
            super(name, kor, eng, mat, sum, mean, grd);
            this.art = art;
            this.sci = sci;
        }

        @Override // CTRL + SPACE 후 메서드 검색.
        protected void readSungJuk() {
            super.readSungJuk();
            Scanner sc = new Scanner(System.in);
            System.out.print("미술성적 : ");
            art= sc.nextInt();
            System.out.print("과학성적 : ");
            sci = sc.nextInt();
        }

        @Override // CTRL + SPACE 후 메서드 검색.
        protected void computeSungJuk() {//변수가 추가되었으므로 그에 맞게 평균을 구하는 공식을 수정해야 한다.
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

        @Override // CTRL + SPACE 후 메서드 검색.
        protected void printSungJuk() {
            System.out.printf("\n========기말 성적========\n");
            String fmt = "이름 : %2s\n국어 : %2d\n수학 : %2d\n영어 : %2d\n미술 : %2d\n과학 : %2d\n총점 : %2d\n평균 : %.2f\n학점 : %2c\n";
            String result = String.format(fmt, name, kor, mat, eng, art, sci, sum, mean, grd);
            System.out.println(result);
        }
    }





