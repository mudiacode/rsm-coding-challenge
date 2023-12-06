public class Main {
    public static void main(String[] args) {

        Office p1 = new Office();
        System.out.println(p1.OfficeNumber);

        Office p2 = new Office();
        System.out.println(p2.OfficeNumber);

        p1.addEmployee("Steve");
        p1.addEmployee("Bob");
        p1.addEmployee("Jesicca");

        p2.addEmployee("Kevin");
        p2.addEmployee("John");
        p2.addEmployee("Christ");
        System.out.println(p1.Employees);
        System.out.println(p2.Employees);
    }
}