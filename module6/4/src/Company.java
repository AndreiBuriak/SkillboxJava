import java.util.*;

public class Company {

    private int income;
    private int employeesCount = 0;
    private ArrayList<Employee> employees = new ArrayList();

    Company() {
        income = 0;
    }

    int getIncome() {
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

    void hireAll(List<Employee> staff) {
        for (int i = 0; i < staff.size(); i++) {
            Employee object = staff.get(i);
            employees.add(object);
            income += object.getEarnedMoneyManager();
            employeesCount += 1;
        }
    }

    void fire(int number) {
        employees.remove(number);
        income -= employees.get(number).getEarnedMoneyManager();
        employeesCount--;
    }

    void getSalaryStaff(int count, Comparator comparator) {
        if (count <= employeesCount & count > 0) {
            ArrayList<Employee> SalaryList = new ArrayList<>(employees);

            SalaryList.sort(comparator);

            for (int i = 0; i < count; i++) {
                System.out.println(i + 1 + ". " + SalaryList.get(i).getMonthSalary() + " руб.");
            }
        } else
            System.out.println("Список не может быть отображен, так как введено некорректоное количество сотрудников");
    }

    void getTopSalaryStaff(int count) {

        getSalaryStaff(count, (Comparator<Employee>) (o1, o2) -> Integer.compare(o2.getMonthSalary(), o1.getMonthSalary()));
    }

    void getLowestSalaryStaff(int count) {

        getSalaryStaff(count, (Comparator<Employee>) (o1, o2) -> Integer.compare(o1.getMonthSalary(), o2.getMonthSalary()));
    }
}