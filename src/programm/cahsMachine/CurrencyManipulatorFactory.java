package programm.cahsMachine;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by ser-b_000 on 02.11.2015.
 */
public final class CurrencyManipulatorFactory
{
    static HashMap<String, CurrencyManipulator> map = new HashMap<>();
    static boolean isExist = false;

    private CurrencyManipulatorFactory()
    {

    }

    public  static CurrencyManipulator getManipulatorByCurrencyCode (String currencyCode){
        isExist = false;
        CurrencyManipulator current;
        if(map.containsKey(currencyCode))return map.get(currencyCode);
        else {
            current = new CurrencyManipulator(currencyCode);
            map.put(currencyCode,current);
            return current;
        }
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        return map.values();
    }
}
