public interface Employee {
    int getMonthSalary();

    default int getEarnedMoneyManager() {
        return 0;
    }
}


