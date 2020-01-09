package clients;

public class IndividualEntrepreneur extends Clients {
    public IndividualEntrepreneur(double money) {
        super(money);
    }

    @Override
    public void replenishBalance(double replenishmentAmount) {
        if (replenishmentAmount < 1000) {
            super.replenishBalance(replenishmentAmount * 0.99);
        } else super.replenishBalance(replenishmentAmount * 0.995);
    }
}
