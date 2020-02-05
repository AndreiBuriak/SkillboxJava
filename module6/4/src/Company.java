import java.util.*;

public class Company {
    private static int income;

    private int employeesCount = 0;

    private ArrayList<Employee> employees = new ArrayList();

    static int getIncome() {
        return income;
    }

    int getEmployeesCount() {
        return employeesCount;
    }

    public void hire(Employee object) {
        income += object.getEarnedMoneyManager();
        employees.add(object);
        employeesCount += 1;
    }

    void hireAll(String employeeType, int count) {
        switch (employeeType) {
            case "Manager":
                for (int i = 0; i < count; i++) {
                    Manager object = new Manager();
                    employees.add(object);
                    income += object.getEarnedMoneyManager();
                    employeesCount += 1;
                }
                break;
            case "TopManager":
                for (int i = 0; i < count; i++) {
                    employees.add(new TopManager());
                    employeesCount += 1;
                }
                break;
            case "Operator":
                for (int i = 0; i < count; i++) {
                    employees.add(new Operator());
                    employeesCount += 1;
                }
                break;
        }
    }

    void fire(int number) {
        employees.remove(number);
        employeesCount--;
    }

    void getTopSalaryStaff(int count) {

        if (count <= employeesCount & count > 0) {

            ArrayList<Employee> topSalaryList = new ArrayList<>(employees);

            topSalaryList.sort(new TopSalaryComparator());


            for (int i = 0; i < count; i++) {
                System.out.println(i + 1 + ". " + topSalaryList.get(i).getMonthSalary() + " руб.");
            }
        } else
            System.out.println("Список не может быть отображен, так как введено некорректоное количество сотрудников");

    }

    void getLowestSalaryStaff(int count) {

        if (count <= employeesCount & count > 0) {
            ArrayList<Employee> lowestSalaryList = new ArrayList<>(employees);

            lowestSalaryList.sort(new LowestSalaryComparator());

            for (int i = 0; i < count; i++) {
                System.out.println(i + 1 + ". " + lowestSalaryList.get(i).getMonthSalary() + " руб.");
            }
        } else
            System.out.println("Список не может быть отображен, так как введено некорректоное количество сотрудников");

    }

}
