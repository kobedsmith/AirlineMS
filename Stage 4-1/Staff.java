/**
 *
 * @author Bryndon Hinton
 */
public class Staff {
    private String name;
    private int age;
    private int staffID;
    private String email;
    private String workNumber;
    private String department;
    private int salary;
    
    public Staff() {
        this.name = "";
        this.age = 0;
        this.staffID = 0;
        this.email = "";
        this.workNumber = "";
        this.department = "";
        this.salary = 0;
    }
    
    public Staff(String name, int age, int staffID, String email, String workNumber, String department, int salary) {
        this.name = name;
        this.age = age;
        this.staffID = staffID;
        this.email = email;
        this.workNumber = workNumber;
        this.department = department;
        this.salary = salary;
    }
    
    public String getInfo() {
        return "Staff: " + this.name
                + " - Age: " + this.age
                + " - Staff ID: " + this.staffID
                + " - Email: " + this.email
                + " - Work Number: " + this.workNumber
                + " - Department: " + this.department
                + " - Salary: " + this.salary;
    }
    
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
    
    public String getDepartment() {
        return department;
    }
    
    public int getSalary() {
        return salary;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }
    
    public void setWorkNum(String workNum) {
        this.workNumber = workNum;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    @Override
    public String toString() {
        return getInfo();
    }
}
