package state_pattern.state;

import state_pattern.context.GumballMachine;

import java.util.Random;

public class HasQuarterState extends State {
    GumballMachine gumballMachine;
    Random randomWinner;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
        randomWinner = new Random(System.currentTimeMillis());
    }

    @Override
    public void insertQuarter() {
        System.out.println("A quarter already exist, can't insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter ejected");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public boolean turnCrank() {
        System.out.println("Crank turned successfully");

        int winner = randomWinner.nextInt(10);

        if (winner == 0 && gumballMachine.getGumballCount() > 1) {
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldState());
        }

        return true;
    }

    @Override
    public void dispense() {
        System.out.println("Nothing to dispense");
    }
}
