import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface DataIF extends Remote {
	String printAllCourseList() throws RemoteException;
	String printAllStudentList() throws RemoteException;
}
