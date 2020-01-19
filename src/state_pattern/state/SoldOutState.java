package state_pattern.state;

import state_pattern.context.GumballMachine;

public class SoldOutState extends State {
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Quarter inserted, but not recommended");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("There is no quarter to eject");
    }

    @Override
    public boolean turnCrank() {
        System.out.println("Crank didn't turn due to no more gumballs");
        return false;
    }

    @Override
    public void dispense() {
        System.out.println("Nothing to dispense");
    }
}
