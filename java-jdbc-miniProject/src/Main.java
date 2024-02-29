import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws SQLException {

        EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while (flag)
        {
            System.out.println("******************************");
            System.out.println("Select from the options below");
            System.out.println("******************************");
            System.out.println("Press 1: Add Employee");
            System.out.println("Press 2: Update Employee");
            System.out.println("Press 3: Delete Employee");
            System.out.println("Press 4: Get Employees");
            System.out.println("Press 5: Get Employee by id");
            System.out.println("Press 6: Exit");

            int input = scanner.nextInt();


            switch (input)
            {
                case 1://add employee
                    System.out.println("Enter name:");
                    String name = scanner.next();
                    System.out.println("Enter email:");
                    String email = scanner.next();
                    Employee employee = new Employee();
                    employee.setName(name);
                    employee.setEmail(email);
                    employeeDao.addEmployee(employee);
                    break;

                case 2:
                    Employee employee1 = new Employee();
                    System.out.println("please provide id of record you wish to update");
                    int id = scanner.nextInt();
                    System.out.println("Please enter updated name:");
                    String updatedName = scanner.next();
                    System.out.println("Please Enter updated email:");
                    String updatedEmail = scanner.next();
                    employee1.setEmail(updatedEmail);
                    employee1.setId(id);
                    employee1.setName(updatedName);
                    employeeDao.updateEmployee(employee1);
                    break;

                case 3:
                    System.out.println("Please provide id of the record you wish to delete:");
                    int idDelete = scanner.nextInt();
                    employeeDao.deleteEmployee(idDelete);
                    break;

                case 4:
                    System.out.println("Employee Records: ");
                    System.out.println("| Id  | name | email |");
                    System.out.println(employeeDao.getEmployees());
                    break;

                case 5:
                    System.out.println("Please type Id number of the record you wish to see: ");
                    int idNum = scanner.nextInt();
                    System.out.println(employeeDao.getEmployeeByID(idNum));
                    break;

                case 6:
                    System.out.println("Thank you!");
                    System.out.println("Exiting...");
                    flag = false;
                    break;

                default:
                    System.out.println("Please Choose between 1 - 6");
            }
        }

    }
}