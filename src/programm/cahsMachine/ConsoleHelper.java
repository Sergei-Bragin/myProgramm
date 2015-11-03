package programm.cahsMachine;

import programm.cahsMachine.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper
{
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res =ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"common_en");

    public static void  writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String message = " ";
        try {
            message = reader.readLine();
            if(message.equalsIgnoreCase(res.getString("operation.EXIT"))) throw new InterruptOperationException();
        }catch (IOException ignored){}

        return message;
    }

    public static String askCurrencyCode() throws InterruptOperationException{
        String test;
        writeMessage(res.getString("choose.currency.code"));
        while (true)
        {
            test = readString();
            if (test.length() == 3)
                break;
            else
                writeMessage(res.getString("invalid.data"));

        }
        test = test.toUpperCase();
        return test;
    }

    public static String [] getValidTwoDigits(String currencyCode)throws InterruptOperationException{
        String[] arr;
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));

        while (true){
            String s = readString();
            arr = s.split(" ");
            int k, l;
            try
            {
                k=Integer.parseInt(arr[0]);
                l=Integer.parseInt(arr[1]);
            } catch (Exception e){
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            if(k<=0 || l<=0 || arr.length>2){
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            break;
        }
        return arr;
    }

    public static Operation askOperation() throws InterruptOperationException {
        while (true)
        {
            String line = readString();
            if (Integer.parseInt(line) == 1 || Integer.parseInt(line) == 2 ||
                    Integer.parseInt(line) == 3 || Integer.parseInt(line) == 4)
            {
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(line));
            }
            writeMessage(res.getString("invalid.data"));
        }
    }

    public static void printExitMessage(){
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }

}
