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

            String sql = "insert into BookOrder values" +
                    "(" + orderid + "," + custid + "," + bookid + "," + saleprice + ",'"
                    + orderdate + "')";

            System.out.println(sql);

            String DRV = "org.mariadb.jdbc.Driver";
            String URL = "jdbc:mariadb://"
                    + "bigdata.cu13n6b9juzc.ap-northeast-2.rds.amazonaws.com"
                    + ":3306/bigdata";
            ;
            String USR = "bigdata";
            String PWD = "bigdata2020";


            try {
                Class.forName(DRV);
            } catch (ClassNotFoundException e) {
                System.out.println("JDBC드라이버 확인 요망");
            }

            Connection conn = null;
            try {
                conn = DriverManager.getConnection(URL, USR, PWD);
            } catch (SQLException se) {
                System.out.println("DB주소 혹은 ID/비밀번호 확인 요망.");
            }

            Statement stmt = null;
            try {
                stmt = conn.createStatement();
                boolean isFail = stmt.execute(sql);
                if (!isFail) System.out.println("입력 성공.");
            } catch (SQLException se) {
                System.out.println("SQL 실행오류");
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException se) { }
            }

            if (conn !=null) {
                try {
                    conn.close();
                } catch (SQLException se) { }
            }


        }

    }


}
