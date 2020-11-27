package semiproject;

import java.util.Scanner;

public class EmployeeV1MainExtend {
    public static void main(String[] args) {
        EmployeeV1ServExtend empsv = new EmployeeV1ServExtend();
        Scanner sc = new Scanner(System.in);
        String menu = "";
        while (true) {
            empsv.displayMenu();//ServExtend에 짜놓은 메뉴화면 출력 메서드 호출.
            menu = sc.nextLine();
            switch (menu) {
                case "1" : empsv.inputNew();break;
                case "2" : empsv.read();break;
                case "3" : empsv.readOne();break;
                case "4" : break;
                case "5" : break;
                case "0" : System.out.println("\n시스템을 종료합니다....\n");System.exit(0);break;
                default : System.out.println("\n잘못 입력 하셨습니다.\n");break;
            }
        }
    }
}
