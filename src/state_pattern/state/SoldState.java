package state_pattern.state;

import state_pattern.context.GumballMachine;

public class SoldState extends State {
    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        // Not a valid state
        System.out.println("Please wait, gumball coming out");
    }

    @Override
    public void ejectQuarter() {
        // Not a valid state
        System.out.println("Can't eject, quarter already taken");
    }

    @Override
    public boolean turnCrank() {
        System.out.println("Crank already turned, can't turn it");
        return false;
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();

        if (gumballMachine.getGumballCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}
