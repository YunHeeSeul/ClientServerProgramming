//직접 인터페이스를 만드는 방법도 있지만 링크로 연결하는 방법도 있음.

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface DataIF extends Remote {
	ArrayList<Student> getAllStudentData() throws RemoteException;

//    String getData() throws RemoteException;
}
