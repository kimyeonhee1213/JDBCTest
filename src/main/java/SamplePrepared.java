import java.sql.*;

public class SamplePrepared {
    public static String RDB_DRIVE = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost/study";
    public static String USER = "root";
    public static String PWD = "";
    public static void main(String[] args) {
        String sql = null;
        int num = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName(RDB_DRIVE);
            conn = DriverManager.getConnection(URL, USER, PWD);
            sql = "UPDATE students SET student_name = ? WHERE student_id = ?";
            System.out.println("# SQL 에 변경 전의 학생 목록");
            selectAll();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "이산");
            ps.setString(2, "C0054");
            num = ps.executeUpdate();
            System.out.println(num + "개의 레코드가 변경 되었습니다.");
            System.out.println("# 변경 후 SQL 의 학생 목록");
            selectAll();
        } catch (Exception e) {
            System.out.println("JDBC DB 연결 오류: " + e);
        } finally {
            try {
                if(ps != null) {
                    ps.close();
                }
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // 예외처리 무시함
            }
        }
    }
    private static void selectAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName(RDB_DRIVE);
            conn = DriverManager.getConnection(URL, USER, PWD);
            String sql = "SELECT * FROM students WHERE student_id LIKE ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "C005%");

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                System.out.println("학생번호: " +
                        rs.getString("student_id")
                        + "| 학생명: " + rs.getString("student_name")
                        + "| 휴대폰: " + rs.getString("mobile_phone")
                        + "| 학교: " + rs.getString("school")
                );
            }
        } catch (Exception e) {
            System.out.println("JDBC DB 연결 오류: " + e);
        } finally {
            try {
                if(ps != null) {
                    ps.close();
                }
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // 예외처리 무시함
            }
        }
    }
}
