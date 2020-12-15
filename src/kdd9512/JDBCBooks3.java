package kdd9512;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCBooks3 {
    public static void main(String[] args) {
        // Books 테이블의 저장된 모든 내용을 출력함.
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null; // 얘도 쓰고나면 close해야함.


        // 적용할 sql 문은 여기에 쓴다. 보통은 * 로 몽땅 가져오는게 아니라 가져올 값을 명시해서 가져옴.
        String sql = "select * from Books";
        String fmt = "%s %s %s %s\n"; // 양식. 이 형태로 정보들이 출력된다.

        StringBuilder sb = new StringBuilder(); // 스트링빌더.

        conn = JDBCUtil.makeConn();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery(); // executeQuery 는 값을 검색할때 이용함. 결과값은 rs에 저장.
            while(rs.next()){
                // 이터레이터. 보통 hasnext(다음거 있냐 묻는 메서드)인데 왜 next(다음거 가져오는 메서드)인가
                // 이미 괄호안에 hasNext 값이 들어있다.
                String bookid = rs.getString(1);
                String bookname = rs.getString(2);
                String publisher = rs.getString(3);
                String price = rs.getString(4);
                String result = String.format(fmt, bookid,bookname,publisher,price);
                sb.append(result); // 위 작업을 마치고 한데 묶어서 하나(한줄)로 만듬.

            }
        } catch (SQLException throwables) {
            System.out.println("JBDC 질의문 생성에 실패하였음.");
        }
        JDBCUtil.destroyConn(conn, pstmt, rs);

        System.out.println(sb.toString()); // 객체 sb에 담긴 정보를 문자열로 출력.
    }
}
