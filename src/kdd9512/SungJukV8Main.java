package kdd9512;

import java.util.Scanner;

/**
 * SungJukV8Main
 * 작성일 20201126
 * <p>
 * 프로그램 설명 : 성적처리 프로그램 V8
 * 성적처리 프로그램을 체계적으로 만들려고 함.
 * 객체지향 기법을 토대로 CRUD 기능을 제공하도록 작성
 * 성적데이터 입력/조회/수정/삭제 메뉴를 제공하여
 * 프로그램의 사용성을 향상시킴
 * 즉, 입력받은 성적데이터를 동적배열에 저장하고
 * 저장된 성적데이터를 조회하거나 수정, 삭제할 수 있도록 함.
 * <p>
 * SungJukService : readSungJuk, showSungJuk
 * showOneSungJuk, modifySungJuk,
 * removeSungJuk, computeSungJuk
 * ,displayMenu
 */
public class SungJukV8Main {
    public static void main(String[] args) {
        SungJukV8Service sjsrv = new SungJukV8Service();
        Scanner sc = new Scanner(System.in);
        String menu = "";
        while (true) { //강제종료 전까지는 메뉴화면 띄워야 하므로.
            sjsrv.displayMenu();// SungJukV8Service의 displayMenu 불러옴.
            menu = sc.nextLine();
            switch (menu) { // 입력값에 따라 기능을 나눠야하므로
                            // if문 비교보다는 switch가 낫다(이 많은 조건을 if문으로 쓰는건 비효율적)
                case "1" : sjsrv.newSungJuk();break;
                case "2" : sjsrv.readSungJuk();break;
                case "3" : sjsrv.readOneSungJuk();break;
                case "4" : break;
                case "5" : break;
                case "0" : System.out.println("\n시스템을 종료합니다....\n");System.exit(0);break;
                default : System.out.println("\n잘못 입력 하셨습니다.\n");break;
            }
        }
    }
}

