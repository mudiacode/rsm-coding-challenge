import java.util.ArrayList;
import java.util.List;

public class Company {
    static List<Office> offices = new ArrayList<>();

    public static void openOffice(String officeName) {
        Office newOffice = new Office(officeName);
        offices.add(newOffice);
        System.out.println("Opened Office: " + newOffice.getOfficeName() + ", " + newOffice.getOfficeNumber());
    }

    public static void getOffice() {
        for (Office office : offices) {
            System.out.println("office Name: " + office.getOfficeName());
        }
    }
}
