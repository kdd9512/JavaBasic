package kdd9512;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCMembers2 {
    // bigdata DB의 BookMembers 테이블에
    // 새 회원정보를 입력하는 JDBC 프로그램을 작성
    // 컬럼정보 : custid, name, address, phone
    // 입력은 Scanner로

    public static void main(String[] args) {
        Connection conn = null;

        conn = JDBCUtil.makeConn();
        PreparedStatement pstmt = null;
        String sql = "insert into BookMembers values (?,?,?,?)";

        // 도서정보 입력받을 Scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("회원정보 입력하시오.");
            System.out.println("1. 고객ID");
            String custid = sc.nextLine();

            System.out.println("2. 고객이름");
            String name = sc.nextLine();

            System.out.println("3. 주소");
            String address = sc.nextLine();

            System.out.println("4. 전화번호");
            String phone = sc.nextLine();

        try {
            pstmt = conn.prepareStatement(sql);

            // 위 sql문에 무슨 값이 들어가는가를 여기서 결정함.
            // 변수의 개수대로 setXxx(Xxx는 변수의 유형)를 만듦.
            pstmt.setString(1, custid);
            pstmt.setString(2, name);
            pstmt.setString(3, address);
            pstmt.setString(4, phone);

            int cnt = pstmt.executeUpdate(); // 반영에 성공하면, 반영된 행의 수를 배출함.
            if ( cnt > 0 ) System.out.println("입력정보를 추가하는 데 성공하였습니다.");

        } catch (SQLException ex) { // 예외상황(오류)가 나면 이거 출력하라.
            System.out.println("JBDC 질의문 생성에 실패하였음.");
        }


        JDBCUtil.destroyConn(conn,null); // JDBC에 들어가있는 접속 및 접속해제 코드 불러옴.

    }
}
