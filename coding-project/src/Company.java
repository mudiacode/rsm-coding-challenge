import java.util.ArrayList;
import java.util.List;

public class Company {
    static List<Office> offices = new ArrayList<>();

    public static void openOffice(String officeName) {
        Office newOffice = new Office(officeName);
        offices.add(newOffice);
        System.out.println("Opened Office: " + newOffice.getOfficeName() + ", " + newOffice.getOfficeNumber());
    }

    public static void getOffice(Integer officeNumber) {
        for (Office office : offices) {
            if (officeNumber.equals(office.getOfficeNumber())){
                System.out.println("found: " + office.getOfficeName() + " (" + office.getOfficeNumber() + ")");
                return;
            }
        }
        System.out.println("Office number not found");
    }

    public static void addEmployee(String employeeName, Integer officeNumber){
        for (Office office: offices) {
            if (officeNumber.equals(office.getOfficeNumber())){
                office.addEmployee(employeeName);
                System.out.println("Added employee " + employeeName + " to office " + office.getOfficeName());
                return;
            }
        }
        System.out.println("Office number not found");
    }

    public static void transferEmployee(String employeeName, Integer oldOfficeNumber, Integer newOfficeNumber) {
        boolean oldOffice= false;
        boolean newOffice= false;

        for (Office office : offices) {
            if (oldOfficeNumber.equals(office.getOfficeNumber())) {
                office.removeEmployee(employeeName);
                oldOffice= true;
            }
            if (newOfficeNumber.equals(office.getOfficeNumber())) {
                office.addEmployee(employeeName);
                newOffice= true;
                System.out.println("Moved " + employeeName + " to " + office.getOfficeName());
            }
        }

        if (!oldOffice) {
            System.out.println(oldOfficeNumber + " not found.");
        }

        if (!newOffice) {
            System.out.println(newOfficeNumber + " not found.");
        }
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