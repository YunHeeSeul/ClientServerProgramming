
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StudentList {
	protected ArrayList<Course> vStudent;
	
	public StudentList(String sStudentFileName) throws FileNotFoundException, IOException {	//파일을 집어넣으면
		BufferedReader objStudentFile = new BufferedReader(new FileReader(sStudentFileName));	//그 파일을 읽어서
		this.vStudent = new ArrayList<Course>();	//리스트에 넣고
		while (objStudentFile.ready()) {	//끝날 때까지 한 줄 한 줄 읽어서 리스트에 add. 리스트화 하는 것
			String stuInfo = objStudentFile.readLine();
			if (!stuInfo.equals("")) {
				this.vStudent.add(new Course(stuInfo));	//한 줄 한 줄씩 읽어서 어레이리스트 Student로 들어감
			}
		}
		objStudentFile.close();
	}

	public ArrayList<Course> getAllCourseRecords() {	//읽어오는 부분

		return this.vStudent;
	}

	public boolean isRegisteredCourse(String sSID) {	//학생이 되어 있는지 없는지를 확인하는 부분
	for (int i = 0; i < this.vStudent.size(); i++) {
			Course objStudent = (Course) this.vStudent.get(i);
			if (objStudent.match(sSID)) {
				return true;
			}
		}
		return false;
	}
}
