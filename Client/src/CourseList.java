
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CourseList {
	protected ArrayList<Course> vCourse;
	
	public CourseList(String cCourseFileName) throws FileNotFoundException, IOException {	//������ ���������
		BufferedReader objStudentFile = new BufferedReader(new FileReader(cCourseFileName));	//�� ������ �о
		this.vCourse = new ArrayList<Course>();	//리스트에 넣고
		while (objStudentFile.ready()) {	//끝날 때까지 한 줄 한 줄 읽어서 리스트에 add
			String courInfo = objStudentFile.readLine();
			if (!courInfo.equals("")) {
				this.vCourse.add(new Course(courInfo));	//한 줄 한 줄 씩 읽어서
			}
		}
		objStudentFile.close();
	}

	public ArrayList<Course> getAllCourseRecords() {	//읽어오는 부분

		return this.vCourse;
	}

	public boolean isRegisteredCourse(String cID) {	//학생이 되어 있는지 없는지를 확인하는 부분
		for (int i = 0; i < this.vCourse.size(); i++) {
			Course objCourse = (Course) this.vCourse.get(i);
			if (objCourse.match(cID)) {
				return true;
			}
		}
		return false;
	}
}
