import java.util.ArrayList;
import java.util.List;

public class Office {
    public static String officeNumber;
    private static String officeName;
    private List<String> employees;

    Office() {
        this.officeNumber = UniqueIdentifierGenerator.generateUniqueIdentifier();
        this.employees = new ArrayList<>();
    }

    public static String getOfficeNumber() {
        return officeNumber;
    }

    public static String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public void addEmployee(String employeeName) {
        employees.add(employeeName);
    }

    public void removeEmployee(String employeeName) {
        employees.remove(employeeName);
    }

    public void getEmployees() {
        System.out.println(employees);
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }
}
