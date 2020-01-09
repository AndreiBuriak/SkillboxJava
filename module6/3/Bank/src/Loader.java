import clients.Clients;
import clients.IndividualEntrepreneur;
import clients.LegalEntity;
import clients.NaturalPerson;

public class Loader {
    public static void main(String[] args) {
        Clients person = new NaturalPerson(2500);
        person.getBalance();

        Clients indEnt = new IndividualEntrepreneur(1000);
        indEnt.replenishBalance(100);
        indEnt.replenishBalance(500);
        indEnt.getBalance();

        Clients legEnt = new LegalEntity(1000);
        legEnt.withdrawMoney(100);
        legEnt.getBalance();

        System.out.println(indEnt.transferTo(legEnt, 100));

        indEnt.getBalance();
        legEnt.getBalance();
    }
}
