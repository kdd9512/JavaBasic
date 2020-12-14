package kdd9512;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCBooks {
    // bigdata DB의 데이터 Books 테이블에
    // 새로운 도서정보를 입력하는 JDBC 프로그램을 작성
    // 컬럼정보 : bookid, bookname, publisher, price
    // 입력은 scanner 사용.
    public static void main(String[] args) {
        // 1. 도서정보 입력
        Scanner sc = new Scanner(System.in);
        System.out.println("도서정보 입력");
        System.out.println("1. 도서번호, 2. 도서명, 3. 출판사, 4. 가격");
        for (int i = 0; i < 4; ++i) {
            System.out.println(i + 1 + "번 정보 입력");
            System.out.print("도서ID\n");
            int bookid = Integer.parseInt(sc.nextLine());
            System.out.print("도서명\n");
            String bookname = sc.nextLine();
            System.out.print("출판사\n");
            String publisher = sc.nextLine();
            System.out.print("도서가격\n");
            int price = Integer.parseInt(sc.nextLine());

            // 2. 입력받은 도서정보를
            // Books 테이블에 적용할 SQL문을 생성하는 명령문 작성.
            // insert into Books values(10,'자바','더조은',10000)
            String sql = "insert into Books values" +
                    "(" + bookid + ",'" + bookname + "','" + publisher + "'," + price + ")";
            // 값이 입력되어야 하므로 ""로 괄호와 컴마를 하나하나 다 감싸고 + 로 문장을 이어붙힌 형태
            // 특히 작은 따옴표의 위치를 잘 봐야한다. 숫자값을 받는데 필요하기 떄문.

            System.out.println(sql); // 확인 및 활용을 위한 출력문구.


            // 3. 생성한 SQL 문을 JDBC 를 통해 실행. 보통 이 문구는 맨 처음에 깔고 들어간다.
            // HelloJDBC 클래스 내용 축약한 것.
            String DRV = "org.mariadb.jdbc.Driver"; // 드라이버 이름을 String 클래스로 축약.
            String URL = "jdbc:mariadb://"
                    + "bigdata.cu13n6b9juzc.ap-northeast-2.rds.amazonaws.com"
                    + ":3306/bigdata";
            ;
            String USR = "bigdata";
            String PWD = "bigdata2020";


            // a) JDBC 드라이버 초기화
            try {
                Class.forName(DRV);
            } catch (ClassNotFoundException cnf) {
                System.out.println("JDBC 드라이버 확인요망");
            }

            // b) DB 서버접속
            Connection conn = null;
            try {
                conn = DriverManager.getConnection(URL, USR, PWD);
            } catch (SQLException se) {
                System.out.println("DB접속 주소 혹은 ID/비밀번호 확인 요망.");
            }

            // c) SQL문 객체를 생성하고 서버로 전송하여 실행함.
            Statement stmt = null;
            try {
                stmt = conn.createStatement();
                boolean isFail = stmt.execute(sql);
                if (!isFail) System.out.println("데이터 추가 완료."); // 실패인가 아닌가를 묻고 성공이라면 문장 출력.
            } catch (SQLException se) {
                System.out.println("JDBC - SQL 실행 에러");
            }

            // d) JDBC 관련 객체는 메모리에서 제거
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException se) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException se) {
                }
            }


        }


    }


}
