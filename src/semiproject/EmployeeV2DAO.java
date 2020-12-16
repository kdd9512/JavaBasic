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
            pstmt.setInt(6,emp2.getDptid());
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


}
