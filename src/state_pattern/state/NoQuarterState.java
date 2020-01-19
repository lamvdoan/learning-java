package state_pattern.state;

import state_pattern.context.GumballMachine;

public class NoQuarterState extends State {
    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Quarter inserted");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("There is no quarter to eject");
    }

    @Override
    public boolean turnCrank() {
        System.out.println("Nothing happens when turned.");
        return false;
    }

    @Override
    public void dispense() {
        System.out.println("Nothing to dispense");
    }
}
