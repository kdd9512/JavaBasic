package semiproject;

import java.util.Scanner;

public class EmployeeV2Main {
    public static void main(String[] args) {
        EmployeeV2Service empsrv = new EmployeeV2Service();
        Scanner sc = new Scanner(System.in);
        String menu = "";
        while (true) { //강제종료 전까지는 메뉴화면 띄워야 하므로.
            empsrv.displayMenu();
            menu = sc.nextLine();
            switch (menu) {
                case "1" : empsrv.newEmp();break;
                case "2" : empsrv.readEmp();break;
                case "3" : empsrv.readOneEmp();break;
                case "4" : break;
                case "5" : break;
                case "0" : System.out.println("\n시스템을 종료합니다....\n");System.exit(0);break;
                default : System.out.println("\n잘못 입력 하셨습니다.\n");break;
            }
        }
    }
}
