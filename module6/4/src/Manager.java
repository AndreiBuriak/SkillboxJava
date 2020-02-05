public class Manager implements Employee {
    private int salaryManager;
    private int earnedMoneyManager;

    Manager() {
        earnedMoneyManager = (int) (400000 * Math.random());
        salaryManager = (int) (100000 + earnedMoneyManager * 0.05);
    }

    public int getEarnedMoneyManager() {
        return earnedMoneyManager;
    }

    @Override
    public int getMonthSalary() {
        return salaryManager;
    }
}
