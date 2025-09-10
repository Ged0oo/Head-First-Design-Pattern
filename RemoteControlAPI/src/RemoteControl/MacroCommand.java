package RemoteControl;

public class MacroCommand implements Command {
    Command[] commands;

    public MacroCommand(Command[] commands) { this.commands = commands; }

    public void execute() {
        for (Command c : commands) {
            c.execute();
        }
    }

    public void undo() {
        for (int i = commands.length - 1; i >= 0; i--) {
            commands[i].undo();
        }
    }
}
