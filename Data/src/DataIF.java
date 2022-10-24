import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface DataIF extends Remote {
	String printAllCourseList() throws RemoteException, NullDataException;
	String printAllStudentList() throws RemoteException, NullDataException;
	boolean addStudent(String studentInfo) throws RemoteException;
	boolean deleteStudent(String studentID) throws RemoteException;
//	ArrayList<Student> getAllStudentData() throws RemoteException;
//	ArrayList<Course> getAllCourseData() throws RemoteException;

}
