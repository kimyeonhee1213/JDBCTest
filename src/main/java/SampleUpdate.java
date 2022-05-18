import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/***
 * 데이터 업데이트
 */
public class SampleUpdate {
    public static String RDB_DRVIE = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost/study";
    public static String USER = "root";
    public static String PWD = "";

    public static void main(String[] args) {
        try {
            Class.forName(RDB_DRVIE);
            Connection conn = DriverManager.getConnection(URL, USER, PWD);
            Statement smt = conn.createStatement();
            String sql = "UPDATE students SET student_name='이순신' WHERE student_id='C0053'";
            int rowCnt = smt.executeUpdate(sql);

            System.out.println(rowCnt + "레코드가 변경되었습니다");
            smt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("JDBC DB 연결 오류" + e);
        }
    }
}
