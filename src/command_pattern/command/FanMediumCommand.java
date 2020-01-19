package command_pattern.command;

import command_pattern.helper.FanSpeedSelector;
import command_pattern.receiver.Fan;

public class FanMediumCommand implements Command {
    Fan fan;
    private int previousSpeed;

    public FanMediumCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        previousSpeed = fan.getSpeed();
        fan.medium();
    }

    @Override
    public void undo() {
        FanSpeedSelector.setSpeedToPreviousSpeed(fan, previousSpeed);
    }
}
