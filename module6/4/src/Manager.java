public class Manager implements Employee {
    private int salaryManager;
    private int earnedMoneyManager;

    Manager(Company company) {
        this.earnedMoneyManager = (int) (400000 * Math.random());
        this.salaryManager = (int) (100000 + this.earnedMoneyManager * 0.05);
    }

    public int getEarnedMoneyManager() {
        return earnedMoneyManager;
    }

    @Override
    public int getMonthSalary() {
        return salaryManager;
    }
}
