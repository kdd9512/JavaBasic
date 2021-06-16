package kdd9512;

public class SungJukJDBC extends JDBCUtil2{

    public static String insertSungJuk =
            "insert into sungjuk (name,kor,mat,eng,tot,mean,grd)\n" +
            "values (?,?,?,?,?,?,?)";

    public static String selectSungJuk =
            "select sjno,name,kor,mat,eng,regdate from sungjuk order by sjno desc";

    public static String selectOneSungJuk =
            "select * from sungjuk where sjno = ?" +
                    "order by sjno desc";

    public static String updateSungJuk =
            "update sungjuk " +
                    " set kor = ?, mat = ?, eng = ?, tot = ?, mean = ?, grd = ?, "
                    + " regdate = sysdate() where sjno = ?";

    public static String deleteSungJuk =
            "delete from sungjuk where sjno = ?";

}
