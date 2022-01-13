package elves;

import children.ChildStrategy;
import com.fasterxml.jackson.annotation.JsonIgnore;
import enums.ElvesType;

public abstract class Elf {
    private ElvesType elfType;
    @JsonIgnore
    private ChildStrategy child;

    public Elf() {
    }

    /**
     * Clasa abstracta creata pentru a implementa design pattern-ul strategy pentru calculul
     * bugetului influentat de elfi
     * @param elvesType tipul elfului
     * @param child copilul caruia ii este asignat
     */
    public Elf(final ElvesType elvesType, final ChildStrategy child) {
        this.elfType = elvesType;
        this.child = child;
    }

    /**
     * Fiecare elf isi va face actiunea detaliata in enunt
     */
    public abstract void elfAction();

    public final ElvesType getElfType() {
        return elfType;
    }

    public final void setElfType(final ElvesType elfType) {
        this.elfType = elfType;
    }
    @JsonIgnore
    public final ChildStrategy getChild() {
        return child;
    }
    @JsonIgnore
    public final void setChild(final ChildStrategy child) {
        this.child = child;
    }
}
