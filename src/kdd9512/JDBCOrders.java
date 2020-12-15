package kdd9512;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCOrders {
    // bigdata DB의 BookOrder 테이블에
    // 새 주문정보를 입력하는 JDBC 프로그램을 작성
    // 컬럼정보 : orderid, custid, bookid, saleprice, orderdate
    // 입력은 Scanner 로
    public static void main(String[] args) {
        String DRV = "org.mariadb.jdbc.Driver";
        String URL = "jdbc:mariadb://"
                + "bigdata.cu13n6b9juzc.ap-northeast-2.rds.amazonaws.com"
                + ":3306/bigdata";
        ;
        String USR = "bigdata";
        String PWD = "bigdata2020";

        Connection conn = null;
        Statement stmt = null;


        // 이 클래스에서 입력하고자하는 orderid 는 DB상에서 외래키로 잡혀있기 때문에
        // 반드시 참조하는 테이블에 존재하는 값이어야 올바르게 입력될 수 있다
        // ex) orderid 는 회원 테이블에서 값을 참조하므로 회원정보에 없는 회원이면
        // 주문 테이블에서 데이터입력 자체가 안됌.

        Scanner sc = new Scanner(System.in);
        System.out.println("주문정보 입력");
        for (int i = 0; i < 5; ++i) {
            System.out.println("1. 주문ID");
            int orderid = Integer.parseInt(sc.nextLine());

            System.out.println("2. 고객ID");
            int custid = Integer.parseInt(sc.nextLine());

            System.out.println("3. 도서ID");
            int bookid = Integer.parseInt(sc.nextLine());

            System.out.println("4. 판매가");
            int saleprice = Integer.parseInt(sc.nextLine());

            System.out.println("5. 주문일");
            String orderdate = sc.nextLine();


            // 쿼리문 작성

            String sql = "insert into BookOrder values" +
                    "(" + orderid + "," + custid + "," + bookid + "," + saleprice + ",'"
                    + orderdate + "')";

            System.out.println(sql);


            // DB접속을 위한 try문 작성. 기존버전의 문구들을 전부 병합하고 finally 이용하여 자원반환.

            try {
                Class.forName(DRV);
                conn = DriverManager.getConnection(URL, USR, PWD);
                stmt = conn.createStatement();

                int cnt = stmt.executeUpdate(sql);
                if (cnt > 0) System.out.println("입력 성공.");

            } catch (ClassNotFoundException e) {
                System.out.println("JDBC드라이버 확인 요망");
            } catch (SQLException se) {
                System.out.println("DB주소 혹은 ID/비밀번호 확인 요망.");
            } finally {
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

}
