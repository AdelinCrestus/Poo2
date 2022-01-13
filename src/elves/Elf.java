package elves;

import children.Child;
import children.ChildStrategy;
import com.fasterxml.jackson.annotation.JsonIgnore;
import enums.ElvesType;

public abstract class Elf {
    private ElvesType elfType;
    @JsonIgnore
    private ChildStrategy child;

    public Elf() {
    }


    public Elf(ElvesType elvesTypeType, ChildStrategy child) {
        this.elfType = elvesTypeType;
        this.child = child;
    }

    public abstract void elfAction();

    public ElvesType getElfType() {
        return elfType;
    }

    public void setElfType(ElvesType elfType) {
        this.elfType = elfType;
    }
    @JsonIgnore
    public ChildStrategy getChild() {
        return child;
    }
    @JsonIgnore
    public void setChild(ChildStrategy child) {
        this.child = child;
    }
}
