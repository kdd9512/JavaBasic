package kdd9512;

import java.util.Scanner;

/**
 * SungJukV9Main
 * 작성일 20201126
 * <p>
 * 프로그램 설명 : 성적처리 프로그램 V9
 * 성적처리 프로그램에 저장기능 추가.
 * 즉, sungjuk.dat 라는 파일을 생성하고
 * 저장된 성적데이터를 조회하거나 수정, 삭제할 수 있도록 함.
 * <p>
 * SungJukService : readSungJuk, showSungJuk
 * showOneSungJuk, modifySungJuk,
 * removeSungJuk, computeSungJuk
 * ,displayMenu
 */
public class SungJukV9Main {
    public static void main(String[] args) {
        SungJukV9Service sjsrv = new SungJukV9Service();
        Scanner sc = new Scanner(System.in);
        String menu = "";
        while (true) { //강제종료 전까지는 메뉴화면 띄워야 하므로.
            sjsrv.displayMenu();// SungJukV9Service의 displayMenu 불러옴.
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

