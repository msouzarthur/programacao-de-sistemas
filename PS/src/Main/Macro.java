package Main;

import java.util.ArrayList;
import java.util.List;

public class Macro {

    public int start;
    public int end;
    public String name, label;
    public String arg1, arg2, arg3, arg4;
    public List<String[]> content = new ArrayList<>();

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

    public void changeVar(String[] call) {
        //atualiza as variaveis da macro de acordo com os parametros da chamada
        //é posicional
        String a1 = call[2], a2 = call[3], a3 = call[4], a4 = call[5];
        for (String[] l : this.content) {
            l[2] = a1;
            l[3] = a2;
            l[5] = a3;
            l[5] = a4;
        }
    }
}
