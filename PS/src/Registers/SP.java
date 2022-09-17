package Registers;

public final class SP {

    static Integer value = 0;
    
    public static int getValue() {
        return value;
    }
    
    public static void setValue(Integer value) {
        SP.value = value;
    }
    
    public static void nextValue(){
        if(SP.value<=12)
            SP.value += 1;
        else{
            Main.Error.showError("stackoverflow");
            reset();
        }
    }
    
    public static String getText(){
        if(SP.value>=0) 
            return String.format("%016d", Integer.parseInt(Integer.toBinaryString(SP.value)));
        return Integer.toBinaryString(SP.value).substring(16,32);
    }
    
    public static void push(int value){
        setValue(value);
        nextValue();
    }
    
    public static int pop(){
        int aux = SP.value;
        setValue(SP.value-1);
        return aux;
    }
    
    public static void reset(){
        SP.value = 0; 
    }
}
