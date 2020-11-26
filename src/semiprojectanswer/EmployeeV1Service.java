package semiprojectanswer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * 인사정보 처리 인터페이스를 구현한 클래스
 * 인사정보 처리에 대한 CRUD 코드를 여기에 작성.
 */


public class EmployeeV1Service extends EmployeeV1GenericService {
    List<EmployeeVO> empdata = new ArrayList<>();


    //인사정보처리 UI 출력
    public void displayMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------\n")
                .append("인사 관리 프로그램 v1\n")
                .append("-------------------\n")
                .append("1. 인사 데이터 입력\n")
                .append("2. 인사 데이터 조회\n")
                .append("3. 인사 데이터 상세조회\n")
                .append("4. 인사 데이터 수정\n")
                .append("5. 인사 데이터 삭제\n")
                .append("0. 프로그램 종료\n")
                .append("-------------------\n")
                .append("원하시는 작업은 ? [0,1,2,3,4,5] : ");

        System.out.print(sb);

    }

    //신규정보 입력
    @Override
    public void newEmp() {
        //String fname, lname, email, phone, hdat, jobid;
        //int empno, sal, mgrid, deptid;
        //double comm;
        EmployeeVO emp = new EmployeeVO(0, "", "", "",
                "", "", "", 0, 0.0, 0, 0);
        // 변수들을 다 정리하였다.

        //모든 인사정보는 일단 문자형으로 받되, 필요에 따라 적절한 형변환을 하여 변수에 저장.

        Scanner sc = new Scanner(System.in);
        System.out.print("사번 : ");
        //emp = sc.nextInt();
        emp.setEmpno(Integer.parseInt(sc.nextLine()));

        System.out.println("이름 : ");
        emp.setFname(sc.nextLine());

        System.out.println("성 : ");
        emp.setLname(sc.nextLine());

        System.out.println("이메일 : ");
        emp.setEmail(sc.nextLine());

        System.out.println("전화 : ");
        emp.setPhone(sc.nextLine());

        System.out.println("입사일 : ");
        emp.setHdat(sc.nextLine());

        System.out.println("직책 : ");
        emp.setJobid(sc.nextLine());

        System.out.println("급여 : ");
        emp.setSal(Integer.parseInt(sc.nextLine()));

        System.out.println("수당 : ");
        emp.setComm(Double.parseDouble(sc.nextLine()));

        System.out.println("상사 : ");
        emp.setMgrid(Integer.parseInt(sc.nextLine()));

        System.out.println("부서 : ");
        emp.setDeptid(Integer.parseInt(sc.nextLine()));

        //String값으로 받고 정수 혹은 실수로 푸는 함수 Xxx.parseXxx(sc.nextLine())

        empdata.add(emp);

    }

    //정보입력 확인
    @Override
    public void readEmp() {
        //헤더 선언시 데이터가 출력되는 간격을 유지하기 위해 '\t' 사용.
        // \t 는 8칸 띄어쓰기 TAB 누른효과.
        String fmt = "%8s %8s %8s %8s %8s %8s\n";
        System.out.printf(fmt, "empno", "lname", "email", "jobid", "mgrid", "deptid\n");
        Iterator<EmployeeVO> iter = empdata.iterator();
        while (iter.hasNext()) {
            EmployeeVO e = iter.next();
            System.out.printf(fmt, e.getEmpno(), e.getLname(), e.getEmail(),
                    e.getJobid(), e.getMgrid(), e.getDeptid());
        }

    }

    //입력된 정보를 사원번호로 검색.
    @Override
    public void readOneEmp() {
        String fmt = "%8s %8s %8s %8s %8s " +
                    "%8s %8s %8s %8s %8s \n"; //항목이 많긴한데 개수 주의. 실제 값의 개수와 맞춰야 한다.
        EmployeeVO emp = new EmployeeVO();
        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 사원번호 : ");
        emp.setEmpno(Integer.parseInt(sc.nextLine()));

        for (EmployeeVO e : empdata) {
            //순회해서 읽어온 empdata 내의 사원번호와 입력한 사원번호 emp 를 비교
            if (e.getEmpno() == emp.getEmpno()) {
                //둘이 같을 경우에는,
                emp = e;
                //emp 값이 e에 들어간다.
                //즉, 사원번호가 일치하는 empdata내의 값이 출력된다.
            }

        }
        System.out.printf(fmt, "empNo","fName","lName","email","hDat","jobId","sal","comm","mgrId", "deptId");
        System.out.printf(fmt, emp.getEmpno(), emp.getFname(),
                emp.getLname(), emp.getEmail(),
                emp.getHdat(), emp.getJobid(),
                emp.getSal(), emp.getComm(),
                emp.getMgrid(), emp.getDeptid());
    }

    @Override
    public void modifyEmp() {
    }

    @Override
    public void removeEmp() {
    }
}
