import java.util.ArrayList;

public class InsertApp2 {
    private static ArrayList<SampleDTO> studentList = null;

    public static void main(String[] args) {
        try {
            SampleDao2 objDao = new SampleDao2();
            studentList = objDao.selectAll();

            System.out.println("#학생정보 등록 전 SQL");
            display();

            SampleDTO studentDTO = new SampleDTO();
            studentDTO.setStudentId("C0056");
            studentDTO.setStudentName("손흥민");
            studentDTO.setMobilePhone("01033334444");
            studentDTO.setSchool("역삼중학교");
            studentDTO.setBranch("강남구");

            int rowCnt = objDao.insertStudent(studentDTO);
            if (rowCnt > 0 ){
                System.out.println(rowCnt + "개의 레코드가 등록되었습니다.");
            }

            studentList = objDao.selectAll();
            System.out.println("#학생정보 등록 후 SQL");
            display();
        }catch (Exception e){
            System.out.println("오류 발생: " + e);
        }
    }

    public static void display(){
        for (int i = 0; i < studentList.size(); i++) {
            SampleDTO studentDto = studentList.get(i);
            System.out.print("학생 ID: " + studentDto.getStudentId() +
                    "\t");
            System.out.print("학생명: " + studentDto.getStudentName() +
                    "\t");
            System.out.print("휴대폰: " + studentDto.getMobilePhone() +
                    "\n");
        }
        System.out.println();
    }
}
