package elves;

import children.ChildStrategy;
import enums.ElvesType;

public class PinkElf extends Elf{
    public PinkElf(ElvesType elvesTypeType, ChildStrategy child) {
        super(elvesTypeType, child);
    }

    @Override
    public void elfAction() {
        ChildStrategy child = getChild();
        Double budget = child.getAssignedBudget();
        budget += budget * 30 / 100;
        child.setAssignedBudget(budget);
    }
}
