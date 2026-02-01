import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;

// Serializable use kiya hai taaki object ko file me save kar sakein
class Employee implements Serializable {
    private String id, name, department, position;
    private double salary;
    private Date joinDate;

    public Employee(String id, String name, String department, String position, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.position = position;
        this.salary = salary;
        this.joinDate = new Date(); // Current date automatically set hogi
    }

    // Getters (Data access karne ke liye)
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return String.format("ID: %-5s | Name: %-15s | Dept: %-10s | Salary: %-8.2f | Date: %s",
                id, name, department, salary, sdf.format(joinDate));
    }
}