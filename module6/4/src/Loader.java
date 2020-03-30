import java.util.Arrays;
import java.util.List;

public class Loader {
    public static void main(String[] args) {
        Company company = new Company();

        company.hireAll(staffList("Operator", 180, company));
        company.hireAll(staffList("Manager", 80, company));
        company.hireAll(staffList("TopManager", 10, company));

        System.out.println("--------Список самых высоких зарплат до увольнений--------");
        company.getTopSalaryStaff(15);
        System.out.println("--------Список самых низких зарплат до увольнений--------");
        company.getLowestSalaryStaff(30);
        System.out.println(company.getEmployeesCount());

        for (int i = 0; i < company.getEmployeesCount(); i++) {
            company.fire(i);
        }

        System.out.println("--------Список самых высоких зарплат после увольнений--------");
        company.getTopSalaryStaff(15);
        System.out.println("--------Список самых низких зарплат после увольнений--------");
        company.getLowestSalaryStaff(30);

    }
     private static List<Employee> staffList(String employeeType, int staffQuantity, Company company) {
         List<Employee> staff = Arrays.asList(new Employee[staffQuantity]);
        switch (employeeType) {
            case "Manager":
                for (int i = 0; i < staff.size(); i++) {
                    staff.set(i, new Manager(company));
                }
                break;
            case "Operator":
                for (int i = 0; i < staff.size(); i++) {
                    staff.set(i, new Operator(company));
                }
                break;
            case "TopManager":
                for (int i = 0; i < staff.size(); i++) {
                    staff.set(i, new TopManager(company));
                }
                break;
        }
        return staff;
    }
}
