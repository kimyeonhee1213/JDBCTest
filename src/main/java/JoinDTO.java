public class JoinDTO {
    private String studentId;
    private int examNo;
    private String subject;
    private int score;

    private String studentName;

    public JoinDTO(){
        studentId = null;
        examNo = 0;
        subject = null;
        score = 0;
    }

    public String getStudentId(){
        return studentId;
    }

    public void setStudentId(String studentId){
        this.studentId = studentId;
    }

    public int getExamNo(){
        return examNo;
    }

    public void setExamNo(int examNo){
        this.examNo = examNo;
    }

    public String getSubject(){
        return subject;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    public int getScore(){
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName){
        this.studentName = studentName;
    }

}
