package semiproject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class EmployeeV1Service extends EmployeeV1GenericService {

    List<EmployeeVO> empdata = new ArrayList<>();

    EmployeeVO emp = null;
    @Override
    public void inputNew() {

        emp = new EmployeeVO("", "", "", "",
                "", "", "", 0, 0.0, 0, 0);

        Scanner sc = new Scanner(System.in);
        System.out.print("사번 : ");emp.setEmpno(sc.nextLine());
        System.out.print("이름 : ");emp.setFname(sc.nextLine());
        System.out.print("성 : ");emp.setLname(sc.nextLine());
        System.out.print("email : ");emp.setEmail(sc.nextLine());
        System.out.print("전화 : ");emp.setPhone(sc.nextLine());
        System.out.print("직책 : ");emp.setJobid(sc.nextLine());
        System.out.print("입사일 : ");emp.setHdat(sc.nextLine());
        System.out.print("급여 : ");emp.setSal(Integer.parseInt(sc.nextLine()));
        System.out.print("수당 : ");emp.setComm(Double.parseDouble(sc.nextLine()));
        System.out.print("상사 : ");emp.setMgrid(Integer.parseInt(sc.nextLine()));
        System.out.print("부서 : ");emp.setDeptid(Integer.parseInt(sc.nextLine()));


        empdata.add(emp);// 받은 변수값을 empdata에 저장.

    }

    @Override
    public void read() {
        String fmv = "\n사번 : %2s, 이름 : %2s, 성 : %2s\nemail : %2s, 전화 : %2s\n입사일 : %2s, JobID : %2s\n급여 : %2d, 성과급 지급율 : %.1f\n상사번호 : %2d, 부서번호 : %2d\n";
        Iterator<EmployeeVO> iter = empdata.iterator();
        while (iter.hasNext()) {
            EmployeeVO emp = iter.next();
            System.out.printf(fmv, emp.getEmpno(), emp.getFname(), emp.getLname(), emp.getEmail(), emp.getPhone(),
                    emp.getHdat(), emp.getJobid(), emp.getSal(), emp.getComm(), emp.getMgrid(), emp.getDeptid());
        }

    }

    @Override
    public void readOne() {
        String fmv = "\n사번 : %2s, 이름 : %2s, 성 : %2s\nemail : %2s, 전화 : %2s\n입사일 : %2s, JobID : %2s\n급여 : %2d, 성과급 지급율 : %.1f\n상 사번호 : %2d, 부서번호 : %2d\n";

        Scanner sc = new Scanner(System.in);
        System.out.println("조회할 사원의 사번 : ");
        String empno = sc.nextLine(); // 사원번호 입력받을 변수.

        for (EmployeeVO emp : empdata) {
            if (emp.getEmpno().equals(empno))
                System.out.printf(fmv, emp.getEmpno(), emp.getFname(), emp.getLname(), emp.getEmail(), emp.getPhone(),
                        emp.getHdat(), emp.getJobid(), emp.getSal(), emp.getComm(), emp.getMgrid(), emp.getDeptid());
            break;//출력 후 이 메서드를 나감.
        }
    }

    @Override
    public void modify() {
        super.modify();
    }

    @Override
    public void remove() {
        super.remove();
    }

    public void displayMenu() {
        StringBuilder sb = new StringBuilder();//화면 디자인 작성.
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
        //StringBuilder를 이용하여 화면디자인.
        //.append()로 문자열을 추가하는 이 형태를 기억해야 한다.
        System.out.print(sb);
        //출력은 sb만 하면 끝. 모든 열을 출력해야 하므로, print를 쓴다. ln쓰면 막힘.
    }
}
