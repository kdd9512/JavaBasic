package kdd9512;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCOrders3c {
    // 컬럼정보 : orderid, custid, bookid, saleprice, orderdate
    // 입력은 Scanner 로
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from BookOrder where orderdate like ?";
        String fmt = "%s %s %s %s %s \n";
        StringBuilder sb = new StringBuilder();

        Scanner sc = new Scanner(System.in);
        System.out.print("주문일자는 : ");
        String orderdate = sc.nextLine();

        // 날짜로 검색. 날짜 양식에 맞게 0000-00-00 식으로 검색해야 하긴하지만 일단 가능하긴 함.
        conn = JDBCUtil.makeConn();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, orderdate + '%'); // 'orderdate%' 로 sql에 찍혀 DB에 들어간다.
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String ordid = rs.getString(1);
                String cstid = rs.getString(2);
                String bookid = rs.getString(3);
                String saleprice = rs.getString(4);
                String orddate = rs.getString(5);

                String result = String.format(fmt,
                        ordid, cstid, bookid, saleprice, orddate);
                sb.append(result);

            }

        } catch (SQLException se) {
            System.out.println("JDBC 질의문 생성 실패.");
        }
        JDBCUtil.destroyConn(conn, pstmt, rs);

        System.out.println(sb.toString());
    }
}
