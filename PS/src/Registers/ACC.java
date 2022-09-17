package Registers;

public final class ACC{

    static Integer value=0;
    
    public static int getValue() {
        return value;
    }

    public static String getText(){
        if(ACC.value>=0){
            return String.format("%016d", Integer.parseInt(Integer.toBinaryString(ACC.value)));
        }
        else{
            System.out.println("entrou");
            return Integer.toBinaryString(ACC.value).substring(16,32);
        }
    }
    
    public static void setValue(Integer value) {
        ACC.value = value;
    }
    
    public static void reset(){
        ACC.value = 0; 
    }

}
