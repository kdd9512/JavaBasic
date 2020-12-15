package kdd9512;

import java.sql.*;

public class JDBCUtil {
    // JDBC 드라이버 초기화 및 Connection 개체 생성
    // 여기서 한단계 더 발전하면 이하 서버주소, ID/비번 등을
    // 전부 하나의 txt파일로 만들어서 외부로 뺀다음 불러오는게 가능함.
    public static Connection makeConn() {
        String DRV = "org.mariadb.jdbc.Driver";
        String URL = "jdbc:mariadb://"
                + "bigdata.cu13n6b9juzc.ap-northeast-2.rds.amazonaws.com"
                + ":3306/bigdata";

        String USR = "bigdata";
        String PWD = "bigdata2020";

        // DB접속을 위한 try문.
        Connection conn = null;
        try {
            Class.forName(DRV);
            conn = DriverManager.getConnection(URL, USR, PWD);
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 확인 요망.");
        } catch (SQLException sqe) {
            System.out.println("DB 주소 혹은 ID/비밀번호 재확인 요망.");
        }
        return conn;
    }
    // 여기다 접속용 코드를 담아다 다른곳에서 끌어다 쓸 것이므로 public 사용한 것.
    //

    // JDBC 관련 객체 해제. 객체는 위에서 받아와야 하므로 괄호 안에 쓴다.
    public static void destroyConn(Connection conn, PreparedStatement pstmt) {
        if (pstmt != null)
            try { pstmt.close(); } catch (SQLException sqe) { }

        if (conn != null)
            try { conn.close(); } catch (SQLException sqe) { }
    }


    public static void destroyConn(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if (rs != null) try {
            rs.close(); } catch (SQLException sqe) { }
        // rs가 가장 마지막에 쓰였으므로 가장 먼저 닫음
        destroyConn(conn, pstmt);
        // 위의 descroyConn 을 그대로 끌어다 붙힌 것.
    }
}
