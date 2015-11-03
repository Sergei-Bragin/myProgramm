package programm.cahsMachine;

import programm.cahsMachine.command.CommandExecutor;
import programm.cahsMachine.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

public class CashMachine
{
    public static final  String  RESOURCE_PATH = "programm.cahsMachine.resources.";

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ENGLISH);
        ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH +"common_en",Locale.ENGLISH);

        try{
            CommandExecutor.execute(Operation.LOGIN);
            Operation operation;
            do
            {
                ConsoleHelper.writeMessage(res.getString("choose.operation")+"\n"+
                        res.getString("operation.INFO")+": 1;\n"+
                        res.getString("operation.DEPOSIT")+": 2;\n"+
                        res.getString("operation.WITHDRAW")+": 3;\n"+
                        res.getString("operation.EXIT")+": 4");
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            }
            while (!operation.equals(Operation.EXIT));
        }catch (InterruptOperationException e){
            try
            {
                CommandExecutor.execute(Operation.EXIT);
            }catch (InterruptOperationException ignored){}

        }


    }
}
