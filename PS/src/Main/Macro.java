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

    public List<String[]> changeVar(String[] call) {
        newContent = this.orgContent;
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

            /*String[] row;
        for (int r = 1; r < orgContent.size() - 1; r++) {
            row = orgContent.get(r);
            if (orgContent.get(r)[2].equals(arg1)) {
                row[2] = call[2];
            }
            if (orgContent.get(r)[3].equals(arg1)) {
                row[3] = call[2];
            }
            if (orgContent.get(r)[4].equals(arg1)) {
                row[4] = call[2];
            }
            if (orgContent.get(r)[5].equals(arg1)) {
                row[5] = call[2];
            }
            for (int w = 0; w < orgContent.get(r).length; w++) {
                if (orgContent.get(r)[w].equals(arg1)) {
                    row[w] = call[2];
                }
                if (orgContent.get(r)[w].equals(arg2)) {
                    row[w] = call[3];
                }
                if (orgContent.get(r)[w].equals(arg3)) {
                    row[w] = call[4];
                }
                if (orgContent.get(r)[w].equals(arg4)) {
                    row[w] = call[5];
                }
            }

            newContent.add(row);
        }*/
        }
        return newContent;
    }

    public ArrayList<String[]> expand(String[] call) {
        ArrayList<String[]> exp = new ArrayList<>();
        int nivel = 0;
        newContent = changeVar(call);
        for (String[] r : newContent) {
            if (r[1].equals("macro")) {
                nivel += 1;
            }
        }
        return exp;
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
