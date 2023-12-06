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
}
