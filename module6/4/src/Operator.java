public class Operator implements Employee {
    private int salaryOperator;

    Operator() {
        this.salaryOperator = (int) (50000 + 10000 * Math.random());
    }

    @Override
    public int getMonthSalary() {
        return salaryOperator;
    }

}
