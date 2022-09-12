package Registers;

import Main.Register;

public final class ACC implements Register {
    String value="0000000000000000";
    
    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

}
