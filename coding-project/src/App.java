import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            displayMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    openOffice();
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    removeEmployee();
                    break;
                case 4:
                    transferEmployee();
                    break;
                case 5:
                    getEmployees();
                    break;
                case 6:
                    showAvailableOffices();
                    break;
                case 7:
                    exit = true;
                    System.out.println("Closing Program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("-=-=-=-=-=- MSR MANAGEMENT SYSTEM -=-=-=-=-=-");
        System.out.println("1. Open Office");
        System.out.println("2. Add Employee");
        System.out.println("3. Remove Employee");
        System.out.println("4. Transfer Employee");
        System.out.println("5. Get Employees in Office");
        System.out.println("6. Show Available Offices");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getChoice() {
        return scanner.nextInt();
    }

    private static void openOffice() {
        System.out.print("Enter office name: ");
        scanner.nextLine();
        String officeName = scanner.nextLine();

        if (isOfficeNameTaken(officeName)) {
            System.out.println("'" + officeName + "' is already taken. Please choose another name.");
        } else {
            Company.openOffice(officeName);
            System.out.println("'" + officeName + "' opened successfully.");
        }
    }

    private static boolean isOfficeNameTaken(String officeName) {
        for (Office office : Company.offices) {
            if (officeName.equalsIgnoreCase(office.getOfficeName())) {
                return true;
            }
        }
        return false;
    }

    private static void addEmployee() {
        System.out.print("Enter employee name: ");
        String employeeName = scanner.next();

        List<Office> availableOffices = Company.offices;

        if (!availableOffices.isEmpty()) {
            System.out.println("Available Offices:");
            for (Office office : availableOffices) {
                System.out.println("Office " + office.getOfficeNumber() + ": " + office.getOfficeName());
            }
        } else {
            System.out.println("No offices available. Please open an office first.");
            return;
        }

        List<Office> employeeOffices = getEmployeeOffices(employeeName);

        if (!employeeOffices.isEmpty()) {
            System.out.println("Employee '" + employeeName + "' is already present in the following offices:");
            for (Office office : employeeOffices) {
                System.out.println("Office " + office.getOfficeNumber() + ": " + office.getOfficeName());
            }
        } else {
            System.out.println("Employee '" + employeeName + "' is not present in any office.");
        }

        System.out.print("Enter office number: ");
        int officeNumber = scanner.nextInt();

        boolean result = Company.addEmployee(employeeName, officeNumber);
        if (result) {
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Failed to add employee. Please try again...");
        }
    }

    private static List<Office> getEmployeeOffices(String employeeName) {
        List<Office> employeeOffices = new ArrayList<>();
        for (Office office : Company.offices) {
            if (office.existEmployee(employeeName)) {
                employeeOffices.add(office);
            }
        }
        return employeeOffices;
    }

    private static void removeEmployee() {
        System.out.print("Enter employee name: ");
        String employeeName = scanner.next();
        System.out.print("Enter office number: ");
        int officeNumber = scanner.nextInt();
        boolean result = Company.removeEmployee(employeeName, officeNumber);
        if (result) {
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Failed to remove employee. Please try again...");
        }
    }

    private static void transferEmployee() {
        System.out.print("Enter employee name: ");
        String employeeName = scanner.next();
        System.out.print("Enter old office number: ");
        int oldOfficeNumber = scanner.nextInt();
        System.out.print("Enter new office number: ");
        int newOfficeNumber = scanner.nextInt();
        boolean result = Company.transferEmployee(employeeName, oldOfficeNumber, newOfficeNumber);
        if (result) {
            System.out.println("Employee transferred successfully.");
        } else {
            System.out.println("Failed to transfer employee. Please try again...");
        }
    }

    private static void getEmployees() {
        System.out.print("Enter the office number: ");
        int officeNumber = scanner.nextInt();
        Company.getEmployees(officeNumber);
    }

    private static void showAvailableOffices() {
        System.out.println("Available Offices:");
        for (Office office : Company.offices) {
            System.out.println("Office " + office.getOfficeNumber() + ": " + office.getOfficeName());
        }
    }
}
