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
    public Integer toInt(String cod){
        if(cod!=null)
            return Integer.parseInt(cod,2);
        return null;
    }
    
    public String toBin(Integer number){
        if(number != null){
            String bin = Integer.toBinaryString(number);
            String complete = "";
            Integer left = 16 - bin.length();
            for(int i = 0; i < left; i++){
               complete+="0";
            }
            return complete + bin;
        }
        return null;
    }

}
