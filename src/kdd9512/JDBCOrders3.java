package kdd9512;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCOrders3 {

    // 컬럼정보 : orderid, custid, bookid, saleprice, orderdate
    // 입력은 Scanner 로
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from BookOrder";
        String fmt = "%s %s %s %s %s \n";
        StringBuilder sb = new StringBuilder();

        conn = JDBCUtil.makeConn();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String ordid = rs.getString(1);
                String custid = rs.getString(2);
                String bookid = rs.getString(3);
                String saleprice = rs.getString(4);
                String orderdate = rs.getString(5);

                String result = String.format(fmt, ordid,custid,bookid,saleprice,orderdate);
                sb.append(result);

            }

        } catch (SQLException se) {
            System.out.println("JDBC 질의문 생성 실패.");
        }
        JDBCUtil.destroyConn(conn, pstmt, rs);

        System.out.println(sb.toString());
    }
}
