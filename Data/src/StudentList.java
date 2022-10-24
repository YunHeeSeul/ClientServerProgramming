
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//여기서 데이터를 넣고 지우고...
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

    //데이터를 가져오는 부분.
    //나머지 삭제하고 그런 것도 studentlist에서 진행하면 됨
    public ArrayList<Student> getAllStudentRecords() throws NullDataException {//이걸 호출하는 애들은 nulldataexception을 받아야 한다는 의미. 얘를 호출하는 애는 Data에 있음
        //학생정보를 모두 가져와라.
        //하지만 학생정보가 없을수도 있으니 그걸 확인해 줄 것이 필요.
        if(this.studentL.size()==0) throw new NullDataException("-------Student Data is NULL !!!-------");  //nulldataexception을 생성해서 던짐
        return this.studentL;//모든 학생정보를 반환해줌

    }

    public String printAllStudentList() throws NullDataException {
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

    //잘 넣었는지 확인하기 위해 boolean.
    //여기서는 성공 실패만 전달하지 이유는 전달하지 않음. 이유를 전달하게끔 해보도록
    public boolean addStudentRecords(String studentInfo){//String 대신 Student 클래스를 파라미터로 해도 되는데 좀 더 어려움
        //원래는 add안에 Student 클래스를 넣어줘야 하는데 우리는 파라미터를 String으로 받았으니까 new Student해주고 위의 constructor에서처럼 string을 줘서 생성해줌
        //지금 기존에 있는 정보는 studentL에 있으니 여기에 add해줘야 함
        if(this.studentL.add(new Student(studentInfo))) return true;
        else return false;
    }
    public boolean deleteStudentRecords(String studentID){
        //지우는 건 하나하나씩 찾아서 지워야 함
        for (int i = 0; i < this.studentL.size(); i++) {
            Student objStudent = this.studentL.get(i);
            if (objStudent.match(studentID)){
                if(this.studentL.remove(objStudent)) return true;
                else return false;
            }
        }
        return false;
    }
    public boolean isRegisteredStudent(String sSID) {//학생으로 등록되어 있는지 없는지를 확인하는 부분
        for (int i = 0; i < this.studentL.size(); i++) {
            Student objStudent = (Student) this.studentL.get(i);
            if (objStudent.match(sSID))return true;
        }
        return false;
    }
}
