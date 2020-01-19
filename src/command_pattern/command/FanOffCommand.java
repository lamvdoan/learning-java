package command_pattern.command;

import command_pattern.helper.FanSpeedSelector;
import command_pattern.receiver.Fan;

public class FanOffCommand implements Command {
    private Fan fan;
    private int previousSpeed;

    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        previousSpeed = fan.getSpeed();
        fan.off();
    }

    @Override
    public void undo() {
        FanSpeedSelector.setSpeedToPreviousSpeed(fan, previousSpeed);
    }
}
