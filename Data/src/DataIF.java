import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface DataIF extends Remote {
	//Data 인터페이스로 등록함. 그리고 getAllStudentData로 값을 가져옴 그리고 ArrayList<Student> 값을 리턴해줌
	ArrayList<Course> getAllStudentData() throws RemoteException;
//    String getData() throws RemoteException;
}
