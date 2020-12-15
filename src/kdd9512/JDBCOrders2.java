package kdd9512;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCOrders2 {
    // bigdata DB의 BookOrder 테이블에
    // 새 주문정보를 입력하는 JDBC 프로그램을 작성
    // 컬럼정보 : orderid, custid, bookid, saleprice, orderdate
    // 입력은 Scanner 로
    public static void main(String[] args) {
        Connection conn = null;

        conn = JDBCUtil.makeConn();

        PreparedStatement pstmt = null;
        String sql = "insert into BookOrder values (?,?,?,?,?)";

        Scanner sc = new Scanner(System.in);
        System.out.println("주문정보 입력");

        System.out.println("1. 주문ID");
        String orderid = sc.nextLine();

        System.out.println("2. 고객ID");
        String custid = sc.nextLine();

        System.out.println("3. 도서ID");
        String bookid = sc.nextLine();

        System.out.println("4. 판매가");
        int saleprice = Integer.parseInt(sc.nextLine());

        System.out.println("5. 주문일");
        String orderdate = sc.nextLine();



        try {
            pstmt = conn.prepareStatement(sql);

            // 위 sql문에 무슨 값이 들어가는가를 여기서 결정함.
            // 변수의 개수대로 setXxx(Xxx는 변수의 유형)를 만듦.
            pstmt.setString(1, orderid);
            pstmt.setString(2, custid);
            pstmt.setString(3, bookid);
            pstmt.setInt(4, saleprice);
            pstmt.setString(5, orderdate);

            int cnt = pstmt.executeUpdate(); // 반영에 성공하면, 반영된 행의 수를 배출함.
            if ( cnt > 0 ) System.out.println("입력정보를 추가하는 데 성공하였습니다.");

        } catch (SQLException ex) { // 예외상황(오류)가 나면 이거 출력하라.
            System.out.println("JBDC 질의문 생성에 실패하였음.");
        }
        JDBCUtil.destroyConn(conn,null);
    }
}
