import java.util.ArrayList;
import java.util.List;

public class Office {
    static String OfficeNumber;
    String OfficeName;

    List<String> Employees;

    Office() {
        OfficeNumber = UniqueIdentifierGenerator.generateUniqueIdentifier();
        this.Employees = new ArrayList<>();
    }

    void addEmployee(String employeeName){
        Employees.add(employeeName);
    }

    void removeEmployee(String employeeName){
        Employees.remove(employeeName);
    }
}