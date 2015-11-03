package programm.cahsMachine.command;

import programm.cahsMachine.exception.InterruptOperationException;

interface Command
{
    void execute() throws InterruptOperationException;
}
