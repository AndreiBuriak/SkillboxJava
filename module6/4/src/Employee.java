public interface Employee extends Comparable{
    int getMonthSalary();

    default int getEarnedMoney() {
        return 0;
    }

    @Override
    default int compareTo(Object o) {
        return Integer.compare(getMonthSalary(), ((Employee)o).getMonthSalary());
    }

    default int compareToDesc(Object o) {
        return -1 * compareTo(o);
    }
}