package command_pattern.command;

public class NoCommand implements Command {
    @Override
    public void execute() {}

    @Override
    public void undo() {}
}
