import java.sql.*;
import java.util.ArrayList;

public class SampleDao1 {
    public static String RDB_DRIVE = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost/study";
    public static String USER = "root";
    public static String PWD = "";
    /**
     * DB 연결 하기 위한 메소드
     */
    private static Connection getConnection(){
        try{
            Class.forName(RDB_DRIVE);
            Connection conn = DriverManager.getConnection(URL,USER,PWD);

            return conn;
        }catch (Exception e){
            throw new IllegalStateException(e);
        }
    }

    /**
     * DB에서 학생번호 데이터를 검색하는 메소드
     * 테이블에 등록된 모든 학생 데이터를 ArrayList에 저장하고 리턴값 리턴
     */
    public ArrayList<String> selectStudentIdAll(){
        Connection conn = null;
        Statement smt = null;

        ArrayList<String> list = new ArrayList<String>();

        String sql = "SELECT student_id FROM students ORDER BY student_id";

        try {
            conn = SampleDao1.getConnection();
            smt = conn.createStatement();

            ResultSet rs = smt.executeQuery(sql);
            while (rs.next()){
                list.add(rs.getString("student_id"));
            }
        }catch (SQLException e){
            System.out.println("오류 발생: " + e);
        }finally {
            if(smt != null){
                try {
                    smt.close();
                }catch (SQLException ignore){}
                try {
                    conn.close();
                }catch (SQLException ignore){}
        }
    }
        return list;
    }
    /**
     * DB에서 학생명 데이터를 검색하는 메소드
     * 테이블에 등록된 모든 학생 데이터를 ArrayList에 저장하고 리턴값 리턴
     */
    public ArrayList<String> selectStudentNameAll(){
        Connection conn = null;
        Statement smt = null;

        ArrayList<String> list = new ArrayList<String>();

        String sql = "SELECT student_name FROM students ORDER BY student_id";

        try {
            conn = SampleDao1.getConnection();
            smt = conn.createStatement();

            ResultSet rs = smt.executeQuery(sql);
            while (rs.next()){
                list.add(rs.getString("student_name"));
            }
        }catch (SQLException e){
            System.out.println("오류 발생: " + e);
        }finally {
            if (smt != null){
                try {
                    smt.close();
                }catch (SQLException ignore){}
                try {
                    conn.close();
                }catch (SQLException ignore){}
        }
    }
        return list;
    }
    /**
     * DB 에서 학생휴대폰 데이터를 검색하는 메소드
     * 테이블에 등록된 모든 학생 데이터를 ArrayList 에 저장하고 리턴값 리턴
     * @return list
     */
    public ArrayList<String> selectStudentMobileAll(){
        Connection conn = null;
        Statement smt = null;

        ArrayList<String> list = new ArrayList<String>();
        String sql = "SELECT mobile_phone FROM students ORDER BY student_id";

        try {
            conn = SampleDao1.getConnection();
            smt = conn.createStatement();
            ResultSet rs = smt.executeQuery(sql);
            while (rs.next()){
                list.add(rs.getString("mobile_phone"));
            }
        }catch (SQLException e){
            System.out.println("오류 발생: " + e);
        }finally {
            // 사용한 리소스 제거
            if(smt != null) {
                try {
                    smt.close();
                } catch (SQLException ignore) {}
                try {
                    conn.close();
                } catch (SQLException ignore) {}
            }
        }
        return list;
    }
    /**
     * 학생 정보 등록하는 메소드
     * 인수에 전달된 학생정보를 데이터베이스 등록하고 리턴값으로 등록된 수를 리턴함
     * @param student_id 학생 ID
     * @param student_name 학생명
     * @param mobile_phone 휴대폰번호
     * @param school 학교
     * @param branch 지역
     * @return rowCnt 등록완료된 수
     */
    public int insertStudent(String student_id, String student_name,
                             String mobile_phone, String school, String branch){
        Connection conn = null;
        Statement smt = null;

        int rowCnt = 0;

        String sql =  "INSERT INTO students(student_id, student_name,mobile_phone, school, branch) VALUES('" + student_id + "', '" + student_name + "', '"
                + mobile_phone + "', '" + school + "', '" + branch + "')";
        try {
            conn = SampleDao1.getConnection();
            smt = conn.createStatement();
            rowCnt = smt.executeUpdate(sql);

        }catch (SQLException e){
            System.out.println("JDBC DB 연결 오류: " + e);
        }finally {
            if(smt != null){
                try {
                    smt.close();
                }catch (SQLException ingore){}
                try {
                    conn.close();
                }catch (SQLException ignore){}
        }
    }
        return rowCnt;
    }
}

