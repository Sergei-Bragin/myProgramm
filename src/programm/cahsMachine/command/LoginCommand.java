package programm.cahsMachine.command;

import programm.cahsMachine.CashMachine;
import programm.cahsMachine.ConsoleHelper;
import programm.cahsMachine.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by ser-b_000 on 02.11.2015.
 */
class LoginCommand implements Command
{
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        while(true){

            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String s1 = ConsoleHelper.readString();
            String s2 = ConsoleHelper.readString();

            if(validCreditCards.containsKey(s1)){
                if(validCreditCards.getString(s1).equals(s2))
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), s1));
                else {
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), s1));
                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                    continue;
                }
            }
            else {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), s1));
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }

            break;
            /*if(!s1.equals(number)|| !s2.equals(pin)){
                ConsoleHelper.writeMessage("Не верный номер/пин");
            }
            else if(number.equals(s1) && pin.equals(s2)){
                ConsoleHelper.writeMessage("Добро пожаловать в систему");
                break;
            }*/

        }

    }
}

