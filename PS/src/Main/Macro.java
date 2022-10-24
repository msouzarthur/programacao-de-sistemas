package Main;

import java.util.ArrayList;
import java.util.List;

public class Macro {

    public int start;
    public int end;
    public String name, label;
    public String arg1, arg2, arg3, arg4;
    public List<String[]> content = new ArrayList<>();
    public List<String[]> newContent = new ArrayList<>();

    Macro(String[] definition) {
        this.label = definition[0];
        this.name = definition[1];
        this.arg1 = definition[2];
        this.arg2 = definition[3];
        this.arg3 = definition[4];
        this.arg4 = definition[5];
    }

    public void setInit(int s) {
        this.start = s;
    }

    public void setEnd(int e) {
        this.end = e;
    }

    public int getInit() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }

    public String getName() {
        return this.name;
    }

    public void setContent(List<String[]> content) {
        this.content = content;
    }

    public List<String[]> getContent() {
        return this.content;
    }

    public List<String[]> getNewContent() {
        return this.newContent;
    }

    public void changeVar(String[] call) {
        newContent = this.content;
        for (int r = 0; r < newContent.size(); r++) {
            for (int i = 0; i < newContent.get(r).length; i++) {
                if (newContent.get(r)[i] != null) {
                    if (newContent.get(r)[i].equals(arg1)) {
                        newContent.get(r)[i] = call[2];
                    }
                    if (newContent.get(r)[i].equals(arg2)) {
                        newContent.get(r)[i] = call[3];
                    }
                    if (newContent.get(r)[i].equals(arg3)) {
                        newContent.get(r)[i] = call[4];
                    }
                    if (newContent.get(r)[i].equals(arg4)) {
                        newContent.get(r)[i] = call[5];
                    }
                }
            }
        }
    }
}
