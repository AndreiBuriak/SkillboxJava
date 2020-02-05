public class TopManager implements Employee {
    private int salaryTopManager;

    TopManager() {
        int fixSalaryTopManager = (int) (100000 + Math.random() * 30000);
        if (Company.getIncome() >= 10000000) {
            salaryTopManager = (int) (fixSalaryTopManager + 1.5 * fixSalaryTopManager);
        } else salaryTopManager = fixSalaryTopManager;
    }

    @Override
    public int getMonthSalary() {
        return salaryTopManager;
    }

    @Override
    public int getEarnedMoneyManager() {
        return 0;
    }
}
