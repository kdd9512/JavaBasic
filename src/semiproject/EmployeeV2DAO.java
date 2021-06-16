package semiproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeV2DAO {

    public static String insertEmp(EmployeeVO2 emp2) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "사원데이터 처리중 오류";

        conn = EmployeeJDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(EmployeeJDBC.insertEmp);
            // fname,lname,email,phone,mngid,dptid
            pstmt.setString(1,emp2.getFname());
            pstmt.setString(2,emp2.getLname());
            pstmt.setString(3,emp2.getEmail());
            pstmt.setString(4,emp2.getPhone());
            pstmt.setInt(5,emp2.getMngid());
            pstmt.setInt(6,emp2.getDptid()); // 이것도 나중엔 자동생성이 가능하다.
            int cnt = pstmt.executeUpdate();
           if( cnt > 0) result = "사원 데이터 입력 성공";
        } catch (SQLException se) {
            System.out.println("insertEmp 처리 오류");
            se.printStackTrace();
        }
        EmployeeJDBC.destroyConn(conn,pstmt);
        return result;

    }

    public static ArrayList<EmployeeVO2> selectEmp() {

        ArrayList<EmployeeVO2> emp = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = EmployeeJDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(EmployeeJDBC.selectEmp);
            rs = pstmt.executeQuery();
            while(rs.next()){
                EmployeeVO2 evo2 = new EmployeeVO2(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8));
                        emp.add(evo2);
            }
        } catch (SQLException se) {
            System.out.println("selectEmp 오류 발생.");
            se.printStackTrace();
        }
        EmployeeJDBC.destroyConn(conn,pstmt,rs);
        return emp;

    }

    public static EmployeeVO2 selectOneEmp(String empno) {
        EmployeeVO2 evo2 = null;
        Connection conn = null;
        PreparedStatement pstmt = null; // conn, pstmt, rs 은 기본3종. return값을 위한 evo2 생성.
        ResultSet rs = null;


        // employees 테이블에서 사원번호,이름, 성, 이메일, 전화번호, 부서/상사번호를
        // 조회하여 ArraysList로 구성하고 EmployeeServiceV2로 return.

        conn = EmployeeJDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(EmployeeJDBC.selectOneEmp);
            pstmt.setString(1,empno);
            rs = pstmt.executeQuery();
            while (rs.next()){
                evo2 = new EmployeeVO2(
                rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8));
            }
        } catch (SQLException se) {
            System.out.println("selectOneEmp 오류발생.");
            se.printStackTrace();
        }
        EmployeeJDBC.destroyConn(conn,pstmt,rs);

        return evo2;
    }

    // 수정할 사원번호를 넘겨받아 Employee 테이블을 수정
    public static String updateEmp(EmployeeVO2 evo2) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "사원 정보 갱신 중 오류 발생";

        conn = EmployeeJDBC.makeConn();
        try {
            //fname = ?, lname = ?, email = ?, phone = ? where empno = ?
            pstmt = conn.prepareStatement(EmployeeJDBC.updateEmp);
            pstmt.setString(1,evo2.getFname()); // 이름
            pstmt.setString(2,evo2.getLname()); // 성
            pstmt.setString(3,evo2.getEmail()); // 메일
            pstmt.setString(4,evo2.getPhone()); // 전화
            pstmt.setString(5,evo2.getHrdate()); // 입사일
            pstmt.setInt(6,evo2.getMngid()); // 상사번
            pstmt.setInt(7,evo2.getDptid()); // 부서번
            pstmt.setInt(8,evo2.getEmpno()); // 사원번

            int cnt = pstmt.executeUpdate();
            if (cnt>0) result = "사원 정보 갱신 성공";

        } catch (SQLException se) {
            System.out.println("updateEmp 오류 발생.");
            se.printStackTrace();
        }
        EmployeeJDBC.destroyConn(conn,pstmt);
        return result;

    }

    // 입력받은 사원 번호를 이용하여 Employee 테이블 값 삭제
    public static String removeEmp(int empno) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "데이터 삭제 중 오류 발생";

        conn = EmployeeJDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(EmployeeJDBC.deleteEmp);
            pstmt.setInt(1,empno);

            int cnt = pstmt.executeUpdate();
            if (cnt > 0) result = "정보 삭제 성공";

        } catch (SQLException se) {
            System.out.println("deleteEmp 오류 발생");
            se.printStackTrace();
        }
        EmployeeJDBC.destroyConn(conn,pstmt);
        return result;

    }
}
