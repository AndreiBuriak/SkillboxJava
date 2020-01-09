package clients;

public abstract class Clients {
    private double money;

    Clients(double money) {
        if (isBalancePositive(money)) {
            this.money = money;
        }
    }

    private double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        if (isBalancePositive(money)) {
            this.money = money;
        }
    }

    public void getBalance() {
        System.out.println(getMoney());
    }

    public void replenishBalance(double replenishmentAmount) {
        if (replenishmentAmount < 0) {
            System.out.println("Сумма введена некоррректно");
        } else {
            money += replenishmentAmount;
            System.out.println("Баланс счета пополнен на " + replenishmentAmount);
        }
    }

    public void withdrawMoney(double writeOffAmount) {
        if (writeOffAmount < 0) {
            System.out.println("Сумма введена некоррректно");
        } else {
            if (money < writeOffAmount) {
                System.out.println("Недостаточно средств для списания");
            } else {
                money -= writeOffAmount;
                System.out.println("Со счета списано " + writeOffAmount);
            }
        }
    }

    private boolean isBalancePositive(double money) {
        return !(money < 0.0);
    }

    public boolean transferTo(Clients from, double amount) {
        double moneyBefore = from.getMoney();
        from.withdrawMoney(amount);
        double moneyAfter = from.getMoney();
        double moneyDifference = moneyBefore - moneyAfter;
        if ((moneyDifference) == 0) {
            return false;
        } else if (moneyDifference != amount) {
            replenishBalance(amount);
            return true;
        } else {
            replenishBalance(moneyDifference);
            return true;
        }
    }
}

