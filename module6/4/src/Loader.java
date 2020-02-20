public class Loader {
    public static void main(String[] args) {
        Company company = new Company();


        company.hireAll("Operator", 180, company);
        company.hireAll("Manager", 80, company);
        company.hireAll("TopManager", 10, company);

        System.out.println("--------Список самых высоких зарплат до увольнений--------");
        company.getTopSalaryStaff(15);
        System.out.println("--------Список самых низких зарплат до увольнений--------");
        company.getLowestSalaryStaff(30);

        for (int i = 0; i < company.getEmployeesCount(); i++) {
            company.fire(i);
        }

        System.out.println("--------Список самых высоких зарплат после увольнений--------");
        company.getTopSalaryStaff(15);
        System.out.println("--------Список самых низких зарплат после увольнений--------");
        company.getLowestSalaryStaff(30);


    }
}
