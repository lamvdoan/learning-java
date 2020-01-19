package design_pattern.ducks.duck;

import design_pattern.ducks.behavior.fly.FlyNoWay;
import design_pattern.ducks.behavior.quack.Quack;

public class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model design_pattern");
    }
}
