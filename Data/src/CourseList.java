
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CourseList {
    protected ArrayList<Course> courseL;
    Course course;

    public CourseList(String courseFileName) throws FileNotFoundException, IOException {
        BufferedReader objStudentFile = new BufferedReader(new FileReader(courseFileName));
        this.courseL = new ArrayList<Course>();
        while (objStudentFile.ready()) {
            String courInfo = objStudentFile.readLine();
            if (!courInfo.equals("")) this.courseL.add(new Course(courInfo));
        }
        objStudentFile.close();
    }

    public ArrayList<Course> getAllCourseRecords() {
        if(this.courseL.size()==0)System.out.println("-------COURSE DATA IS NULL !!!-------");
        return this.courseL;
    }

    public String printAllCourseList(){
        String returnCList = "";
        if(this.getAllCourseRecords().size()==0)System.out.println("-------COURSE DATA IS NULL !!!-------");
        for(Course course : this.getAllCourseRecords()) returnCList = returnCList + printAllCourseRecords(course)+"\n";
        return returnCList;
    }

    public String printAllCourseRecords(Course course) {
        String returnCRecords = "과목 ID : " + course.courseID + "  |  담당 교수 (성) : " + course.pName + "  |  과목명 : " + course.cName + "  |  선수 과목 ID : ";
        for (int i = 0; i < course.prerequisiteCourseList.size(); i++) returnCRecords = returnCRecords  + course.prerequisiteCourseList.get(i).toString()+"  ";
        return returnCRecords+"\n";
    }

    public boolean addCourse(String courseInfo) {
        if(this.courseL.add(new Course(courseInfo))) return true;
        else return false;
    }

    public boolean deleteCourse(String courseID) {
        for(int i=0; i<this.courseL.size(); i++) {
            Course objCourse = this.courseL.get(i);
            if(objCourse.checkSID(courseID)) {
                if(this.courseL.remove(objCourse)) return true;
                else return false;
            }
        }
        return false;
    }

    public boolean isRegisteredCourse(String courseID) {
        for (int i = 0; i < this.courseL.size(); i++) {
            Course objCourse = (Course) this.courseL.get(i);
            if (objCourse.checkSID(courseID))return true;
        }
        return false;
    }

    public boolean havePrerequisitedCourse(String courseID) {
        for(int i=0; i<this.courseL.size(); i++) {
            Course objCourse = this.courseL.get(i);
            if(objCourse.getPrerequisiteCourses()==null) return true;
        }return false;
    }
}
