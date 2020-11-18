package kdd9512;

import java.util.Scanner;

/**
 * /* 파일명 : SungJukV4
 * 작성일 : 2020.11.18
 * <p>
 * 프로그램설명 : 성적처리 프로그램 v4.
 * 학생 3명의 데이터를 이용.
 * 100점 만점. 100~90, 89~80, 79~70, 69~60, 59~0 기준으로 학점 부여.
 * 학점기준 : 수,우,미,양,가.
 * switch문으로 학점을 계산하도록 함.
 * 변수명 : name, kor, eng, mat, sum, mean, grd.
 * 이름, 국어, 영어, 수학, 총점, 평균, 등급.
 * 단, 이하의 조건을 만족시켜야 한다.
 * 1. 성적처리 결과 출력시, 출력문을 단 하나만 사용할 것.
 * 2. Math.round()를 이용하여 소수점 첫째 자리까지 값을 반올림 할 것.
 *
 * 코드의 가독성과 유지보수를 용이하게 하기 위해
 * 메서드 기반 코드로 재작성.
 * <p>
 *
 * 성적처리 기능을 구현.
 * 코드가 길어지고 내용파악이 어려워 지는 것을 방지하기 위해
 * 함수(메서드)로 재정의하여 코드를 개선.
 */
public class SungJukV4 {

    public static void main(String[] args) {
        String[] name = new String[3];
        int[] kor = new int[3];
        int[] mat = new int[3];
        int[] eng = new int[3];
        int[] sum = new int[3];
        double[] mean = new double[3];
        char[] grd = new char[3];

        //변수유형 변수명[] C언어식 배열선언
        //변수유형[] 변수명 JAVA식 배열선언
        //어느쪽을 쓰던 배열 선언은 가능하므로 사실상 차이는 없음.
        //color 랑 colour의 차이같은 느낌.

        //처리
        readSungJuk(name, kor, mat, eng);
        computeSungJuk(kor, mat, eng, sum, mean, grd);

        // 결과 출력 printSungJuk
        printSungJuk(name, kor, mat, eng, sum, mean, grd);


    }
        //성적데이터 입력받기 readSungJuk
        public static void readSungJuk(String[] name,int[] kor, int[] mat, int[] eng) {
            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < 3; ++i) {
                System.out.println((i + 1) + "번째 학생 성적 입력중....");

                System.out.print("이름 : ");
                name[i] = sc.nextLine();
                System.out.print("국어성적 : ");
                kor[i] = sc.nextInt();
                System.out.print("수학성적 : ");
                mat[i] = sc.nextInt();
                System.out.print("영어성적 : ");
                eng[i] = sc.nextInt();
                sc.skip("\r\n|[\n\r]");

            }
        }

        //성적데이터 총점, 평균, 학점 처리 computeSungJuk
        public static void computeSungJuk(int[] kor, int[] mat, int[] eng, int[] sum, double[] mean,char[] grd) {
            for (int i = 0; i < 3; ++i) {
                sum[i] = kor[i] + mat[i] + eng[i];
                mean[i] = (double) sum[i] / 3;
                switch ((int) (mean[i] / 10)) {
                    case 10:
                    case 9:
                        grd[i] = '수';
                        break;
                    case 8:
                        grd[i] = '우';
                        break;
                    case 7:
                        grd[i] = '미';
                        break;
                    case 6:
                        grd[i] = '양';
                        break;
                    default:
                        grd[i] = '가';
                        break;
                }
            }
        }
    public static void printSungJuk(String[] name, int[] kor, int[] mat, int[] eng, int[] sum, double[] mean,char[] grd){
        String fmt = "이름 : %2s\n국어 : %2d\n수학 : %2d\n영어 : %2d\n총점 : %2d\n평균 : %.2f\n학점 : %2c\n";
        for (int i = 0; i <3; ++i) {
                System.out.printf(fmt, name[i], kor[i], mat[i], eng[i], sum[i], mean[i], grd[i]);
            }

    }


}//class
