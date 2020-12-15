package kdd9512;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCMembers {
    // bigdata DB의 BookMembers 테이블에
    // 새 회원정보를 입력하는 JDBC 프로그램을 작성
    // 컬럼정보 : custid, name, address, phone
    // 입력은 Scanner로
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("회원정보 입력하시오.");
        for (int i = 0; i < 4; ++i) {
            System.out.println("1. 고객ID");
            String custid = sc.nextLine();

            System.out.println("2. 고객이름");
            String name = sc.nextLine();

            System.out.println("3. 주소");
            String address = sc.nextLine();

            System.out.println("4. 전화번호");
            String phone = sc.nextLine();

            String sql = "insert into BookMembers values" +
                    "('" + custid + "','" + name + "','" + address + "','" + phone + "')";

            System.out.println(sql);

            String DRV = "org.mariadb.jdbc.Driver";
            String URL = "jdbc:mariadb://"
                    + "bigdata.cu13n6b9juzc.ap-northeast-2.rds.amazonaws.com"
                    + ":3306/bigdata";

            String USR = "bigdata";
            String PWD = "bigdata2020";
            Connection conn = null;
            Statement stmt = null;

            try {
                Class.forName(DRV);
                conn = DriverManager.getConnection(URL, USR, PWD);
                stmt = conn.createStatement();

                int cnt = stmt.executeUpdate(sql);
                if (cnt > 0) System.out.println("입력 성공.");
            } catch (ClassNotFoundException e) {
                System.out.println("JDBC 드라이버 확인 요망.");
            } catch (SQLException sqe) {
                System.out.println("DB 주소 혹은 ID/비밀번호 재확인 요망.");
            } finally {
                if (stmt != null)
                    try {
                        stmt.close();
                    } catch (SQLException sqe) {
                    }

                if (conn != null)
                    try {
                        conn.close();
                    } catch (SQLException sqe) {
                    }
            }
        }


    }

}
