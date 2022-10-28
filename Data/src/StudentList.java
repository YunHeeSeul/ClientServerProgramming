
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//여기서 데이터를 넣고 지우고...
public class StudentList {
    protected ArrayList<Student> studentL;
    Student student;

    public StudentList(String sStudentFileName) throws FileNotFoundException, IOException {
        BufferedReader studentFile = new BufferedReader(new FileReader(sStudentFileName));
        this.studentL = new ArrayList<Student>();
        while (studentFile.ready()) {
            String stuInfo = studentFile.readLine();
            if (!stuInfo.equals("")) this.studentL.add(new Student(stuInfo));
        }
        studentFile.close();
    }

    public ArrayList<Student> getAllStudentRecords(){
        if(this.studentL.size()==0) System.out.println("-------Student Data is NULL !!!-------");  //nulldataexception을 생성해서 던짐
        return this.studentL;//모든 학생정보를 반환해줌
    }

    public String printAllStudentList(){
        String returnSList = "";
        if(this.getAllStudentRecords().size()==0) System.out.println("-------Student Data is NULL !!!-------");
        for(Student student : this.getAllStudentRecords()) { returnSList = returnSList + printAllStudentRecords(student)+"\n";}
        return returnSList;
    }

    public String printAllStudentRecords(Student student) {
        String returnSRecord = "학생 ID : " + student.studentID + "  |  학생 PW : " + student.studentPW + "  |  학생 이름 : " + student.name + "  |  전공 : " + student.major+ "  |  수강 과목 ID : ";
        for (int i = 0; i < student.completedCourseList.size(); i++) returnSRecord = returnSRecord  + student.completedCourseList.get(i).toString()+"  ";
        return returnSRecord+"\n";
    }

    public boolean addStudentRecords(String studentInfo){
        if(this.studentL.add(new Student(studentInfo))) return true;
        else return false;
    }

    public boolean deleteStudentRecords(String studentID){
        for (int i = 0; i < this.studentL.size(); i++) {//지우는 건 하나하나씩 찾아서 지워야 함
            Student objStudent = this.studentL.get(i);
            if (objStudent.checkSID(studentID)){
                if(this.studentL.remove(objStudent)) return true;
                else return false;
            }
        } return false;
    }

    public boolean login(String studentID, String studentPW) {//학생으로 등록되어 있는지 없는지를 확인하는 부분
        for (int i = 0; i < this.studentL.size(); i++) {
            Student objStudent = (Student) this.studentL.get(i);
            if (objStudent.login(studentID, studentPW))	return true;
        } return false;
    }

    public boolean isRegisteredStudent(String studentID) {
        for (int i = 0; i < this.studentL.size(); i++) {
            Student objStudent = (Student) this.studentL.get(i);
            if (objStudent.checkSID(studentID))	return true;
        } return false;
    }

    public boolean doPrerequisitedCourse(String studentID, String courseID) {
        for(int i=0; i<this.studentL.size(); i++) {
            Student objStudent = this.studentL.get(i);
            if(objStudent.matchSC(studentID, courseID)) return true;
        }return false;
    }
}
