//Bryndon Hinton on 3/31/2026
import java.util.ArrayList;

/**
 * The Staff class represents an individual staff member working for an airline. It contains information
 * about the staff member's name, age, staff ID, email, work number, and department. The class also provides
 * a method to retrieve the staff member's information.
 */
public class Staff {
    private String name;
    private int age;
    private int staffID;
    private String email;
    private String workNumber;
    private String department;
    private int salary;

   /**
    * Constructor for the Staff class.
    * @param name
    * @param age
    * @param staffID
    * @param email
    * @param workNumber
    * @param department
    * @param totalStaffList
    */
    public Staff(String name, int age, int staffID, String email, String workNumber, String department, int salary) {
        this.name = name;
        this.age = age;
        this.staffID = staffID;
        this.email = email;
        this.workNumber = workNumber;
        this.salary = salary;
        this.department = department;
    }

    public String getInfo() {
        return "Department: " + department + " - Name: " + name + " - Age: " + age + " - Staff ID: " + staffID + " - Email: " + email + " - Work Number: " + workNumber + " - Salary: $" + salary;
    }

    /**
     * Gets the name of the staff member.
     * @return name
     */
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getStaffID() {
        return staffID;
    }

    public String getEmail() {
        return email;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    /**
     * Gets the name of the staff member.
     * @return department
     */
    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }
}
