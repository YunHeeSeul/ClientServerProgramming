import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DataIF extends Remote {
	String printAllStudentList() throws RemoteException, NullDataException;
	String printAllCourseList() throws RemoteException, NullDataException;
	boolean addStudent(String studentInfo) throws RemoteException;
	boolean deleteStudent(String studentID) throws RemoteException;

//	ArrayList<Student> getAllStudentData() throws RemoteException;
//	ArrayList<Course> getAllCourseData() throws RemoteException;

}
