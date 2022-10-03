
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CourseList {
    protected ArrayList<Course> vCourse;
    Course course;

    public CourseList(String cCourseFileName) throws FileNotFoundException, IOException {	//파일을 집어넣으면
        BufferedReader objStudentFile = new BufferedReader(new FileReader(cCourseFileName));	//그 파일을 읽어서
        this.vCourse = new ArrayList<Course>();	//리스트에 넣고
        while (objStudentFile.ready()) {	//끝날 때까지 한 줄 한 줄 읽어서 리스트에 add
            String courInfo = objStudentFile.readLine();
            if (!courInfo.equals("")) {
                this.vCourse.add(new Course(courInfo));	//한 줄 한 줄씩 읽어서
            }
        }
        objStudentFile.close();
    }

    public ArrayList<Course> getAllCourseRecords() {	//읽어오는 부분
        return this.vCourse;
    }

    public String printAllCourseList() {
        String sReturn = "";
        for(Course course : this.getAllCourseRecords()) {
            sReturn = sReturn + printAllCourseRecords(course)+"\n";
        }
        return sReturn;
    }

    public String printAllCourseRecords(Course course) {
        String stringReturn = "과목 ID : " + course.courseId + "  |  담당 교수 (성) : " + course.pName + "  |  과목명 : " + course.cName + "  |  선수 과목 ID : ";
        for (int i = 0; i < course.prerequisiteCoursesList.size(); i++)
            stringReturn = stringReturn  + course.prerequisiteCoursesList.get(i).toString()+"  ";
        return stringReturn;
    }

    public boolean isRegisteredCourse(String cID) {	//과목이 등록되어 있는지 없는지를 확인하는 부분
        for (int i = 0; i < this.vCourse.size(); i++) {
            Course objCourse = (Course) this.vCourse.get(i);
            if (objCourse.match(cID)) {
                return true;
            }
        }
        return false;
    }
}
