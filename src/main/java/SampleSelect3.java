import java.sql.*;

/***
 * 확실한 리소스 해제
 */
public class SampleSelect3 {
    public static String RDB_DRIVE = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost/study";
    public static String USER = "root";
    public static String PWD = "";

    public static void main(String[] args) {
        Connection conn = null;
        Statement smt = null;

        try{
            Class.forName(RDB_DRIVE);
            conn = DriverManager.getConnection(URL,USER,PWD);
            smt = conn.createStatement();
            String sql = "SELECT * FROM students";
            ResultSet rs = smt.executeQuery(sql);

            while (rs.next()){
                System.out.println("학생번호: " +
                        rs.getString("student_id")
                        + "| 학생명: " + rs.getString("student_name")
                        + "| 휴대폰: " + rs.getString("mobile_phone")
                        + "| 학교: " + rs.getString("school")
                );
            }
        }catch (Exception e){
            System.out.println("JDBC DB 연결 오류: "  + e);
        }finally {
            try {
                if(smt != null){
                    System.out.println("SQL문을 닫습니다.");
                    smt.close();
                }
                if(conn != null){
                    System.out.println("DB 연결을 닫습니다.");
                    conn.close();
                }
            }catch (SQLException e){
                //
            }
        }
    }
}
