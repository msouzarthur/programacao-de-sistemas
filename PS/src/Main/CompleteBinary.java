package Main;


public class CompleteBinary {
    
    public String completeBinary(String number) {
        String complete = "";
        Integer left = 16 - number.length();
        for(int i = 0; i < left; i++){
            complete+="0";
        }
        return complete + number;
    }

}
