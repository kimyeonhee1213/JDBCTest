import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/***
 * 데이터 선택
 */
public class SampleSelect {
    public static String RDB_DRIVE = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost/study";
    public static String USER = "root";
    public static String PWD = "";

    public static void main(String[] args) {
        try {
            Class.forName(RDB_DRIVE);
            Connection conn = DriverManager.getConnection(URL, USER, PWD);
            Statement smt = conn.createStatement();
            String sql = "SELECT * FROM students";
            ResultSet rs = smt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("학생번호: " + rs.getString("student_id")
                        + "| 학생명: " + rs.getString("student_name")
                        + "| 휴대폰: " + rs.getString("mobile_phone")
                        + "| 학교: " + rs.getString("school"));
            }
            rs.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("JDBC DB 연결 오류: " + e);
        }
    }
}
