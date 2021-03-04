package JavaBasic;

public class Company {
    private static Company instance = new Company();

    private Company() {

    }

    public static Company getInstance() {
        if (instance == null) {
            instance = new Company();
        }
        return instance;
    }

    public static void main(String[] args) {
        Company company1 = Company.getInstance();
        Company company2 = Company.getInstance();

        System.out.println(company1);
        System.out.println(company2);
    }
}
