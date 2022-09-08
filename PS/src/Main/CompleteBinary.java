package Main;


public class CompleteBinary {
    
    public String completeBinary(String number) {
        String complete = "";
        Integer left = 16 - number.length()-1;
        for(int i = 0; i < left; i++){
            complete+="0";
        }
        return complete + number;
    }

}
