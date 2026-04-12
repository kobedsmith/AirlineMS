//Kobe Smith on 3/31/2026
import java.util.ArrayList;

public class HumanResources {
    private ArrayList<Staff> totalStaff = new ArrayList<>();
    private ArrayList<Staff> managers = new ArrayList<>();
    private ArrayList<Staff> cockpit = new ArrayList<>();
    private ArrayList<Staff> attendants = new ArrayList<>();
    private String name;
    private int staffID;
    private String email;
    private String workNumber;
    private String department;
    private int salary;

    public HumanResources(String department, String name, int staffID, String email, String workNumber, int salary) {
        this.department = department;
        this.name = name;
        this.staffID = staffID;
        this.email = email;
        this.workNumber = workNumber;
        this.salary = salary;
    }

    public HumanResources() {
        this.department = "Human Resources";
        this.name = "Default HR";
        this.staffID = 0;
        this.email = "default@hr.com";
        this.workNumber = "000-000-0000";
        this.salary = 0;
    }

    public String getInfo() {
        return "Human Resources Department: " + this.name + " - Staff ID: " + this.staffID + " - Email: " + this.email + " - Work Number: " + this.workNumber + " - Salary: " + this.salary;
    }

    public String getName() {
        return name;
    }

    public int getStaffID() {
        return staffID;
    }

    public String getDepartment() {
        return department;
    }

    public String getHireDepartment(String department) {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public AircraftManager hireAircraftManager(String name, int age, int staffID, String email, String workNumber, int salary) {
        AircraftManager aircraftManager = new AircraftManager(name, age, staffID, email, workNumber, "Aircraft Management", salary);
        managers.add(aircraftManager);
        totalStaff.add(aircraftManager);
        System.out.println("Hired Aircraft Manager: " + aircraftManager.getName());
        return aircraftManager;
    }

    public FlightManager hireFlightManager(String name, int age, int staffID, String email, String workNumber, int salary) {
        FlightManager flightManager = new FlightManager(name, age, staffID, email, workNumber, "Flight Management", salary);
        managers.add(flightManager);
        totalStaff.add(flightManager);
        System.out.println("Hired Flight Manager: " + flightManager.getName());
        return flightManager;
    }

    public PaymentProcessor hirePaymentProcessor(String name, int age, int staffID, String email, String workNumber, int salary) {
        PaymentProcessor paymentProcessor = new PaymentProcessor(name, age, staffID, email, workNumber, "Payment Processing", salary);
        managers.add(paymentProcessor);
        totalStaff.add(paymentProcessor);
        System.out.println("Hired Payment Processor: " + paymentProcessor.getName());
        return paymentProcessor;
    }

    public TicketManager hireTicketManager(String name, int age, int staffID, String email, String workNumber, int salary) {
        TicketManager ticketManager = new TicketManager(name, age, staffID, email, workNumber, "Ticket Management", salary);
        managers.add(ticketManager);
        totalStaff.add(ticketManager);
        System.out.println("Hired Ticket Manager: " + ticketManager.getName());
        return ticketManager;
    }

    public Staff hireGeneralStaff(String name, int age, int staffID, String email, String workNumber, int salary) {
        Staff generalStaff = new Staff(name, age, staffID, email, workNumber, "General Staff", salary);
        totalStaff.add(generalStaff);
        System.out.println("Hired General Staff: " + generalStaff.getName());
        return generalStaff;
    }

    public CockpitCrew hireCockpitCrew(String name, int age, int staffID, String email, String workNumber, int salary) {
        CockpitCrew cockpitCrew = new CockpitCrew(name, age, staffID, email, workNumber, "Cockpit Crew", salary);
        cockpit.add(cockpitCrew);
        totalStaff.add(cockpitCrew);
        System.out.println("Hired Cockpit Crew: " + cockpitCrew.getName());
        return cockpitCrew;
    }

    public FlightAttendants hireFlightAttendant(String name, int age, int staffID, String email, String workNumber, int salary) {
        FlightAttendants flightAttendant = new FlightAttendants(name, age, staffID, email, workNumber, "Flight Attendant", salary);
        attendants.add(flightAttendant);
        totalStaff.add(flightAttendant);
        System.out.println("Hired Flight Attendant: " + flightAttendant.getName());
        return flightAttendant;
    }
    
    public void hireTSA(Airline airline, String location, int officerCount) {
        TSA airportTSA = new TSA(location, officerCount);
        System.out.println(airportTSA.getOfficerCount() + " TSA officers have been assigned to: " + airline.getName());
    }

    public void fireStaff(int staffID) {
        Staff staffToFire = null;
        for (Staff staff : totalStaff) {
            if (staff.getStaffID() == staffID) {
                staffToFire = staff;
                break;
            }
        }
        if (staffToFire != null) {
            totalStaff.remove(staffToFire);
            managers.remove(staffToFire);
            cockpit.remove(staffToFire);
            attendants.remove(staffToFire);
            System.out.println("Fired Staff: " + staffToFire.getName());
        } else {
            System.out.println("Staff with ID " + staffID + " not found.");
        }
    }

    public Staff findStaffByID(int staffID, UserLog userLog) {
        for (Staff staff : userLog.getStaffLog()) {
            if (staff.getStaffID() == staffID) {
                return staff;
            }
        }
        System.out.println("Staff with ID " + staffID + " not found.");
        return null;
    }

    public void addToStaffList(Staff staff) {
        totalStaff.add(staff);
    }

    public void removeFromStaffList(Staff staff) {
        totalStaff.remove(staff);
    }

    public void addToManagersList(Staff staff) {
        managers.add(staff);
    }

    public void removeFromManagersList(Staff staff) {
        managers.remove(staff);
    }

    public void addToCockpitList(Staff staff) {
        cockpit.add(staff);
    }

    public void removeFromCockpitList(Staff staff) {
        cockpit.remove(staff);
    }

    public void addToAttendantsList(Staff staff) {
        attendants.add(staff);
    }

    public void removeFromAttendantsList(Staff staff) {
        attendants.remove(staff);
    }

    public void displayStaff(Airline airline) {
        System.out.println(airline.getName() + " Staff:");
        for (Staff staff : totalStaff) {
            System.out.println(staff.getInfo());
        }
    }
}