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
        System.out.println("Invalid Office Number! Please Enter Correct Office Number...");
    }
}
