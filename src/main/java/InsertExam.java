import java.util.ArrayList;

public class InsertExam {
    private static ArrayList<ExamDTO> examList = null;

    public static void main(String[] args) {
        try {
            ExamDAO objDao = new ExamDAO();
            examList = objDao.selectAll();

            System.out.println("#시험정보 등록 전 SQL");
            display();

            ExamDTO examDTO = new ExamDTO();
            examDTO.setStudentId("C0056");
            examDTO.setExamNo(46);
            examDTO.setSubject("수학");
            examDTO.setScore(96);
            int rowCnt = objDao.insertExam(examDTO);
            if (rowCnt > 0 ){
                System.out.println(rowCnt + "개의 레코드가 등록되었습니다.");
            }

            examList = objDao.selectAll();
            System.out.println("#시험정보 등록 후 SQL");
            display();
        }catch (Exception e){
            System.out.println("오류 발생: " + e);
        }
    }

    public static void display(){
        for (int i = 0; i < examList.size(); i++) {
            ExamDTO examDto = examList.get(i);
            System.out.print("학생 ID: " + examDto.getStudentId() +
                    "\t");
            System.out.print("시험회차: " + examDto.getExamNo() +
                    "\t");
            System.out.print("과목: " + examDto.getSubject() +
                    "\t");
            System.out.print("점수: " + examDto.getScore() +
                    "\n");
        }
        System.out.println();
    }
}
