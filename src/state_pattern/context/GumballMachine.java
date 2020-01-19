package state_pattern.context;

import state_pattern.state.*;

public class GumballMachine {
    private State noQuarterState;
    private State hasQuarterState;
    private State soldState;
    private State soldOutState;
    private State winnerState;

    private State state;
    private boolean isCrankTurned;
    private int gumballCount;

    public GumballMachine(int gumballCount) {
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);
        winnerState = new WinnerState(this);

        this.gumballCount = gumballCount;
        isCrankTurned = false;

        if (this.gumballCount > 0) {
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        this.isCrankTurned = state.turnCrank();

        if (this.isCrankTurned) {
            state.dispense();
        }
    }

    public void releaseBall() {
        System.out.println("Gumball released");
        gumballCount--;
    }

    public int getGumballCount() {
        return gumballCount;
    }

    public void refill(int gumballCount) {
        this.gumballCount+= gumballCount;
        System.out.println("\nRefilled gumball to: " + this.gumballCount);

        if (this.gumballCount > 0) {
            state = noQuarterState;
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getWinnerState() {
        return winnerState;
    }
}
