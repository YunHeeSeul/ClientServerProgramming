
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Course implements Serializable{
    private static final long serialVersionUID = 1L;
    protected String courseID;//과목ID
    protected String pName;//담당 교수 성
    protected String cName;//과목 명
    protected ArrayList<String> prerequisiteCourseList;//선수 과목들

    public Course(String inputString) {//String으로 해서 받음
        StringTokenizer stringTokenizer = new StringTokenizer(inputString);
        this.courseID = stringTokenizer.nextToken();
        this.pName = stringTokenizer.nextToken();
        this.cName = stringTokenizer.nextToken();
        this.prerequisiteCourseList = new ArrayList<String>();
        //while문을 통해 과목명 집어 넣음
        while (stringTokenizer.hasMoreTokens()) {this.prerequisiteCourseList.add(stringTokenizer.nextToken());}
    }
    public boolean match(String courseID) {
        return this.courseID.equals(courseID);
    }
    public String getName() {
        return this.pName;
    }
    public ArrayList<String> getPrerequisiteCourses() {
        return this.prerequisiteCourseList;
    }
    public String toString() {
        String returnString = "과목 ID : " + this.courseID + " | 담당 교수 (성) : " + this.pName + " | 과목명 : " + this.cName + " | 선수 과목 ID : ";
        for (int i = 0; i < this.prerequisiteCourseList.size(); i++) {
            returnString = returnString  + this.prerequisiteCourseList.get(i).toString()+"  ";
        }
        return returnString+"\n";
    }
}
