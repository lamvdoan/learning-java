package state_pattern.client;

import state_pattern.context.GumballMachine;

public class GumballMachineTestDrive {

    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5);
        System.out.println("Gumball Count: " + gumballMachine.getGumballCount() + "\n");

        // -1 gumball
        gumballMachine.ejectQuarter();
        gumballMachine.turnCrank();

        gumballMachine.insertQuarter();
        gumballMachine.ejectQuarter();

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println("Gumball Count: " + gumballMachine.getGumballCount() + "\n");


        // -1 gumball
        gumballMachine.turnCrank();
        gumballMachine.ejectQuarter();

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println("Gumball Count: " + gumballMachine.getGumballCount() + "\n");


        // -1 gumball
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println("Gumball Count: " + gumballMachine.getGumballCount() + "\n");


        // refill
        gumballMachine.refill(1);
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println("Gumball Count: " + gumballMachine.getGumballCount() + "\n");


        // refill 5
        gumballMachine.refill(5);
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println("Gumball Count: " + gumballMachine.getGumballCount() + "\n");
    }
}
