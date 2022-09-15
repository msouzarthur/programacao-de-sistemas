package Registers;

import Main.*;
import static Main.CompleteBinary.*;

public final class SP {

    static String value="0000000000000000";
    
    public static String getValue() {
        return value;
    }
    
    public static void setValue(String value) {
        SP.value = value;
    }
    
    public static void nextValue(){
        if(CompleteBinary.toInt(SP.value)<=12)
            SP.value = CompleteBinary.toBin(CompleteBinary.toInt(value)+1);
        else{
            Main.Error.showError("stackoverflow");
            reset();
        }
    }
    
    public static void push(String value){
        setValue(value);
        nextValue();
    }
    
    public static String pop(){
        String aux = SP.value;
        setValue(toBin(toInt(SP.value)-1));
        return aux;
    }
    
    public static void reset(){
        SP.value = "0000000000000000"; 
    }
}
