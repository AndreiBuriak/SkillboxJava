package clients;

public class LegalEntity extends Clients {
    public LegalEntity(double money) {
        super(money);
    }

    @Override
    public void withdrawMoney(double writeOffAmount) {
        super.withdrawMoney(writeOffAmount * 1.01);
    }
}
