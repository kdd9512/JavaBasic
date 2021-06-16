package semiproject;

import kdd9512.JDBCUtil2;

public class EmployeeJDBC extends JDBCUtil2 {

    public static String insertEmp =
            "insert into Employee (fname,lname,email,phone,mngid,dptid) " +
                    " values (?,?,?,?,?,?) "; // + 기준으로 윗줄 끝 아랫줄 시작에 한칸씩 띄운다.

    public static String selectEmp =
            "select empno, fname, lname, email, phone, hrdate , mngid, dptid from Employee " +
                    " order by empno desc ";

    public static String selectOneEmp =
            "select * from Employee where empno = ? " +
                    " order by empno desc ";

    public static String updateEmp =
            "update Employee set fname = ?, lname = ?, email = ?, phone = ?, " +
                    " hrdate = ?, mngid = ?, dptid = ? where empno = ? ";

    public static String deleteEmp =
            "delete from Employee where empno = ? ";


}
