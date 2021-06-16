package kdd9512;

import java.util.Scanner;

/**
 * SungJukV10Main
 * 작성일 20201126
 * <p>
 * 프로그램 설명 : 성적처리 프로그램 V10
 * 성적처리 프로그램에 저장기능 추가.
 * mariadb 데이터베이스에 sungjuk 이라는 테이블을 생성하고
 * 저장된 성적데이터를 조회하거나 수정, 삭제할 수 있도록 함.
 *
 */
public class SungJukV10Main {
    public static void main(String[] args) {
        SungJukV10Service sjsrv = new SungJukV10Service();
        Scanner sc = new Scanner(System.in);
        String menu = "";
        while (true) { //강제종료 전까지는 메뉴화면 띄워야 하므로.
            sjsrv.displayMenu();// SungJukV9Service의 displayMenu 불러옴.
            menu = sc.nextLine();
            switch (menu) {
                case "1" : sjsrv.newSungJuk();break;
                case "2" : sjsrv.readSungJuk();break;
                case "3" : sjsrv.readOneSungJuk();break;
                case "4" : sjsrv.modiftSungJuk();break;
                case "5" : sjsrv.deleteSungJuk();break;
                case "0" : System.out.println("\n시스템을 종료합니다....\n");System.exit(0);break;
                default : System.out.println("\n잘못 입력 하셨습니다.\n");break;
            }
        }
    }
}

