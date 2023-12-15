import java.util.ArrayList;
import java.util.List;

public class Office {
    private final Integer officeNumber;
    private final String officeName;
    private final List<String> employees;

    public Office(String officeName) {
        this.officeNumber = UniqueIdentifier.generateUniqueIdentifier();
        this.officeName = officeName;
        this.employees = new ArrayList<>();
    }

    public Integer getOfficeNumber() {
        return officeNumber;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void addEmployee(String employeeName) {
        employees.add(employeeName);
    }

    public void removeEmployee(String employeeName) {
        if (existEmployee(employeeName)) {
            employees.remove(employeeName);
            System.out.println("Removed " + employeeName + " from " + officeName);
        } else {
            System.out.println(employeeName + " not found in " + officeName);
        }
    }

    public boolean existEmployee(String employeeName) {
        return employees.contains(employeeName);
    }

    public ArrayList<String> getEmployees() {
        System.out.println("Employees in " + officeName + ": " + employees);
            return new ArrayList<>(employees);
    }


}
