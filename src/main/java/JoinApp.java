import java.util.ArrayList;

public class JoinApp {
    private static ArrayList<JoinDTO> studentList = null;

    public static void main(String[] args) {
        try {
            JoinDAO objDao = new JoinDAO();
            studentList = objDao.join();

            System.out.println("#조인 후 SQL");
            display();
        }catch (Exception e){
            System.out.println("오류 발생: " + e);
        }
    }

    public static void display(){
        for (int i = 0; i < studentList.size(); i++) {
            JoinDTO joinDTO = studentList.get(i);
            System.out.print("학생 ID: " + joinDTO.getStudentId() +
                    "\t");
            System.out.print("학생 이름: " + joinDTO.getStudentName() +
                    "\t");
            System.out.print("시험회차: " + joinDTO.getExamNo() +
                    "\t");
            System.out.print("과목: " + joinDTO.getSubject() +
                    "\t");
            System.out.print("점수: " + joinDTO.getScore() +
                    "\n");
        }
        System.out.println();
    }
}
