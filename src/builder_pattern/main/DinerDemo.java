package builder_pattern.main;

import builder_pattern.diner.Diner;
import builder_pattern.diner.DinerBuilder;

public class DinerDemo {
    public static void main(String[] args) {
        Diner diner = new DinerBuilder()
                .setFirstName("Lam")
                .setLastName("Doan")
                .setPhoneNumber("708-821-0281")
                .setHasSavedCreditCard(false)
                .build();

        diner.printInfo();
    }
}
