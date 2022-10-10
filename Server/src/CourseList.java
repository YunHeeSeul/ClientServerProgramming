
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CourseList {
    protected ArrayList<Course> lCourse;
    Course course;

    public CourseList(String courseFileName) throws FileNotFoundException, IOException {//파일을 집어넣으면
        BufferedReader objStudentFile = new BufferedReader(new FileReader(courseFileName));//그 파일을 읽어서
        this.lCourse = new ArrayList<Course>();//리스트에 넣고
        while (objStudentFile.ready()) {//끝날 때까지 한 줄 한 줄 읽어서 리스트에 add
            String courInfo = objStudentFile.readLine();
            //한 줄 한 줄씩 읽어서
            if (!courInfo.equals("")) this.lCourse.add(new Course(courInfo));
        }
        objStudentFile.close();
    }

    public ArrayList<Course> getAllCourseRecords() {return this.lCourse;}

    public String printAllCourseList() {
        String returnCList = "";
        for(Course course : this.getAllCourseRecords()) returnCList = returnCList + printAllCourseRecords(course)+"\n";
        return returnCList;
    }

    public String printAllCourseRecords(Course course) {
        String returnCRecords = "과목 ID : " + course.courseID + "  |  담당 교수 (성) : " + course.pName + "  |  과목명 : " + course.cName + "  |  선수 과목 ID : ";
        for (int i = 0; i < course.prerequisiteCourseList.size(); i++) returnCRecords = returnCRecords  + course.prerequisiteCourseList.get(i).toString()+"  ";
        return returnCRecords;
    }

    public boolean isRegisteredCourse(String courseID) {//과목이 등록되어 있는지 없는지를 확인하는 부분
        for (int i = 0; i < this.lCourse.size(); i++) {
            Course objCourse = (Course) this.lCourse.get(i);
            if (objCourse.match(courseID))return true;
        }
        return false;
    }
}
