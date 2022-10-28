import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class ReservationList implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected ArrayList<Reservation> reservationL;
	Reservation reservation;
	
	public ReservationList(String reservationFileName) throws FileNotFoundException, IOException {
		BufferedReader reservationFile = new BufferedReader(new FileReader(reservationFileName));
		this.reservationL = new ArrayList<Reservation>();
		while(reservationFile.ready()) {
			String reservInfo = reservationFile.readLine();
			if(!reservInfo.equals("")) this.reservationL.add(new Reservation(reservInfo));
		}
		reservationFile.close();
	}
	
	public ArrayList<Reservation> getAllReservationRecords(){
		if(this.reservationL.size()==0) System.out.println("-------RESERVATION DATA IS NULL !!!-------");
		return this.reservationL;
	}
	
	public String printAllReservationRecords(Reservation reservation) {
		String returnRecords = "학번 : " + reservation.studentID + " | 수강 신청 과목명 : "+ reservation.courseID;
		return returnRecords+"\n";
	}
	
	public String printAllReservationList(){
		String returnRList = "";
		if(this.getAllReservationRecords().size()==0) System.out.println("-------RESERVATION DATA IS NULL !!!-------");
		for(Reservation reservation : this.getAllReservationRecords()) {returnRList += printAllReservationRecords(reservation) + "\n";}
		return returnRList;
	}
       	
	public boolean addReservationRecords(String reservInfo){
		if(this.reservationL.add(new Reservation(reservInfo))) return true;
        else return false;		
    }
	
	public boolean deleteReservation(String studentID, String courseID){
        for (int i = 0; i < this.reservationL.size(); i++) {//����� �� �ϳ��ϳ��� ã�Ƽ� ������ ��
        	Reservation r=this.reservationL.get(i);
            if (r.check(studentID, courseID)){
                if(this.reservationL.remove(r)) return true;
                else return false;
            }
        } return false;
    }
	
//	public boolean addCourseID(String courseID){
//		for(int i=0; i<this.reservationL.size();i++) {
//			Reservation r=this.reservationL.get(i);
//			if(r.reservedCoursesList.add(courseID)) return true;
//		}return false;
//	}
}
