class CardAccount extends PaymentAccount {

    CardAccount(double money) {
        super(money);
    }

    @Override
    public void withdrawMoney(double writeOffAmount) {
        super.withdrawMoney(writeOffAmount * 1.01);
    }
}
