import java.util.ArrayList;
import java.util.List;

public class Office {
    private final String officeNumber;
    private String officeName;
    private static List<String> employees;

    public Office(String officeName) {
        this.officeNumber = UniqueIdentifierGenerator.generateUniqueIdentifier();
        this.officeName = officeName;
        employees = new ArrayList<>();
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public static void addEmployee(String employeeName) {
        employees.add(employeeName);
    }

    public static void removeEmployee(String employeeName) {
        employees.remove(employeeName);
    }

    public void getEmployees() {
        System.out.println(employees);
    }
}