package elves;

import children.ChildStrategy;
import common.Constants;
import enums.ElvesType;

public final class BlackElf extends Elf {
    public BlackElf(final ElvesType elvesTypeType, final ChildStrategy child) {
        super(elvesTypeType, child);
    }

    @Override
    public void elfAction() {
        ChildStrategy child = getChild();
        Double budget = child.getAssignedBudget();
        budget -= budget * Constants.THIRTY / Constants.ONE_HUNDRED;
        child.setAssignedBudget(budget);
    }
}
