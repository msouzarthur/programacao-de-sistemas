
public class Memory {
    //HashMap<String, Double> memory = new HashMap<String,Double>();
    String[][] memory = new String[100][2];
    public Memory(){
        for(int i = 0; i<100; i++){
            memory[i][0] = String.valueOf(i);
        }
    }
    
    public String[][] get(){
        return memory;
    }
    
}
