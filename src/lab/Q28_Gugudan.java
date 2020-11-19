package lab;

/**사용자로부터 숫자(1 - 9)를 하나 입력 받아, 구구단을 출력하는 프로그램을
 * 작성해보세요.
 * 단, 1 - 9 이외의 숫자나 문자를 입력 받으면 “잘못 입력하셨습니다!!”라는 메시지를 출력하도록 합니다. (GuGuDan)
 */
public class Q28_Gugudan {

    public static void main(String[] args) {
        int i,j;

        for(i = 2 ; i < 10 ; i++){
            System.out.println(i+" 단 출력.");
            for(j = 1 ; j < 10 ; j++)
                System.out.printf("\n%2d X %2d = %2d\n",i,j);
        }
    }
}
