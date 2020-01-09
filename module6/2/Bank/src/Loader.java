public class Loader {
    public static void main(String[] args) {
        PaymentAccount account = new PaymentAccount(1000);
        account.getBalance();
        account.withdrawMoney(200);
        account.getBalance();
        account.replenishBalance(150);
        account.getBalance();

        CardAccount card = new CardAccount(2000.00);
        card.withdrawMoney(200);
        card.getBalance();
        card.replenishBalance(200);
        card.getBalance();

        DepositaryAccount dep = new DepositaryAccount(3000);
        dep.getBalance();

        DepositaryAccount dep2 = new DepositaryAccount(3100);
        dep2.getBalance();

        System.out.println(account.transferTo(card, 100));
    }
}
