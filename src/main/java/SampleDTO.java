public class SampleDTO {
    private String studentId;
    private String studentName;
    private String mobilePhone;
    private String school;
    private String branch;

    public SampleDTO(){
        studentId = null;
        studentName = null;
        mobilePhone = null;
        school = null;
        branch = null;
    }

    public String getStudentId(){
        return studentId;
    }

    public void setStudentId(String studentId){
        this.studentId = studentId;
    }

    public String getStudentName(){
        return studentName;
    }

    public void setStudentName(String studentName){
        this.studentName = studentName;
    }

    public String getMobilePhone(){
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone){
        this.mobilePhone = mobilePhone;
    }

    public String getSchool(){
        return school;
    }

    public void setSchool(String school){
        this.school = school;
    }

    public String getBranch(){
        return branch;
    }

    public void setBranch(String branch){
        this.branch = branch;
    }
}
