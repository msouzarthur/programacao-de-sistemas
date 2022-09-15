package Registers;

public final class SP {

    static int value = 0;
    
    public static int getValue() {
        return value;
    }
    
    public static void setValue(int value) {
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
