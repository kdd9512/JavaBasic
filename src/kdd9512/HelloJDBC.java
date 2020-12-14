package kdd9512;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HelloJDBC {
    /**
     * JDBC
     * java database connectivity
     * 자바를 통해 다양한 관계형 데이터베이스에 접속하고
     * SQL문을 실행해서 관리하고자 할떄 사용하는
     * 표준 SQL 인터페이스
     * 이를 통해 데이터베이스 코드를 한번만 작성해 두면
     * 어떤 DBMS라도 코드변경 없이 동일하게 적용할 수 있다.
     * JDK에 포함된 JDBC 인터페이스는
     * java.sql 패키지 내에 있음.
     * <p>
     * SQL문 만으로는 프로그램을 작성할 수 없으며
     * JDBC 인터페이스에 맞게 각 DB제조사가 구현한 JDBC
     * 클래스들이 필요하다.
     * 이를 JDBC 드라이버 라고 한다.
     * JDBC 드라이버들은 제조사 홈페이지에서 내려받을 수 있음.
     * <p>
     * mariadb.org -> MariaDB Connector/J
     */

    // 1. 드라이버 설정.
    public static void main(String[] args) {
        try {
            Class.forName("org.mariadb.jdbc.Driver"); // 드라이버명 입력.
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버를 설치하시오.");
        }

        // 2. DB 서버에 접속.
        Connection conn = null; // 초기화
        String url = "jdbc:mariadb://" // DB유형을 입력
                + "bigdata.cu13n6b9juzc.ap-northeast-2.rds.amazonaws.com" // 서버의 주소. AWS RDS 들어가보면 있음.
                + ":3306/playground"; // DB의 포트번호/DB명. DB 종류마다 고유 포트번호가 있음.

        try {
            conn = DriverManager.getConnection( // 연결객체를 가져옴.
                    url, "playground", "play2020");

            if (!conn.isClosed()) // 접속 실패가 아닐 때 이하의 문구 출력.
                System.out.println("데이터베이스 접속 성공.");

        } catch (SQLException sqlex) { // 접속이 실패하여 이슈가 일어나면 이하 문구를 출력.
            System.out.println("DB접속 주소 혹은 ID/비밀번호를 확인하세요.");

        } finally {
            if (conn != null) { // conn 이 null 이 아닐떄 = url,id,pw를 입력하고 접속을 시도할 떄.
                try {
                    conn.close();
                } catch (SQLException sqlex) {
                }
            }
        }
    }
}
