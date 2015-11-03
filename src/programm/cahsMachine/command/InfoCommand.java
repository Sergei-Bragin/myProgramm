package programm.cahsMachine.command;

import programm.cahsMachine.CashMachine;
import programm.cahsMachine.ConsoleHelper;
import programm.cahsMachine.CurrencyManipulator;
import programm.cahsMachine.CurrencyManipulatorFactory;

import java.util.ResourceBundle;

/**
 * Created by ser-b_000 on 02.11.2015.
 */
class InfoCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");

    @Override
    public void execute()
    {
        boolean money = false;
        ConsoleHelper.writeMessage(res.getString("before"));
        for (CurrencyManipulator cur : CurrencyManipulatorFactory.getAllCurrencyManipulators()){
            if (cur.hasMoney()){
                if (cur.getTotalAmount() > 0)
                {
                    ConsoleHelper.writeMessage(cur.getCurrencyCode() + " - " + cur.getTotalAmount());
                    money = true;
                }
            }
        }
        if (!money)
            ConsoleHelper.writeMessage(res.getString("no.money"));
    }
}
