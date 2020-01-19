package command_pattern.command;

import command_pattern.receiver.TV;

public class TVOnCommand implements Command {
    TV tv;

    public TVOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.on();
    }

    public void undo() {
        tv.off();
    }
}
