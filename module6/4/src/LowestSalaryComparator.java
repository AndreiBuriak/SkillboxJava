import java.util.Comparator;

public class LowestSalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getMonthSalary(), o2.getMonthSalary());

    }
}