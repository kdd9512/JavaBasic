package kdd9512;

import java.sql.*;
import java.util.Scanner;

public class JDBCBooks2 {
    /**Statement vs preparedStatement
     * 정적 쿼리문과 동적 쿼리문
     *
     * 정적 쿼리문은 사용전에 변수를 이용하여
     * 온전한 형태의 문장을 미리 만들어 주어야 한다.
     * 또한 쿼리문이 실행될 때, 매번
     * 1) 쿼리문장 분석
     * 2) 컴파일
     * 3) 실행
     * 의 과정을 거쳐야 하므로 성능이 저하될 우려가 크다.
     *
     *
     * 반면, 동적쿼리문은 불완전한 형태의 문장으로 윤곽을 잡아주기만 한 후,
     * 실행 전, 매개변수에 실제로 전달해야 할 값을 지정하여 사용한다.
     *
     * 또한, 캐쉬기능을 지원하기 때문에, 반복적으로 실행하는
     * 문장의 경우
     * 1) ,2) 과정을 생략하고 바로 3) 실행이 가능하여
     * 간결한 문장으로 작성이 가능하고 성능저하를 방지할 수 있다.
     *
     * PreparedStatement IN / OUT 매개변수
     * placeholder 매개변수, binding 매개변수 라고 함.
     *
     * sql 질의문 객체 생성시 사용하는 매개변수가 들어갈 자리는 ? 로 표기함.
     * (Java : ?, ? // python : %s, %d // C# : @name, @passwd // oracle : :1, :2)
     *
     * IN 매개변수는 질의문 생성시 입력값 대용으로 사용.
     * OUT 매개변수는 질의문을 실행하고 넘겨주는 결과값을 받을 때 사용.
     *
     */

    // JDBC 드라이버 초기화 및 Connection 개체 생성
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

    // JDBC 관련 객체 해제. 객체는 위에서 받아와야 하므로 괄호 안에 쓴다.
    public static void destroyConn(Connection conn, PreparedStatement pstmt) {
        if (pstmt != null)
            try { pstmt.close(); } catch (SQLException sqe) { }

        if (conn != null)
            try { conn.close(); } catch (SQLException sqe) { }
    }


    // 메인 메서드
    public static void main(String[] args) {

        // 데이터베이스 관련 변수. 변수 개수만큼 ? 를 추가함.
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "insert into Books values (?,?,?,?)";

        // 도서정보 입력받을 Scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("회원정보 입력하시오.");
        System.out.print("도서ID\n");
        int bookid = Integer.parseInt(sc.nextLine());

        System.out.print("도서명\n");
        String bookname = sc.nextLine();

        System.out.print("출판사\n");
        String publisher = sc.nextLine();

        System.out.print("도서가격\n");
        int price = Integer.parseInt(sc.nextLine());

        // 입력받은 도서정보를 테이블에 저장.
        conn = makeConn();
        try {
            pstmt = conn.prepareStatement(sql);

            // 위 sql문에 무슨 값이 들어가는가를 여기서 결정함.
            // 변수의 개수대로 setXxx(Xxx는 변수의 유형)를 만듦.
            pstmt.setInt(1, bookid);
            pstmt.setString(2, bookname);
            pstmt.setString(3, publisher);
            pstmt.setInt(4, price);

            int cnt = pstmt.executeUpdate(); // 반영에 성공하면, 반영된 행의 수를 배출함.
            if ( cnt > 0 ) System.out.println("입력정보를 추가하는 데 성공하였습니다.");

        } catch (SQLException ex) { // 예외상황(오류)가 나면 이거 출력하라.
            System.out.println("JBDC 질의문 생성에 실패하였음.");
        }
        destroyConn(conn, pstmt); // conn과 pstmt 의 연결을 끊음.

    }
}
