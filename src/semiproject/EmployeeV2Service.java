package semiproject;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeV2Service {
    
    public void displayMenu() {

        StringBuilder sb = new StringBuilder();
        sb.append("-------------------\n")
                .append("사원 정보 관리 프로그램 v2\n")
                .append("-------------------\n")
                .append("1. 사원 데이터 입력\n")
                .append("2. 사원 데이터 조회\n")
                .append("3. 사원 데이터 상세조회\n")
                .append("4. 사원 데이터 수정\n")
                .append("5. 사원 데이터 삭제\n")
                .append("0. 프로그램 종료\n")
                .append("-------------------\n")
                .append("원하시는 작업은 ? [0,1,2,3,4,5] : ");

        System.out.print(sb);
    }

    public void newEmp(){

        String fname,lname,email,phone;
        int mngid,dptid;

        Scanner sc = new Scanner(System.in);
        //fname,lname,email,phone,mngid,dptid
        System.out.print("이름 : ");
        fname = sc.nextLine();
        System.out.print("성씨 : ");
        lname = sc.nextLine();
        System.out.print("Emali : ");
        email = sc.nextLine();
        System.out.print("전화 : ");
        phone = sc.nextLine();
        System.out.print("상사 번호 : ");
        mngid = sc.nextInt();
        System.out.print("부서 번호 : ");
        dptid = sc.nextInt();

        EmployeeVO2 emp2 = new EmployeeVO2(fname,lname,email,phone,mngid,dptid);

        String result = EmployeeV2DAO.insertEmp(emp2);

    }

    public void readEmp() {
        StringBuilder sb = new StringBuilder();
        String fmt = "사번 : %d,이름 : %s, 성 : %s, Email : %s,전화 : %s, 입사일 : %s\n" +
                "상사번호 : %d,부서번호 : %d\n ";

        ArrayList<EmployeeVO2> emp = EmployeeV2DAO.selectEmp();

        for (EmployeeVO2 evo2 : emp){
            String result = String.format(fmt,evo2.getEmpno(),evo2.getFname(),
                    evo2.getLname(),evo2.getEmail(),evo2.getPhone(),
                    evo2.getHrdate().substring(0,10),evo2.getMngid(),evo2.getDptid());
            sb.append(result);
        }
        System.out.println(sb.toString()); // 업데이트된 sb를 출력. 이거 안쓰면 결과출력이 안됌.
    }

    public void readOneEmp() {

    }
}
