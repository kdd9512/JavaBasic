package kdd9512;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCMembers3c {
    /**
     * 컬럼 정보 내 특정 단어로 검색(like 이용).
     * 컬럼정보 : custid, name, address, phone
     * 입력은 Scanner로
     */
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        // select * from bookMembers where name like '김%'
        String sql = "select * from BookMembers where name like ?";
        String fmt = "%s %s %s %s \n";
        StringBuilder sb = new StringBuilder();

        Scanner sc = new Scanner(System.in);
        System.out.print("회원의 성씨 : ");
        String cname = sc.nextLine();

        conn = JDBCUtil.makeConn();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cname + '%');

            rs = pstmt.executeQuery();
            while (rs.next()) {
                String cstid = rs.getString(1);
                String nam = rs.getString(2);
                String address = rs.getString(3);
                String phone = rs.getString(4);

                String result = String.format(fmt, cstid, nam, address, phone);
                sb.append(result);

            }

        } catch (SQLException se) {
            System.out.println("JDBC 질의문 생성 실패.");
        }
        JDBCUtil.destroyConn(conn, pstmt, rs);

        System.out.println(sb.toString());

    }
}
