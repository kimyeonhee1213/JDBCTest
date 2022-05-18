import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SampleInsert {
    public static String RDB_DRIVE = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost/study";
    public static String USER = "root";
    public static String PWD = "";

    public static void main(String[] args) {
        try{
            Class.forName(RDB_DRIVE);
            Connection conn = DriverManager.getConnection(URL,USER,PWD);
            Statement smt = conn.createStatement();
            String sql = "INSERT INTO students(student_id, student_name, mobile_phone, school, branch) VALUES('C0053', '홍길동', '01012341234', '중앙중학교', '종로구')";
            int rowCnt = smt.executeUpdate(sql);

            System.out.println(rowCnt + "레코드가 등록되었습니다.");

            smt.close();
            conn.close();
        }catch (Exception e){
            System.out.println("JDBC DB 연결 오류: " + e);
        }
    }
}
