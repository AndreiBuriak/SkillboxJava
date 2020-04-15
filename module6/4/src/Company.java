import java.util.*;

class Company {

    private int income;
    int companyIncomePlane = 10000000;
    private ArrayList<Employee> employees = new ArrayList();


    Company() {

        income = 0;
    }

    int getIncome() {
        return income;
    }

    int getCompanyIncomePlane() {
        return companyIncomePlane;
    }

    int getEmployeesQuantity() {
        return employees.size();
    }

    private void hire(Employee object) {
        income += object.getEarnedMoney();
        employees.add(object);
    }

    void hireAll(List<Employee> staff) {
        for (Employee object : staff) {
            hire(object);
        }
    }

    void fire(int number) {
        if (number < getEmployeesQuantity() & number >= 0) {
            income -= employees.get(number).getEarnedMoney();
            employees.remove(number);
        }
    }

    private void getSalaryStaff(int count, Comparator comparator) {
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