package kdd9512;

import java.util.Scanner;

/**
/* 파일명 : SungJukV3
 * 작성일 : 2020.11.17
 *
 * 프로그램설명 : 성적처리 프로그램 v3.
 * 학생 3명의 데이터를 이용.
 * 100점 만점. 100~90, 89~80, 79~70, 69~60, 59~0 기준으로 학점 부여.
 * 학점기준 : 수,우,미,양,가.
 * switch문으로 학점을 계산하도록 함.
 * 변수명 : name, kor, eng, mat, sum, mean, grd.
 *         이름, 국어, 영어, 수학, 총점, 평균, 등급.
 * 단, 이하의 조건을 만족시켜야 한다.
 *     1. 성적처리 결과 출력시, 출력문을 단 하나만 사용할 것.
 *     2. Math.round()를 이용하여 소수점 둘째 자리까지 값을 반올림 할 것.
 */
public class SungJukV3 {
    public static void main(String[] args) {
        // 배열변수선언
        // 자료형 변수명[] = new 자료형 [크기];
        String[] name = new String[3];
        int[] kor = new int[3];
        int[] mat = new int[3];
        int[] eng = new int[3];
        int[] sum = new int[3];
        double[] mean = new double[3];
        char[] grd = new char[3];

        String fmt = "이름 : %2s\n국어 : %2d\n수학 : %2d\n영어 : %2d\n총점 : %2d\n평균 : %.2f\n학점 : %2c\n";

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; ++i) {
            System.out.println((i + 1) + "번째 학생 성적 입력중....");

            System.out.print("이름 : ");
            name[i] = sc.nextLine();
            System.out.print("국어성적 : ");
            kor[i] = Integer.parseInt(sc.nextLine());//숫자를 문자로 변환.
            //kor[i] = sc.nextInt();
            System.out.print("수학성적 : ");
            mat[i] = sc.nextInt();
            System.out.print("영어성적 : ");
            eng[i] = sc.nextInt();
            //sc.skip("\r\n|[\n\r]");

            //현재 2번째 학생부터 이름을 입력할 수 없게 되어 있는데,
            //영어성적 입력시, 같이 입력된 enter키가
            //다음 데이터(이름) 입력시, 입력값으로 자동전달되어 생기는 문제임.

            //1. 영어성적 받는 scan 다음에 스캐너 변수명(여기선 sc).skip("\r\n|[\n\r]"); 을 입력한다.
            //   이 명령어로 띄어쓰기(엔터)를 스킵한다. 이게 더 좋음.

            //2. 국어성적을 String으로 받는다.
            //   입력받을땐 숫자로 받되 이 값을 변환한다. Integer.parseInt(sc.nextLine()); 로 변환.
            //   이 경우, 맨 아래 sc.skip("\r\n|[\n\r]"); 이 필요없음.

        }

        for (int i = 0; i <3; ++i) {
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
        // 결과값 출력
        for (int i = 0; i <3; ++i) {
            System.out.printf(fmt, name[i], kor[i], mat[i], eng[i], sum[i], mean[i], grd[i]);
        }
    }
}
