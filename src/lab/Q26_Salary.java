package lab;

import java.util.Scanner;

/**
 * 26. 사용자가 연봉과 결혼 여부를 입력하면 다음의 세금율에 의해 납부해야
 * 할 세금을 계산하는 프로그램을 작성하세요 (Tax)
 *
 * 가. 미혼인 경우 : 연봉 3000미만 - 10%,  연봉 3000이상 - 25%
 * 나. 결혼한 경우 : 연봉 6000미만 - 15%,  연봉 6000이상 - 35%
 */

public class Q26_Salary {
    public static void main(String[] args) {
        int i = 0;
        int sal = 0;
        int tax = 0;
        String mar = "";

        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("결혼하셨습니까? YES : 1, NO : 0");
            i = sc.nextInt();
            if (i > 1 || i < 0) {
                System.out.println("1 또는 0만 입력하시오");
                continue;
            }

            System.out.println("연봉을 입력하세요");
            sal = sc.nextInt();

            if (sal < 3000 && i == 0) {
                tax = sal + (sal / 10);

            } else if (sal > 3000 && i == 0) {
                tax = sal + (sal / 25);
            } else if (sal < 6000 && i == 1) {
                tax = sal + (sal / 15);
            } else if (sal > 6000 && i == 1) {
                tax = sal + (sal / 35);
            }

            switch (i) {
                case 1:
                    mar = "기혼";
                    break;
                default:
                    mar = "미혼";
                    break;
            }

            System.out.printf("납부세금 : %2d 원, 혼인여부 %2s\n",tax,mar);
            break;
        }

    }

}
