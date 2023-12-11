import java.util.ArrayList;
import java.util.List;

public class Company {
    static List<Office> offices = new ArrayList<>();

    public static void openOffice(String officeName) {
        Office newOffice = new Office(officeName);
        offices.add(newOffice);
        System.out.println("Opened Office: " + newOffice.getOfficeName() + ", " + newOffice.getOfficeNumber());
    }

    public static void getOffice(String officeNumber) {
        for (Office office : offices) {
            if (officeNumber.equals(office.getOfficeNumber())){
                System.out.println("found: " + office.getOfficeName() + " (" + office.getOfficeNumber() + ")");
                return;
            }
        }
        System.out.println("Office number not found");
    }

    public static void addEmployee(String employeeName, String officeNumber){
        for (Office office: offices) {
            if (officeNumber.equals(office.getOfficeNumber())){
                Office.addEmployee(employeeName);
                System.out.println("Added employee " + employeeName + " to office " + office.getOfficeName());
                return;
            }
        }
        System.out.println("Office number not found");
    }

    public static void transferEmployee(String employeeName, String oldOfficeNumber, String newOfficeNumber) {
        boolean oldOfficeFound = false;
        boolean newOfficeFound = false;

        for (Office office : offices) {
            if (oldOfficeNumber.equals(office.getOfficeNumber())) {
                Office.removeEmployee(employeeName);
                oldOfficeFound = true;
            }
            if (newOfficeNumber.equals(office.getOfficeNumber())) {
                Office.addEmployee(employeeName);
                newOfficeFound = true;
                System.out.println("Moved " + employeeName + " to " + office.getOfficeName());
            }
        }

        if (!oldOfficeFound) {
            System.out.println("Old office with number " + oldOfficeNumber + " not found.");
        }

        if (!newOfficeFound) {
            System.out.println("New office with number " + newOfficeNumber + " not found.");
        }
    }
    }

