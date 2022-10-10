
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StudentList {
    protected ArrayList<Student> studentL;
    Student student;

    public StudentList(String sStudentFileName) throws FileNotFoundException, IOException {//파일을 집어넣으면
        BufferedReader objStudentFile = new BufferedReader(new FileReader(sStudentFileName));//그 파일을 읽어서
        this.studentL = new ArrayList<Student>();//리스트에 넣고
        while (objStudentFile.ready()) {//끝날 때까지 한 줄 한 줄 읽어서 리스트에 add
            String stuInfo = objStudentFile.readLine();
            //한 줄 한 줄씩 읽어서
            if (!stuInfo.equals("")) this.studentL.add(new Student(stuInfo));
        }
        objStudentFile.close();
    }

    public ArrayList<Student> getAllStudentRecords() {	//읽어오는 부분
        return this.studentL;
    }

    public String printAllStudentList() {
        String returnSList = "";
        for(Student student : this.getAllStudentRecords()) {
            returnSList = returnSList + printAllStudentRecords(student)+"\n";
        }
        return returnSList;
    }

    public String printAllStudentRecords(Student student) {
        String returnSRecord = "학생 ID : " + student.studentID + "  |  학생 이름 : " + student.name + "  |  전공 : " + student.major+ "  |  수강 과목 ID : ";
        for (int i = 0; i < student.completedCourseList.size(); i++) returnSRecord = returnSRecord  + student.completedCourseList.get(i).toString()+"  ";
        return returnSRecord;
    }

    public boolean isRegisteredStudent(String sSID) {//학생으로 등록되어 있는지 없는지를 확인하는 부분
        for (int i = 0; i < this.studentL.size(); i++) {
            Student objStudent = (Student) this.studentL.get(i);
            if (objStudent.match(sSID))return true;
        }
        return false;
    }
}
