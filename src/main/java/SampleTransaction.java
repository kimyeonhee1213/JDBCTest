import java.sql.*;

public class SampleTransaction {
    public static String RDB_DRIVE = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost/study";
    public static String USER = "root";
    public static String PWD = "";
    public static void main(String[] args) {
        String sql = null;
        int num = 0;
        Connection conn = null;
        Statement smt = null;
        try {
            Class.forName(RDB_DRIVE);
            conn = DriverManager.getConnection(URL, USER, PWD);
            conn.setAutoCommit(false);
            smt = conn.createStatement();
            System.out.println("# SQL 에 접근하기 전의 학생 목록");
            selectAll();
            sql = "INSERT INTO students(student_id, student_name, mobile_phone, school, branch) VALUES('C0053', '홍길동', '01012341234', '중앙중학교', '종로구')";
            num = smt.executeUpdate(sql);
            System.out.println(num + "개의 새 레코드가 등록 되었습니다.");
            sql = "INSERT INTO students(student_id, student_name, mobile_phone, school, branch) VALUES('C0054', '신사임당', '0101000234','중앙중학교', '종로구')";
            num = smt.executeUpdate(sql);
            System.out.println(num + "개의 새 레코드가 등록 되었습니다.");
            System.out.println("# 등록 후 SQL 의 학생 목록");
            selectAll();
            System.out.println("커밋 처리를 합니다.");
            conn.commit();
            System.out.println("# 커밋 후 SQL 의 학생 목록");
            selectAll();
        } catch (Exception e) {
            System.out.println("JDBC DB 연결 오류: " + e);
            try {
                System.out.println("롤백 처리를 합니다.");
                conn.rollback();
                System.out.println("# 롤백 후 학생 목록");
                selectAll();
            } catch (SQLException ignore) {
                // 예외처리 무시
            }
        } finally {
            try {
                if(smt != null) {
                    smt.close();
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
        Statement smt = null;
        try {
            Class.forName(RDB_DRIVE);
            conn = DriverManager.getConnection(URL, USER, PWD);
            smt = conn.createStatement();
            String sql = "SELECT * FROM students";
            ResultSet rs = smt.executeQuery(sql);
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
                if(smt != null) {
                    smt.close();
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
