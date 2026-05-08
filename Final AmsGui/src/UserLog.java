//Kobe Smith on 4/5/2026
import java.util.ArrayList;

public class UserLog {
    ArrayList<Passenger> passengerLog = new ArrayList<>();
    ArrayList<Staff> staffLog = new ArrayList<>();
    ArrayList<Staff> managerLog = new ArrayList<>();

    public void addPassenger(Passenger passenger) {
        passengerLog.add(passenger);
    }

    public void addStaff(Staff staff) {
        staffLog.add(staff);
    }

    public void removeStaff(Staff staff) {
        staffLog.remove(staff);
    }

    public void addManager(Staff manager) {
        managerLog.add(manager);
    }

    public ArrayList<Passenger> getPassengerLog() {
        return passengerLog;
    }

    public ArrayList<Staff> getStaffLog() {
        return staffLog;
    }

    public ArrayList<Staff> getManagerLog() {
        return managerLog;
    }
}