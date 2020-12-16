package kdd9512;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SungJukV10DAO {
    // 전달받은 성적data를 sungjuk 테이블에 저장.
    public static String insertSungJuk(SungJukV0 sj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "성적데이터 처리중..?"; // 성적값을 담을 result 초기값 설정.

        conn = SungJukJDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(SungJukJDBC.insertSungJuk);
            pstmt.setString(1, sj.getName());
            pstmt.setInt(2, sj.getKor());
            // == setString(2,sj.getKor()+"")
            pstmt.setInt(3, sj.getMat());
            pstmt.setInt(4, sj.getEng());
            pstmt.setInt(5, sj.getSum());
            pstmt.setDouble(6, sj.getMean());
            pstmt.setString(7, sj.getGrd() + "");
            int cnt = pstmt.executeUpdate();
            if (cnt > 0) result = "성적정보 저장 성공";

        } catch (SQLException se) {
            System.out.println("insertSQL 오류 발생.");
            se.printStackTrace();
        }
        SungJukJDBC.destroyConn(conn, pstmt);

        return result;
    }

    // 번호 이름 국어 영어 수학 등록일 조회하고
    // 그 결과들을 ArrayList에 담아 넘김
    public static ArrayList<SungJukV0> selectSungJuk() {
        ArrayList<SungJukV0> sjs = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = SungJukJDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(SungJukJDBC.selectSungJuk);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                SungJukV0 sj = new SungJukV0(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        0, 0.0, ' ',rs.getString(6));
                sjs.add(sj);
            }
        } catch (SQLException se) {
            System.out.println("selectSungJuk 오류");
            se.printStackTrace();
        }
        SungJukJDBC.destroyConn(conn, pstmt, rs);
        return sjs;
    }

    // 성적번호로 성적데이터를 조회하고
    // 그 결과를 SungJukV0 에 담아서 넘김
    public static SungJukV0 selectOneSungJuk(String sjno) {
        SungJukV0 sj = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = SungJukJDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(SungJukJDBC.selectOneSungJuk);
            pstmt.setString(1,sjno);
            rs = pstmt.executeQuery();
            if(rs.next()){
                sj = new SungJukV0(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getDouble(7),
                        rs.getString(8).charAt(0),
                        rs.getString(9)
                );
            }
        } catch (SQLException se) {
            System.out.println("selectOneSungJuk 오류 발생.");
            se.printStackTrace();
        }
        SungJukJDBC.destroyConn(conn,pstmt,rs);

        return sj;
    }
}
