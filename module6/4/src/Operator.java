public class Operator implements Employee {
    private int salaryOperator;

    Operator() {
        salaryOperator = (int) (50000 + 10000 * Math.random());
    }

    @Override
    public int getMonthSalary() {
        return salaryOperator;
    }

    @Override
    public int getEarnedMoneyManager() {
        return 0;
    }
}
