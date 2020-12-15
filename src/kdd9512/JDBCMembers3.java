package kdd9512;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCMembers3 {
    /**컬럼 정보 전부 출력
     * 컬럼정보 : custid, name, address, phone
     * 입력은 Scanner로
     */
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from BookMembers";
        String fmt = "%s %s %s %s \n";
        StringBuilder sb = new StringBuilder();

        conn = JDBCUtil.makeConn();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                String cstid = rs.getString(1);
                String nm = rs.getString(2);
                String add= rs.getString(3);
                String phone = rs.getString(4);
                String result = String.format(fmt,cstid,nm,add,phone);
                sb.append(result);

            }
        } catch (SQLException throwables) {
            System.out.println("JBDC 질의문 생성 실패");
        }
        JDBCUtil.destroyConn(conn, pstmt, rs);

        System.out.println(sb.toString());
    }
}
