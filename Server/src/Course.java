
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Course implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String courseId;  //과목ID
    protected String pName; //담당 교수 성
    protected String preCourseId;   //선수 과목 ID
    protected ArrayList<String> completedCoursesList;	//내가 들은 과목들

    public Course(String inputString) {	//String으로 해서 받음
        StringTokenizer stringTokenizer = new StringTokenizer(inputString);
    	this.courseId = stringTokenizer.nextToken();
    	this.pName = stringTokenizer.nextToken();
    	this.preCourseId = stringTokenizer.nextToken();
    	this.completedCoursesList = new ArrayList<String>();
    	while (stringTokenizer.hasMoreTokens()) {	//while문을 통해 과목명 집어 넣음
    		this.completedCoursesList.add(stringTokenizer.nextToken());
    	}
    }
    public boolean match(String courseId) {
        return this.courseId.equals(courseId);
    }
    public String getName() {
        return this.pName;
    }
    public ArrayList<String> getCompletedCourses() {
        return this.completedCoursesList;
    }
    public String toString() {
        String stringReturn = this.courseId + " | " + this.pName + " | " + this.preCourseId;
        for (int i = 0; i < this.completedCoursesList.size(); i++) {
            stringReturn = stringReturn + " | " + this.completedCoursesList.get(i).toString();
        }
        return stringReturn;
    }
}
