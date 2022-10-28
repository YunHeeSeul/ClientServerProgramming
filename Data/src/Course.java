
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Course implements Serializable{
    private static final long serialVersionUID = 1L;
    protected String courseID;
    protected String pName;
    protected String cName;
    protected ArrayList<String> prerequisiteCourseList;

    public Course(String inputString) {
        StringTokenizer stringTokenizer = new StringTokenizer(inputString);
        this.courseID = stringTokenizer.nextToken();
        this.pName = stringTokenizer.nextToken();
        this.cName = stringTokenizer.nextToken();
        this.prerequisiteCourseList = new ArrayList<String>();
        while (stringTokenizer.hasMoreTokens()) {this.prerequisiteCourseList.add(stringTokenizer.nextToken());}
    }

    public boolean checkSID(String courseID) {	return this.courseID.equals(courseID);}

    public String getName() {return this.pName;}

    public ArrayList<String> getPrerequisiteCourses() {	return this.prerequisiteCourseList;}

    public String toString() {
        String returnString = "과목 ID : " + this.courseID + " | 담당 교수 (성) : " + this.pName + " | 과목명 : " + this.cName + " | 선수 과목 ID : ";
        for (int i = 0; i < this.prerequisiteCourseList.size(); i++) {
            returnString = returnString  + this.prerequisiteCourseList.get(i).toString()+"  ";
        }
        return returnString+"\n";
    }
}
