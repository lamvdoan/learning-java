package state_pattern.state;

public abstract class State {
    public abstract void insertQuarter();
    public abstract void ejectQuarter();
    public abstract boolean turnCrank();
    public abstract void dispense();
}
