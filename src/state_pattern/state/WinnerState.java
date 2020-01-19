package state_pattern.state;

import state_pattern.context.GumballMachine;

public class WinnerState extends State {
    GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
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
        System.out.println("You're a WINNER!  2 Gumballs for you!");
        gumballMachine.releaseBall();
        gumballMachine.releaseBall();

        if (gumballMachine.getGumballCount() == 0) {
            gumballMachine.setState(gumballMachine.getSoldOutState());
        } else {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        }
    }
}
