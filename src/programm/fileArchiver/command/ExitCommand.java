package programm.fileArchiver.command;

import programm.fileArchiver.ConsoleHelper;

public class ExitCommand implements Command {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("до встречи");
    }
}
