
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Student implements Serializable{
    private static final long serialVersionUID = 1L;
    protected String studentID;
    protected String studentPW;
    protected String name;
    protected String major;
    protected ArrayList<String> completedCourseList;

    //Constructor에 string 값을 주면 알아서 클래스로 만들어짐
    public Student(String inputString) {//String으로 해서 받음
        StringTokenizer stringTokenizer = new StringTokenizer(inputString);
        this.studentID = stringTokenizer.nextToken();
        this.studentPW = stringTokenizer.nextToken();
        this.name = stringTokenizer.nextToken();
        this.major = stringTokenizer.nextToken();
        this.completedCourseList = new ArrayList<String>();
        //while문을 통해 수강 과목 ID 집어 넣음
        while (stringTokenizer.hasMoreTokens()) {this.completedCourseList.add(stringTokenizer.nextToken());}
    }
    public boolean match(String studentID) {return this.studentID.equals(studentID);}

    public boolean login(String studentID, String studentPW) {
        if(match(studentID))
            if(this.studentPW.equals(studentPW)) return true;
        return false;
    }

    public boolean check(String studentID, String completedCourse) {
        if(this.match(studentID))
            if(this.completedCourseList.contains(completedCourse)) return true;
        return false;
    }

    public String getName() {return this.name;}

    public ArrayList<String> getCompletedCourse(String studentID) {return this.completedCourseList;}

    //하나씩 파싱하는 방법
    public String toString() {
        String returnString = "학생 ID : " + this.studentID + "  |  학생 PW : " + this.studentPW + "  |  학생 이름 : " + this.name + "  |  전공 : " + this.major+ "  |  수강 과목 ID : ";
        for (int i = 0; i < this.completedCourseList.size(); i++) returnString = returnString  + this.completedCourseList.get(i).toString()+"  ";
        return returnString+"\n";
    }
}
