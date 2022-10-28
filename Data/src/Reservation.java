import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Reservation implements Serializable{
	
	private static final long serialVersionUID = 1L;
	protected String studentID;
	protected String courseID;
	
	public Reservation(String inputString) {
		StringTokenizer stringTokenizer = new StringTokenizer(inputString);
		this.studentID = stringTokenizer.nextToken();
		this.courseID = stringTokenizer.nextToken();
	}
		
	public boolean match(String studentID) {
		if(this.studentID.equals(studentID))return true;
		return false;
	}

	public boolean check(String studentID, String courseID) {
		if(this.match(studentID))
			if(this.courseID.equals(courseID)) return true;
		return false;
	}
	
	public String toString() {
		String returnString = "학번 : " + this.studentID + " | 수강 신청 과목명 : "+ this.courseID;
		return returnString + "\n";
	}
}
