import java.util.ArrayList;

public class InsertApp {
    private static ArrayList<String> idList = null;
    private static ArrayList<String> nameList = null;
    private static ArrayList<String> mobileList = null;

    public static void main(String[] args) {
        try {
            SampleDao1 objDao = new SampleDao1();

            idList = objDao.selectStudentIdAll();
            nameList = objDao.selectStudentNameAll();
            mobileList = objDao.selectStudentMobileAll();

            System.out.println("# SQL에 접속하기 전 학생정보");
            display();

            int rowCnt = objDao.insertStudent("C0055", "손흥민",
                    "01010102020", "역삼중학교", "강남구" );
            if(rowCnt > 0){
                System.out.println(rowCnt + "개의 레코드를 등록했습니다.");
            }
            idList = objDao.selectStudentIdAll();
            nameList = objDao.selectStudentNameAll();
            mobileList = objDao.selectStudentMobileAll();

            System.out.println("# SQL 접속 후, 학생정보 보기");
            display();
        }catch (Exception e){
            System.out.println("오류: " + e);
        }
    }
    public static void display(){
        for (int i = 0; i < idList.size(); i++) {
            System.out.print("학생ID: " + idList.get(i) + "\t");
            System.out.print("학생명: " + nameList.get(i) + "\t");
            System.out.print("휴대폰: " + mobileList.get(i) + "\t");
            System.out.println();
        }
    }
}
