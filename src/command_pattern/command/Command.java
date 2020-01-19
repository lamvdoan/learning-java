package command_pattern.command;

public interface Command {
    void execute();
    void undo();
}
