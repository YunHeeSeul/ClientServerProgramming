import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface DataIF extends Remote {
	ArrayList<Student> getStudent() throws RemoteException;
	ArrayList<Course> getCourse() throws RemoteException;
	String printAllStudentList() throws RemoteException;
	String printAllCourseList() throws RemoteException;
	String printAllReservationList() throws RemoteException;
	boolean addStudent(String studentInfo) throws RemoteException;
	boolean deleteStudent(String studentID) throws RemoteException;
	boolean addCourse(String courseInfo) throws RemoteException;
	boolean deleteCourse(String courseID) throws RemoteException;
	boolean makeReservation(String reservInfo) throws RemoteException;
	boolean deleteReservation(String studentID, String courseID)throws RemoteException;
	boolean login(String id, String pw)throws RemoteException;
	boolean isRegisteredStudent(String studentID) throws RemoteException;
	boolean isRegisteredCourse(String courseID) throws RemoteException;
	boolean doPrerequisitedCourse(String studentID, String courseID) throws RemoteException;
	boolean havePrerequisitedCourse(String courseID) throws RemoteException;
}

