package Main;

import java.util.ArrayList;
import java.util.List;

public class Macro {

    private int start, end;
    private List<String[]> orgContent = new ArrayList<>();
    private List<String[]> newContent = new ArrayList<>();
    private String name, arg1, arg2, arg3, arg4, label;

    Macro(String[] definition) {
        this.label = definition[0];
        this.name = definition[1];
        this.arg1 = definition[2];
        this.arg2 = definition[3];
        this.arg3 = definition[4];
        this.arg4 = definition[5];
    }

    public void changeVar(String[] call) {
        List<String[]> newContent = this.orgContent;
        String nLabel = call[0];
        String nArg1 = call[2];
        String nArg2 = call[3];
        String nArg3 = call[4];
        String nArg4 = call[5];

        for (int r = 0; r < newContent.size(); r++) {
            
        }
        setNewContent(newContent);
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setOrgContent(List<String[]> orgContent) {
        this.orgContent = orgContent;
    }

    public void setNewContent(List<String[]> newContent) {
        this.newContent = newContent;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public List<String[]> getOrgContent() {
        return orgContent;
    }

    public List<String[]> getNewContent() {
        return newContent;
    }

    public String getName() {
        return name;
    }

}
