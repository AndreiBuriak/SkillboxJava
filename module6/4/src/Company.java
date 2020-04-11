import java.util.*;

public class Company {

    private int income;
    private ArrayList<Employee> employees = new ArrayList();
    private final int companyIncomePlane = 10000000;


    Company() {

        income = 0;
    }

    int getIncome() {
        return income;
    }

    public int getCompanyIncomePlane() {
        return companyIncomePlane;
    }

    public int getEmployeesQuantity() {
        return employees.size();
    }

    public void hire(Employee object) {
        income += object.getEarnedMoney();
        employees.add(object);
    }

    void hireAll(List<Employee> staff) {
        for (int i = 0; i < staff.size(); i++) {
            Employee object = staff.get(i);
            hire(object);
        }
    }

    void fire(int number) {
        if (number < getEmployeesQuantity() & number >= 0) {
            income -= employees.get(number).getEarnedMoney();
            employees.remove(number);
        }
    }

    void getSalaryStaff(int count, Comparator comparator) {
        if (count <= getEmployeesQuantity() & count > 0) {
            ArrayList<Employee> SalaryList = new ArrayList<>(employees);

            SalaryList.sort(comparator);

            for (int i = 0; i < count; i++) {
                System.out.println(i + 1 + ". " + SalaryList.get(i).getMonthSalary() + " руб.");
            }
        } else
            System.out.println("Список не может быть отображен, так как введено некорректоное количество сотрудников");
    }

    void getTopSalaryStaff(int count) {

        getSalaryStaff(count, (Comparator<Employee>) (o1, o2) -> o2.compareTo(o1));
    }

    void getLowestSalaryStaff(int count) {

        getSalaryStaff(count, (Comparator<Employee>) (o1, o2) -> o2.compareToDesc(o1));
    }
}