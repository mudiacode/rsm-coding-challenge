import java.util.ArrayList;
import java.util.List;

public class Company {
//    list of offices
    static List<Office> offices = new ArrayList<>();

//    Method creates and adds a new office to offices arr
    public static void openOffice(String officeName) {
        Office newOffice = new Office(officeName);
        offices.add(newOffice);
//    Prints office name and office number when inputted by user
        System.out.println("Opened Office: " + newOffice.getOfficeName() + ", " + newOffice.getOfficeNumber());
    }

//    loops through offices arr to check if office matches officeNumber (inputted by user)
    public static boolean addEmployee(String employeeName, Integer officeNumber) {
        for (Office office : offices) {
            // if office
            if (officeNumber.equals(office.getOfficeNumber())) {
                if (office.existEmployee(employeeName)) {
                    System.out.println(employeeName + " already exists in " + office.getOfficeName());
                    return false;
                } else {
                    office.addEmployee(employeeName);
                    System.out.println("Added " + employeeName + " to " + office.getOfficeName());
                    return true;
                }
            }
        }
        System.out.println("Office number not found");
        return false;
    }

    public static boolean removeEmployee(String employeeName, Integer officeNumber) {
        for (Office office : offices) {
            if (officeNumber.equals(office.getOfficeNumber())) {
                if (office.existEmployee(employeeName)) {
                    office.removeEmployee(employeeName);
                    System.out.println("Removed " + employeeName + " from " + office.getOfficeName());
                    return true;
                } else {
                    System.out.println(employeeName + " not found in " + office.getOfficeName());
                    return false;
                }
            }
        }
        System.out.println("Office number not found");
        return false;
    }

    public static boolean transferEmployee(String employeeName, Integer oldOfficeNumber, Integer newOfficeNumber) {
        boolean oldOffice = false;

        for (Office office : offices) {
            if (oldOfficeNumber.equals(office.getOfficeNumber())) {
                if (office.existEmployee(employeeName)) {
                    office.removeEmployee(employeeName);
                    oldOffice = true;
                } else {
                    System.out.println(employeeName + " not found in " + office.getOfficeName());
                    return false;
                }
            }

            if (newOfficeNumber.equals(office.getOfficeNumber())) {
                if (office.existEmployee(employeeName)) {
                    System.out.println(employeeName + " already exists " + office.getOfficeName());
                    return false;
                } else {
                    office.addEmployee(employeeName);
                    System.out.println("Moved " + employeeName + " to " + office.getOfficeName());
                    return true;
                }
            }
        }

        if (!oldOffice) {
            System.out.println(oldOfficeNumber + " not found.");
        }

        System.out.println(newOfficeNumber + " not found.");

        return false;
    }
    public static void getEmployees(Integer officeNumber) {
        for (Office office : offices) {
            if (officeNumber.equals(office.getOfficeNumber())) {
                office.getEmployees();
                return;
            }
        }
        System.out.println("Office number not found");
    }
}
