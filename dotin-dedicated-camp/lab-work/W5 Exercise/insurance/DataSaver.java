package ta.insurance;

import java.util.ArrayList;


public class DataSaver {
    
    public static ArrayList<String> discuntCodeSaver;

    public DataSaver() {
        
        discuntCodeSaver = new ArrayList<>();
        
    }
    
    public static boolean checkHaveDiscount(String discuntCode) {
        
        boolean result = false;
        
        int index = discuntCodeSaver.indexOf(discuntCode);
        
        if (index != -1) {
            
            result = true;
            
        }
        
        return result;
        
    }
    
    public void addDiscountCode(String discountCode){
    
        discuntCodeSaver.add(discountCode);
        
    }
    
}
