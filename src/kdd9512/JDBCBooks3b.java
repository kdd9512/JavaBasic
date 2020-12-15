package kdd9512;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 특정 행만 조회하기.
 */
public class JDBCBooks3b {
    public static void main(String[] args) {
        // 도서 제목으로 도서정보 조회.
        Connection conn = null;
        PreparedStatement pstmt = null;
        ;
        ResultSet rs = null;
        String sql = "select * from Books where bookname = ?";
        String fmt = "%s %s %s %s \n";
        StringBuilder sb = new StringBuilder();

        // 조회할 도서제목을 입력받음
        Scanner sc = new Scanner(System.in);
        System.out.print("도서제목 입력 : ");
        String bookname = sc.nextLine();

        //
        conn = JDBCUtil.makeConn();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bookname);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String bkid = rs.getString(1);
                String bkname = rs.getString(2);
                String publ = rs.getString(3);
                String price = rs.getString(4);

                String result = String.format(fmt, bkid, bkname, publ, price);
                sb.append(result);

            }

        } catch (SQLException ex) {
            System.out.println("");
        }
        JDBCUtil.destroyConn(conn,pstmt,rs);

        System.out.println(sb.toString());


    }
}
