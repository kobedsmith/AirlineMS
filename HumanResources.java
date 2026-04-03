//Kobe Smith on 3/31/2026
import java.util.ArrayList;

public class HumanResources {
    private ArrayList<Staff> totalStaff;
    private ArrayList<Staff> managers;
    private ArrayList<Staff> cockpit;
    private ArrayList<Staff> attendants;
    private String name;
    private int staffID;
    private String email;
    private String workNumber;
    private String department;

    public HumanResources(ArrayList<Staff> totalStaff, ArrayList<Staff> managers, ArrayList<Staff> cockpit, ArrayList<Staff> attendants, 
        String department, String name, int staffID, String email, String workNumber) {
        this.totalStaff = totalStaff;
        this.managers = managers;
        this.cockpit = cockpit;
        this.attendants = attendants;
        this.department = department;
        this.name = name;
        this.staffID = staffID;
        this.email = email;
        this.workNumber = workNumber;
    }

    public String getInfo() {
        return "Human Resources Department: " + this.name + " - Staff ID: " + this.staffID + " - Email: " + this.email + " - Work Number: " + this.workNumber;
    }

    public void hireManager(Staff staff) {
        if (staff instanceof AircraftManager) {
            managers.add(staff);
            totalStaff.add(staff);
            department = "Aircraft Management";
            System.out.println("Hired Aircraft Manager: " + staff.getName());
        }
        else if (staff instanceof FlightManager) {
            managers.add(staff);
            totalStaff.add(staff);
            department = "Flight Management";
            System.out.println("Hired Flight Manager: " + staff.getName());
        }
        else if (staff instanceof PaymentProcessor) {
            managers.add(staff);
            totalStaff.add(staff);
            department = "Payment Management";
            System.out.println("Hired Payment Processor: " + staff.getName());
        }
        else if (staff instanceof TicketManager) {
            managers.add(staff);
            totalStaff.add(staff);
            department = "Ticket Management";
            System.out.println("Hired Ticket Manager: " + staff.getName());
        }
    }

    public void hireStaff(Staff staff) {
        if (staff instanceof CockpitCrew) {
            cockpit.add(staff);
            totalStaff.add(staff);
            department = "Cockpit Staff";
            System.out.println("Hired Cockpit Staff: " + staff.getName());

        } else if (staff instanceof FlightAttendants) {
            attendants.add(staff);
            totalStaff.add(staff);
            department = "Attendant Staff";
            System.out.println("Hired Attendant: " + staff.getName());
        }
    }

    public void hireTSA(TSA tsa) {
        System.out.print("TSA: " + tsa.getLocation() + " - " + tsa.getOfficerCount() + " officers");
    }

    public String getDepartment() {
        return department;
    }

    public String getHireDepartment(String department) {
        return department;
    }

    public void displayStaff(Airline airline) {
        System.out.println(airline.getName() + " Staff:");
        for (Staff staff : totalStaff) {
            System.out.println(staff.getInfo());
        }
    }
}