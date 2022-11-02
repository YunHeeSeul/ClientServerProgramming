import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Reservation implements Serializable{
	
	private static final long serialVersionUID = 1L;
	protected String studentID;
	protected String courseID;
//	protected ArrayList<String> reservedCoursesList;
	
	public Reservation(String inputString) {
		StringTokenizer stringTokenizer = new StringTokenizer(inputString);
		this.studentID = stringTokenizer.nextToken();
		this.courseID = stringTokenizer.nextToken();
//		this.reservedCoursesList = new ArrayList<String>();
//		while(stringTokenizer.hasMoreTokens()) {this.reservedCoursesList.add(stringTokenizer.nextToken());}
	}
//	public ArrayList<String> getReservedCourses(){ return this.reservedCoursesList;}
	
	public boolean match(String studentID) {//수강신청 하려는 학생과 과목이 존재하는지 확인
		if(this.studentID.equals(studentID))return true;
		return false;
	}

	public boolean check(String studentID, String courseID) {
		if(this.match(studentID))
			if(this.courseID.equals(courseID)) return true;
//			if(this.reservedCoursesList.contains(courseID)) return true;
		return false;
	}
	public String toString() {
		String returnString = "학번 : " + this.studentID + " | 수강 신청 과목명 : "+ this.courseID;
//		String returnString = "학번 : " + this.studentID + " | 수강 신청 과목명 : ";
//		for(int i=0; i<this.reservedCoursesList.size(); i++) {
//			returnString += this.reservedCoursesList.get(i).toString();
//		}
		return returnString + "\n";
	}
}
