import java.util.ArrayList;
import java.util.List;

public class Company {
    //store Office objects here

    List<String> Offices;
    Company(){
        this.Offices = new ArrayList<>();
    }
    public static void openOffice(String officeName){
        new Office();
        System.out.println("Office: " + officeName);
    }
}
