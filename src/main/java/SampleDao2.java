import java.sql.*;
import java.util.ArrayList;

public class SampleDao2 {
    public static String RDB_DRIVE = "com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost/study";
    public static String USER = "root";
    public static String PWD = "";

    /**
     * DB 연결을 하기 위한 메소드
     * DB 연결 정의를 기반으로 DB 에 연결하고 리턴값으로 연결정보를 리턴함
     * @return Connection
     */
    private static Connection getConnection() {
        try {
            Class.forName(RDB_DRIVE);
            Connection conn = DriverManager.getConnection(URL, USER,
                    PWD);
            return conn;
        } catch(Exception e) {
            throw new IllegalStateException(e);
        }
    }
    /**
     * DB 에서 학생번호 데이터를 검색하는 메소드
     * 테이블에 등록된 모든 학생 데이터를 ArrayList 에 저장하고 리턴값 리턴
     * @return list
     */

    public ArrayList<SampleDTO> selectAll(){
        Connection conn = null;
        Statement smt = null;
        // 배열선언
        ArrayList<SampleDTO> list = new ArrayList<SampleDTO>();
        String sql = "SELECT * FROM students ORDER BY student_id";

        try {
            // DB 연결
            conn = SampleDao2.getConnection();
            smt = conn.createStatement();
            // SQL 문 실행
            ResultSet rs = smt.executeQuery(sql);
            // 검색결과 ArrayList 에 저장
            while(rs.next()) {
                SampleDTO objDTO = new SampleDTO();
                objDTO.setStudentId(rs.getString("student_id"));
                objDTO.setStudentName(rs.getString("student_name"));
                objDTO.setMobilePhone(rs.getString("mobile_phone"));
                objDTO.setSchool(rs.getString("school"));
                objDTO.setBranch(rs.getString("branch"));
                list.add(objDTO);
            }
        } catch (SQLException e) {
            System.out.println("오류 발생: " + e);
        } finally {
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
     * 학생정보 등록 메소드
     * 인수에 전달된 학생정보를 데이터베이스에 들록하고 리턴값으로 등록수를 리턴함
     * @param student
     * @return
     */
    public int insertStudent(SampleDTO student) {
        // 변수 선언
        Connection conn = null;
        Statement smt = null;
        int rowCnt = 0;
        String sql = "INSERT INTO students(student_id, student_name, mobile_phone, school, branch) " +
        "VALUES('" + student.getStudentId() + "', '" +
                student.getStudentName() + "', '" + student.getMobilePhone() + "', '" +
                student.getSchool() + "', '" + student.getBranch() + "')";
        try {
            conn = SampleDao2.getConnection();
            smt = conn.createStatement();
            rowCnt = smt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("JDBC DB 연결 오류: " + e);
        } finally {
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
        return rowCnt;
    }
}
