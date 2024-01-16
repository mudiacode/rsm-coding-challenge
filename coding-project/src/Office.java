// java.util package for ArrayList and List
import java.util.ArrayList;
import java.util.List;

// create Office class to store attributes and methods for offices created
public class Office {

    // attributes for offices
    // private -> modifier that makes an attribute or method only be used within the class
    // final -> modifier that makes variables unable to be changed
    private final Integer officeNumber;
    private final String officeName;
    private final List<String> employees;

    // encapsulation
    // this ->
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

    public void getEmployees() {
        System.out.println("Employees in " + officeName + ": " + employees);
    }
}
