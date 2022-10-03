import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Data extends UnicastRemoteObject implements DataIF{ //DataIF를 받아서 Data 클래스를 만들었음

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    protected static StudentList studentList;	//이걸 밑에 쓰지 않고 위에 쓴 이유는 main 구역안에서만 사용하는게 아니라
    //구역 밖 getData()에서도 사용해야 하기 때문
    protected static CourseList courseList;
    protected Data() throws RemoteException{
        super();
    }
    public static void main(String []args) throws FileNotFoundException, IOException{
        try {
            //data 생성
            Data data = new Data();
            //Naming에 등록(Naming은 라이브러리) | 사용할 이름과 객체 이름을 적어줌
            Naming.rebind("Data" ,data);	//rmi registry에 등록
            System.out.println("Data is ready !!!");

            //데이터를 받고 학생들 파일을 로딩해야 함. 읽어야 함
            studentList = new StudentList("Students.txt");	//student 값을 데이터가 받음. 이젠 넘겨줘야 함
            courseList = new CourseList("Courses.txt");
        }
        catch (RemoteException e){
            e.printStackTrace();
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }
    }

    //받은 데이터를 넘겨줘야 함.
    //우선 어레이리스트 통으로 넘겨주겠음
    @Override
    public ArrayList<Student> getAllStudentData()throws RemoteException{
        return studentList.getAllStudentRecords();
    }
    @Override
    public ArrayList<Course> getAllCourseData() throws RemoteException {
        // TODO Auto-generated method stub
        return courseList.getAllCourseRecords();
    }
    @Override
    public String printAllCourseList() throws RemoteException {
        // TODO Auto-generated method stub
        return courseList.printAllCourseList();
    }
    @Override
    public String printAllStudentList() throws RemoteException {
        // TODO Auto-generated method stub
        return studentList.printAllStudentList();
    }

}

