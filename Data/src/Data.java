import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Data extends UnicastRemoteObject implements DataIF{ //DataIF를 받아서 Data 클래스를 만들었음
    private static final long serialVersionUID = 1L;
    private final static Logger LOG = Logger.getGlobal();
    protected static StudentList studentList;
    protected static CourseList courseList;
    protected static ReservationList reservationList;
    protected Data() throws RemoteException{super();}

    public static void main(String []args) throws FileNotFoundException, IOException{
        try {
            //data 생성
            Data data = new Data();
            //Naming에 등록(Naming은 라이브러리) | 사용할 이름과 객체 이름을 적어줌
            Naming.rebind("Data" ,data);//rmi registry에 등록
            System.out.println("Data is ready !!!");
            studentList = new StudentList("Students.txt");//student 값을 데이터가 받음. 이젠 넘겨줘야 함
            courseList = new CourseList("Courses.txt");
        }
        catch (RemoteException e){ e.printStackTrace();}
        catch (MalformedURLException e){e.printStackTrace();}
    }

    //받은 데이터를 넘겨줘야 함.
    //우선 어레이리스트 통으로 넘겨주겠음

    @Override
    public String printAllStudentList() throws RemoteException {return studentList.printAllStudentList();}

    @Override
    public String printAllCourseList() throws RemoteException{return courseList.printAllCourseList();}

    @Override
    public String printAllReservationList() throws RemoteException {return reservationList.printAllReservationList();}

    @Override
    public boolean addStudent(String studentInfo) throws RemoteException {
        if(studentList.addStudentRecords(studentInfo)) return true;
        else return false;
    }

    @Override
    public boolean deleteStudent(String studentID) throws RemoteException {
        if(studentList.deleteStudentRecords(studentID)) return true;
        else return false;
    }

    @Override
    public boolean addCourse(String courseInfo) throws RemoteException {
        if(courseList.addCourse(courseInfo)) return true;
        else return false;
    }

    @Override
    public boolean deleteCourse(String courseID) throws RemoteException {
        if(courseList.deleteCourse(courseID)) return true;
        return false;
    }

    @Override
    public boolean makeReservation(String reservInfo) throws RemoteException {
        if(reservationList.addReservationRecords(reservInfo)) return true;
        return false;
    }

    @Override
    public ArrayList<Student> getStudent() throws RemoteException {return studentList.studentL;}

    @Override
    public ArrayList<Course> getCourse() throws RemoteException {return courseList.courseL;}

    @Override
    public boolean login(String id, String pw) throws RemoteException {
        if(studentList.login(id, pw)) return true;
        return false;
    }

    @Override
    public boolean isRegisteredStudent(String studentID) throws RemoteException {
        if(studentList.isRegisteredStudent(studentID)) return true;
        return false;
    }

    @Override
    public boolean isRegisteredCourse(String courseID) throws RemoteException {
        if(courseList.isRegisteredCourse(courseID)) return true;
        return false;
    }

    @Override
    public boolean doPrerequisitedCourse(String studentID, String courseID) throws RemoteException {
        if(studentList.doPrerequisitedCourse(studentID, courseID)) return true;
        return false;
    }

    @Override
    public boolean havePrerequisitedCourse(String courseID) throws RemoteException {
        if(courseList.havePrerequisitedCourse(courseID)) return true;
        return false;
    }

    @Override
    public boolean deleteReservation(String studentID, String courseID) throws RemoteException {
        if(reservationList.deleteReservation(studentID, courseID)) return true;
        return false;
    }
}

