package command_pattern.command;

import command_pattern.helper.FanSpeedSelector;
import command_pattern.receiver.Fan;

public class FanLowCommand implements Command {
    Fan fan;
    private int previousSpeed;

    public FanLowCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        previousSpeed = fan.getSpeed();
        fan.low();
    }

    @Override
    public void undo() {
        FanSpeedSelector.setSpeedToPreviousSpeed(fan, previousSpeed);
    }
}
