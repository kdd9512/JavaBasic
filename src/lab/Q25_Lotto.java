package lab;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 가. 사용자로부터 복권 숫자 3자리를 입력 받으세요 (yourkey) : ex) 275
 * 나. 변수에 임의의 복권 숫자 3자리를 초기화합니다 (lottokey) : ex) 654
 * 다. 사용자가 입력한 복권 숫자가 모두 일치 : 상금 1백만 지급
 * 라. 일치하지 않는 경우 : “아쉽지만, 다음 기회를!” 라고 출력
 */
public class Q25_Lotto {
    public static void main(String[] args) {
        int[] num = new int[3];

        int i, j;

        for (i = 0; i < 3; i++) {
            System.out.println(i + 1 + "번 째 수를 입력하시오.");
            Scanner sc = new Scanner(System.in);
            num[i] = sc.nextInt();
            if (num[i] < 1 || num[i] > 45) {
                System.out.println("1부터 45까지의 수를 입력하시오.");
                i--;
                continue;
            }
            if (i > 0) {
                for (j = 0; j < i - 1; j++) {
                    //모든 값을 받기는 성공했으나, 2번 입력시 중복체크가 적용 안되는 문제 발생.
                    if (num[j] == num[i]) {
                        System.out.println("중복 값은 입력할 수 없습니다.");
                        i--;
                        continue;
                    }
                    System.out.println("-----------------결과값 출력-----------------");
                    System.out.println("입력한 값 : " + Arrays.toString((num)));

                }
            }
        }
        int[] lot = new int[3];

        for (i = 0; i < lot.length; i++) {
            lot[i] = (int) (Math.random() * 45) + 1;

        }
        System.out.println("당첨번호 : " + Arrays.toString((lot)));
    }
}