package command_pattern.invoker;

import command_pattern.command.Command;
import command_pattern.command.NoCommand;

import java.util.ArrayList;
import java.util.List;

public class RemoteController {
    List<Command> onCommands;
    List<Command> offCommands;
    Command undoCommand;

    public RemoteController() {
        onCommands = new ArrayList<>();
        offCommands = new ArrayList<>();

        NoCommand noCommand = new NoCommand();

        for(int i = 0; i < 7; i++) {
            onCommands.add(noCommand);
            offCommands.add(noCommand);
        }

        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands.set(slot, onCommand);
        offCommands.set(slot, offCommand);
    }

    public void onButtonPressed(int slot) {
        onCommands.get(slot).execute();
        undoCommand = onCommands.get(slot);
    }

    public void offButtonPressed(int slot) {
        offCommands.get(slot).execute();
        undoCommand = offCommands.get(slot);
    }

    public void undoButtonPressed() {
        undoCommand.undo();
    }
}
