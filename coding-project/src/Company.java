import java.util.ArrayList;
import java.util.List;

public class Company {
    // Store Office objects here
    static List<Office> offices = new ArrayList<>();

    public static void openOffice(String officeName) {
        Office newOffice = new Office();
        newOffice.setOfficeName(officeName);
        newOffice.setOfficeNumber(Office.officeNumber);
        offices.add(newOffice);
        System.out.println("Opened Office: " + newOffice.getOfficeName() + ", " + newOffice.getOfficeNumber());
    }

    public static String getOfficeNumber(){
        return Office.getOfficeNumber();
    }

    public static String getOfficeName(){
        return Office.getOfficeName();
    }
    public static void getOffice(String officeNumber) {
        for (Office office : offices) {
            if (officeNumber.equals(getOfficeNumber())) {
                System.out.println("Found Office: " + getOfficeName());
                return; // Assuming you want to stop searching after finding the office
            }
        }
        System.out.println("Office with number " + officeNumber + " not found");
    }
}

