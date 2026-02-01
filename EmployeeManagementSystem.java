import java.util.*;
import java.io.*;

public class EmployeeManagementSystem {
    // 1. ArrayList: Saare employees ki list rakhne ke liye
    private List<Employee> employees = new ArrayList<>();
    // 2. HashMap: ID se turant search karne ke liye (Photos me yahi requirement thi)
    private Map<String, Employee> employeeMap = new HashMap<>();
    
    private final String DATA_FILE = "employees.dat";
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        EmployeeManagementSystem app = new EmployeeManagementSystem();
        app.loadEmployeesFromFile(); // Program start hote hi purana data load karega
        app.mainMenu();
    }

    public void mainMenu() {
        while (true) {
            System.out.println("\n--- The Developers Arena: Intern Project ---");
            System.out.println("1. Add Employee\n2. Display All\n3. Search (ID/Name)\n4. Salary Reports\n5. Save & Exit");
            System.out.print("Choice choose karein: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": addEmployee(); break;
                case "2": displayAll(); break;
                case "3": searchMenu(); break;
                case "4": generateReports(); break;
                case "5": saveToFile(); System.exit(0);
                default: System.out.println("Invalid choice, try again!");
            }
        }
    }

    // Naya employee add karne ka logic (Photo 1000030978 reference)
    private void addEmployee() {
        System.out.print("Enter ID: "); String id = scanner.nextLine();
        if(employeeMap.containsKey(id)) {
            System.out.println("Error: Ye ID pahle se exist karti hai!");
            return;
        }
        System.out.print("Enter Name: "); String name = scanner.nextLine();
        System.out.print("Enter Dept: "); String dept = scanner.nextLine();
        System.out.print("Enter Position: "); String pos = scanner.nextLine();
        
        double salary = 0;
        try {
            System.out.print("Enter Salary: ");
            salary = Double.parseDouble(scanner.nextLine());
        } catch (Exception e) { System.out.println("Invalid salary! Default 0 set."); }

        Employee emp = new Employee(id, name, dept, pos, salary);
        employees.add(emp);
        employeeMap.put(id, emp);
        System.out.println("✅ Employee added successfully!");
    }

    private void displayAll() {
        if (employees.isEmpty()) System.out.println("List khali hai.");
        else employees.forEach(System.out::println);
    }

    private void searchMenu() {
        System.out.print("Enter ID to Search: ");
        String id = scanner.nextLine();
        Employee e = employeeMap.get(id); // HashMap fast lookup
        System.out.println(e != null ? e : "Employee nahi mila.");
    }

    // Reports functionality (Photos ki advanced requirement)
    private void generateReports() {
        if(employees.isEmpty()) return;
        double total = 0;
        for(Employee e : employees) total += e.getSalary();
        System.out.println("Total Monthly Payout: " + total);
        System.out.println("Average Salary: " + (total/employees.size()));
    }

    // Data Save karne ke liye (Photo 1000030982 reference)
    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(employees);
            System.out.println("Data saved successfully in " + DATA_FILE);
        } catch (IOException e) { System.out.println("Error saving: " + e.getMessage()); }
    }

    private void loadEmployeesFromFile() {
        File file = new File(DATA_FILE);
        if (!file.exists()) return;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            employees = (ArrayList<Employee>) ois.readObject();
            for (Employee e : employees) employeeMap.put(e.getId(), e);
            System.out.println("Loaded " + employees.size() + " records from file.");
        } catch (Exception e) { System.out.println("File load karne me error."); }
    }
}