import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/***
 * 데이터 선택
 */
public class SampleSelect2 {
    public static String RDB_DRIVE = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost/study";
    public static String USER = "root";
    public static String PWD = "";

    public static void main(String[] args) {
        try {
            Class.forName(RDB_DRIVE);
            Connection conn = DriverManager.getConnection(URL, USER, PWD);
            Statement smt = conn.createStatement();
            String sql = "Select * from exams";
            ResultSet rs = smt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("시험회차: " + rs.getInt("exam_no")
                        + "|과목: " + rs.getString("subject")
                        + "|학생번호: " + rs.getString("student_id")
                        + "|점수: " + rs.getInt("score"));
            }
            rs.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("JDBC DB 연결 오류: " + e);
        }
    }
}
