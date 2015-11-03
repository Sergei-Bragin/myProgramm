package programm.cahsMachine.command;

import programm.cahsMachine.CashMachine;
import programm.cahsMachine.ConsoleHelper;
import programm.cahsMachine.CurrencyManipulator;
import programm.cahsMachine.CurrencyManipulatorFactory;
import programm.cahsMachine.exception.InterruptOperationException;

import java.util.ResourceBundle;



class DepositCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit_en");
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        String[] moneyAndAmount = ConsoleHelper.getValidTwoDigits(currencyCode);
        try
        {
            int k = Integer.parseInt(moneyAndAmount[0]);
            int l = Integer.parseInt(moneyAndAmount[1]);
            currencyManipulator.addAmount(k, l);
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), k * l, currencyCode));
        } catch (NumberFormatException e)
        {
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
    }
}