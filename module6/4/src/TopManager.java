public class TopManager implements Employee {
    private int salaryTopManager;

    TopManager(Company company) {
        int fixSalaryTopManager = (int) (100000 + Math.random() * 30000);
        if ( company.getIncome() >= 10000000) {
            salaryTopManager = (int) (fixSalaryTopManager + 1.5 * fixSalaryTopManager);
        } else this.salaryTopManager = fixSalaryTopManager;

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
