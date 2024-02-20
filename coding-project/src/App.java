import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
//    Create new scanner within App class for user input
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
//        Initialises that exit = false as if exit = true then program will close (case 7)
        boolean exit = false;

//        while exit is not false (true) display displayMenu() for user menu options
        while (!exit) {
            displayMenu();

//            Integer variable passed as a switch parameter for scanner to input integers
//            This allows the user to choose switch cases to execute a method
            int choice = getChoice();

//            Switch statement used to execute office and company methods
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
//                    If wrong input is given to any method the program with prompt the user to try again
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

//    displays input options for user
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

//    Returns an integer to scanner parameter to select a case
    private static int getChoice() {
        return scanner.nextInt();
    }

//    calls the openOffice function from the Company class
//    prompts the user to enter office name
    private static void openOffice() {
        System.out.print("Enter office name: ");
        scanner.nextLine();
        String officeName = scanner.nextLine();

//      passes officeName into parameter to check if already used
//      officeName passed as parameter in isOfficeNameTaken to check if office name is taken
//        if taken then user prompted to try another name that isn't taken

        if (isOfficeNameTaken(officeName)) {
            System.out.println("'" + officeName + "' is already taken. Please choose another name.");
        } else {
//            if office name not taken then office is opened with the given office name
            Company.openOffice(officeName);
            System.out.println("'" + officeName + "' opened successfully.");
        }
    }

//    checks office arr if office name is already used
    private static boolean isOfficeNameTaken(String officeName) {
        for (Office office : Company.offices) {
//            if office name is same as user input then it's taken
            if (officeName.equals(office.getOfficeName())) {
                return true;
            }
        }
        return false;
    }

//    User enters employee name
    private static void addEmployee() {
        System.out.print("Enter employee name: ");
        String employeeName = scanner.next();

//        variable to List available offices that has been opened by user
        List<Office> availableOffices = Company.offices;

//        Prints all available offices if opened
        if (!availableOffices.isEmpty()) {
            System.out.println("Available Offices:");
            for (Office office : availableOffices) {
                System.out.println("Office " + office.getOfficeNumber() + ": " + office.getOfficeName());
            }
//        Informs user to open offices if none are opened
        } else {
            System.out.println("No offices available. Please open an office first.");
            return;
        }

//        Variable to list all employees in an office
        List<Office> employeeOffices = getEmployeeOffices(employeeName);

//        Prints existing employees if employee name matches an employee in an existing office
        if (!employeeOffices.isEmpty()) {
            System.out.println("Employee '" + employeeName + "' is already present in the following offices:");
            for (Office office : employeeOffices) {
                System.out.println("Office " + office.getOfficeNumber() + ": " + office.getOfficeName());
            }
//            Informs user that the employee name isn't present in any office
        } else {
            System.out.println("Employee '" + employeeName + "' is not present in any office.");
        }

//        User enters office number
        System.out.print("Enter office number: ");
        int officeNumber = scanner.nextInt();

//      Success upon employee name not matching an employee with the same name and office number
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

//TODO: Comment on code
//TODO: Get rid of white spaces when user enters information