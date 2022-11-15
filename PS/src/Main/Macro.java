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

	/**
	 * Método responsável por atualizar a lista de variáveis da macro
	 * @param call linha de chamada da macro
	 */
    public void changeVar(String[] call) {
        newContent = orgContent;
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

	/**
	 * Método responsável por expandir as macros no código
	 * @param call linha de chamada da macro
	 */
    public void expand(String[] call) {
        this.newContent = new ArrayList<>();

        //faz um deepcopy
        for (String[] r : orgContent) {
            String[] clone = new String[r.length];
            System.arraycopy(r, 0, clone, 0, r.length);
            this.newContent.add(clone);
        }

        for (int r = 0; r < orgContent.size(); r++) {
            for (int i = 0; i < orgContent.get(r).length; i++) {
                if (orgContent.get(r)[i] != null) {
                    if (orgContent.get(r)[i].equals(arg1)) {
                        newContent.get(r)[i] = call[2];
                    }
                    if (orgContent.get(r)[i].equals(arg2)) {
                        newContent.get(r)[i] = call[3];
                    }
                    if (orgContent.get(r)[i].equals(arg3)) {
                        newContent.get(r)[i] = call[4];
                    }
                    if (orgContent.get(r)[i].equals(arg4)) {
                        newContent.get(r)[i] = call[5];
                    }
                }
            }
        }
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
