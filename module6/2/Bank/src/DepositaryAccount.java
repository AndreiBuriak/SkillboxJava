import java.time.LocalDate;

public class DepositaryAccount extends PaymentAccount {
    private LocalDate replenishDate = LocalDate.now();

    DepositaryAccount(double money) {
        super(money);
    }

    @Override
    public void replenishBalance(double replenishmentAmount) {
        super.replenishBalance(replenishmentAmount);
        replenishDate = LocalDate.now().plusMonths(1);
    }

    @Override
    public void withdrawMoney(double writeOffAmount) {
        LocalDate withdrawDate = LocalDate.now();
        if (withdrawDate.isAfter(replenishDate)) {
            super.withdrawMoney(writeOffAmount);
        } else System.out.println("Списание со счета невозможно!");
    }
}
