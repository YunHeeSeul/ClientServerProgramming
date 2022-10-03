
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StudentList {
    protected ArrayList<Student> vStudent;
    Student student;

    public StudentList(String sStudentFileName) throws FileNotFoundException, IOException {	//파일을 집어넣으면
        BufferedReader objStudentFile = new BufferedReader(new FileReader(sStudentFileName));	//그 파일을 읽어서
        this.vStudent = new ArrayList<Student>();	//리스트에 넣고
        while (objStudentFile.ready()) {	//끝날 때까지 한 줄 한 줄 읽어서 리스트에 add
            String stuInfo = objStudentFile.readLine();
            if (!stuInfo.equals("")) {
                this.vStudent.add(new Student(stuInfo));	//한 줄 한 줄씩 읽어서
            }
        }
        objStudentFile.close();
    }

    public ArrayList<Student> getAllStudentRecords() {	//읽어오는 부분
        return this.vStudent;
    }

    public String printAllStudentList() {
        String sReturn = "";
        for(Student student : this.getAllStudentRecords()) {
            sReturn = sReturn + printAllStudentRecords(student)+"\n";
        }
        return sReturn;
    }

    public String printAllStudentRecords(Student student) {
        String stringReturn = "학생 ID : " + student.studentId + "  |  학생 이름 : " + student.name + "  |  전공 : " + student.department+ "  |  수강 과목 ID : ";
        for (int i = 0; i < student.completedCoursesList.size(); i++)
            stringReturn = stringReturn  + student.completedCoursesList.get(i).toString()+"  ";
        return stringReturn;
    }


    public boolean isRegisteredStudent(String sSID) {	//학생이 되어 있는지 없는지를 확인하는 부분
        for (int i = 0; i < this.vStudent.size(); i++) {
            Student objStudent = (Student) this.vStudent.get(i);
            if (objStudent.match(sSID)) {
                return true;
            }
        }
        return false;
    }
}
