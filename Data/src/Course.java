
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Course implements Serializable{
    private static final long serialVersionUID = 1L;
    protected String courseId;  //과목ID
    protected String pName; //담당 교수 성
    protected String cName; //과목 명
    protected ArrayList<String> prerequisiteCoursesList;	//선수 과목들


    public Course(String inputString) {	//String으로 해서 받음
        StringTokenizer stringTokenizer = new StringTokenizer(inputString);
        this.courseId = stringTokenizer.nextToken();
        this.pName = stringTokenizer.nextToken();
        this.cName = stringTokenizer.nextToken();
        this.prerequisiteCoursesList = new ArrayList<String>();
        while (stringTokenizer.hasMoreTokens()) {	//while문을 통해 과목명 집어 넣음
            this.prerequisiteCoursesList.add(stringTokenizer.nextToken());
        }
    }
    public boolean match(String courseId) {
        return this.courseId.equals(courseId);
    }
    public String getName() {
        return this.pName;
    }
    public ArrayList<String> getPrerequisiteCourses() {
        return this.prerequisiteCoursesList;
    }
    public String toString() {
        String stringReturn = "과목 ID : " + this.courseId + " | 담당 교수 (성) : " + this.pName + " | 과목명 : " + this.cName + " | 선수 과목 ID : ";
        for (int i = 0; i < this.prerequisiteCoursesList.size(); i++) {
            stringReturn = stringReturn  + this.prerequisiteCoursesList.get(i).toString()+"  ";
        }
        return stringReturn+"\n";
    }

}
