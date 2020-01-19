package design_pattern.ducks.duck;

import design_pattern.ducks.behavior.fly.FlyWithWings;
import design_pattern.ducks.behavior.quack.Quack;

public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
    }
}
