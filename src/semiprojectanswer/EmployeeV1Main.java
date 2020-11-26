package semiprojectanswer;

import java.util.Scanner;

/**
 * 인사정보 관리 프로그램 진입점.
 */
public class EmployeeV1Main {
    public static void main(String[] args) {
        EmployeeV1Service empsrv = new EmployeeV1Service();

        Scanner sc = new Scanner(System.in);
        String menu = "";

        while (true) {
            empsrv.displayMenu();
            menu = sc.nextLine();
            switch (menu) {
                case "1": empsrv.newEmp();break;
                case "2": empsrv.readEmp();break;
                case "3": empsrv.readOneEmp();break;
                case "4": empsrv.modifyEmp();break;
                case "5": empsrv.removeEmp();break;
                case "0": System.out.println("\n시스템을 종료합니다....\n");System.exit(0);break;
                default: System.out.println("\n잘못 입력 하셨습니다.\n");break;

            }
        }
    }
}
