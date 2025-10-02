package Task7;

import java.util.Scanner;

public class EmployeeApp {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Employee Database App ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter department: ");
                    String dept = sc.nextLine();
                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();
                    dao.addEmployee(name, dept, salary);
                    break;

                case 2:
                    dao.viewEmployees();
                    break;

                case 3:
                    System.out.print("Enter Employee ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new department: ");
                    String newDept = sc.nextLine();
                    System.out.print("Enter new salary: ");
                    double newSalary = sc.nextDouble();
                    dao.updateEmployee(uid, newDept, newSalary);
                    break;

                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    int did = sc.nextInt();
                    dao.deleteEmployee(did);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}

