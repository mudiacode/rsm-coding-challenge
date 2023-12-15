public class Main {
    public static void main(String[] args) {
        Company.openOffice("RSM");
        Company.openOffice("KFC");

        Company.getOffice(948985);

        Company.addEmployee("Mike", 948985);
        Company.addEmployee("Steve", 948985);
        Company.addEmployee("Jessica", 948985);

        Company.addEmployee("Jake", 764588);
        Company.addEmployee("Tom", 764588);
        Company.addEmployee("Bob", 764588);

        Company.transferEmployee("Jake", 764588, 948985);

        Company.getEmployees(948985);

        Company.addEmployee("Mike", 948985);

        Company.getEmployees(94895);
    }
}