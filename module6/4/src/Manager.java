public class Manager implements Employee {
    private int salaryManager;
    private int earnedMoneyManager;

    Manager() {
        this.earnedMoneyManager = (int) (400000 * Math.random());
        this.salaryManager = (int) (100000 + this.earnedMoneyManager * 0.05);
    }

    @Override
    public int getMonthSalary() {
        return salaryManager;
    }

    @Override
    public int getEarnedMoney() {
        return earnedMoneyManager;
    }
}
