public class Main {
    public static void main(String[] args) {
        Company.openOffice("RSM");
        Company.openOffice("KFC");

        Company.getOffice("604782");

        Company.addEmployee("Mike", "604782");
        Company.addEmployee("Steve", "604782");
        Company.addEmployee("Jessica", "604782");

        Company.addEmployee("Jake", "177450");
        Company.addEmployee("Tom", "177450");
        Company.addEmployee("Bob", "177450");

        Company.transferEmployee("Jake", "177450", "604782");

    }
}