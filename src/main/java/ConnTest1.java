import java.sql.Connection;
import java.sql.DriverManager;

public class ConnTest1 {
    public static String RDB_DRIVE = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost/study";
    public static String USER = "root";
    public static String PWD = "";

    public static void main(String[] args) {
        try {
            Class.forName(RDB_DRIVE);
            Connection conn = DriverManager.getConnection(URL,USER,PWD);

            System.out.println("JDBC 연결 성공");
            System.out.println("DB Conn: " + conn);

            conn.close();
        }catch (Exception e){
            System.out.println("JDBC DB 연결 오류: " + e);
        }
    }
}
