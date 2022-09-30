package Registers;

import Main.Memory;

public final class SP {

    static Integer value = Memory.memorySize()-1;
    
    public static Integer getValue() {
        return value;
    }
    
    public static void setValue(Integer value) {
        //Memory.memorySet(PC.getValue(), value);
        SP.value = value;
    }
    
    public static void nextValue(){
        if(SP.getValue()>2 && SP.getValue()<100 && Memory.memoryGet(SP.getValue()-1)==null){
            SP.value -= 1;
        }
        else{
            Main.Error.showError("stackoverflow");
            reset();
        }
    }
    
    public static String getText(){
        if(SP.getValue()>=0) 
            return String.format("%016d", Integer.parseInt(Integer.toBinaryString(SP.getValue())));
        return Integer.toBinaryString(SP.getValue()).substring(16,32);
    }

    public static void previousValue(){
        if(SP.getValue()>2 && SP.getValue()<100){
            SP.value+=1;
        }
        else{
            Main.Error.showError("posicao de pilha inacessivel");
            reset();
        }
    }
    
    public static void reset(){
        SP.value = 0; 
    }
}
