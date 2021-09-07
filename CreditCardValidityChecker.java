
public class CreditCardValidityChecker{
    
          // Declaration of instance variables
    private String cardNumber;
    private boolean valid;
    private int errorCode;
  
          // Constructor 
    public CreditCardValidityChecker(String inputCardNumber){
        
        cardNumber = inputCardNumber;
        valid = true;
        errorCode = 0;
        
    }
          
          /* Private check1() mutator method to verify first rule *
           * if digit1 is not 4, sets valid to false              *
           * then, sets errorCode to 1                            */
    private void check1(){
        
        int digit1 = Integer.parseInt(cardNumber.substring(0,1));
        
        if (digit1 != 4){
            valid = false;
            errorCode = 1;
        }
            
    }
    
          /* Private check2() mutator method to verify second rule      *
           * if digit4 is not one more than digit5, sets valid to false *
           * then, sets errorCode to 2                                  */
    private void check2(){
        
        int digit4 = Integer.parseInt(cardNumber.substring(3,4));
        int digit5 = Integer.parseInt(cardNumber.substring(5,6));
        
        if (digit4 != digit5 + 1){
            valid = false; 
            errorCode = 2;
        }
       
    }
    
          /* Private check3() mutator method to verify third rule *
           * if product of digit1, digit5 and digit9 is not 24,   *
           * sets valid to false and errorCode to 3               */
    private void check3(){
        
        int digit1 = Integer.parseInt(cardNumber.substring(0,1));
        int digit5 = Integer.parseInt(cardNumber.substring(5,6));
        int digit9 = Integer.parseInt(cardNumber.substring(10,11));
        
        if (digit1 * digit5 * digit9 != 24){
            valid = false;
            errorCode = 3;
        }
   
    }
     
          /* Private check4() mutator method to verify fourth rule    *
           * Implements for loop to sum each digit of the cardNumber  *
           * If the sum is not evenly divisible by 4,                 *
           * sets valid to false and errorCode to 4                   */
    private void check4(){
        
        int sum = 0;
        int digit;
        
        for (int i = 0; i < cardNumber.length(); i++){
            
            if (cardNumber.charAt(i) != '-'){
                digit = Integer.parseInt(cardNumber.substring(i, i+1));
                sum = sum + digit;
            }
            
        }
 
        if (sum % 4 != 0){
            valid = false;
            errorCode = 4;
        }
        
    }
          
          /* Private check5() mutator method to verify fifth rule          *
           * Implements two for loops to sum first four digits (sumFirst4) *
           * and last four digits of cardNumber (sumLast4)                 *
           * If the sumFirst4 is not one less than sumLast4,               *
           * sets valid to false and errorCode to 5                        */
    private void check5(){
        
        int sumFirst4 = 0, sumLast4 = 0;
        int digitA, digitB;
        
        for (int i = 0; i < 4; i++){
                digitA = Integer.parseInt(cardNumber.substring(i, i+1));
                sumFirst4 = sumFirst4 + digitA;
        }
        
        for (int i = 10; i < 14; i++){
                digitB = Integer.parseInt(cardNumber.substring(i, i+1));
                sumLast4 = sumLast4 + digitB;
        }
        
        if (sumFirst4 != sumLast4 - 1){
            valid = false;
            errorCode = 5;
        }
        
    }
    
          /* Private check6() mutator method to verify sixth rule            *
           * If digits 1 & 2 taken as a single number (stored as digits1_2)  *
           * and digits 7 & 8 taken as a single number (stored as digits7_8) *
           * do not sum up to 100, sets valid to false and errorCode to 6    */
    private void check6(){
        
        int digits1_2 = Integer.parseInt(cardNumber.substring(0,2));
        int digits7_8 = Integer.parseInt(cardNumber.substring(7,9));
        
        if (digits1_2 + digits7_8 != 100){
            valid = false;
            errorCode = 6;
        }
        
    }
    
          /* Complete check() mutator method                                *
           * Runs each check from above in succession while valid is true   *
           * Once a single check fails, the rest are not carried out        *
           * valid is false and errorCode is that of the first failed check */                 
    public void check(){
        check1();
        
        if (valid == true){
            check2();
            
            if (valid == true){
                check3();
                
                if (valid == true){
                   check4();
                   
                   if (valid == true){
                       check5();
                   
                       if (valid == true){
                           check6();
                       } 
                   }
                }
            }
        }        
    }
    
          // Accessor method for valid
    public boolean isValid(){
        return valid;
    }
    
          // Accessor method for errorCode
    public int getErrorCode(){
        return errorCode;
    }
    
}         // End of class