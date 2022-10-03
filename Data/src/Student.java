
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Student implements Serializable{
    private static final long serialVersionUID = 1L;
    protected String studentId;
    protected String name;
    protected String department;	//학과
    protected ArrayList<String> completedCoursesList;	//내가 들은 과목들

    //Constructor에 string 값을 주면 알아서 클래스로 만들어짐
    public Student(String inputString) {	//String으로 해서 받음
        //토큰으로 끊어 읽는 방법
        StringTokenizer stringTokenizer = new StringTokenizer(inputString);
        this.studentId = stringTokenizer.nextToken();
        this.name = stringTokenizer.nextToken();
        this.department = stringTokenizer.nextToken();
        this.completedCoursesList = new ArrayList<String>();
        while (stringTokenizer.hasMoreTokens()) {	//while문을 통해 과목명 집어 넣음
            this.completedCoursesList.add(stringTokenizer.nextToken());
        }
    }
    public boolean match(String studentId) {
        return this.studentId.equals(studentId);
    }
    public String getName() {
        return this.name;
    }
    public ArrayList<String> getCompletedCourses() {
        return this.completedCoursesList;
    }
    //하나씩 파싱하는 방법

    public String toString() {
        String stringReturn = "학생 ID : " + this.studentId + "  |  학생 이름 : " + this.name + "  |  전공 : " + this.department+ "  |  수강 과목 ID : ";
        for (int i = 0; i < this.completedCoursesList.size(); i++) {
            stringReturn = stringReturn  + this.completedCoursesList.get(i).toString()+"  ";
        }
        return stringReturn+"\n";
    }

}
