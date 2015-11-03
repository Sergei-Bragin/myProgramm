package programm.cahsMachine.command;

import programm.cahsMachine.Operation;
import programm.cahsMachine.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ser-b_000 on 02.11.2015.
 */
public class CommandExecutor
{
    private static Map<Operation,Command> map;
    static {
        map =new HashMap<>();
        map.put(Operation.LOGIN, new LoginCommand());
        map.put(Operation.INFO, new InfoCommand());
        map.put(Operation.DEPOSIT, new DepositCommand());
        map.put(Operation.WITHDRAW, new WithdrawCommand());
        map.put(Operation.EXIT, new ExitCommand());
    }

    public static final void execute (Operation operation)throws InterruptOperationException {
        map.get(operation).execute();
    }

    private CommandExecutor()
    {
    }
}
