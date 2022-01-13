package elves;

import children.ChildStrategy;
import enums.ElvesType;
import gifts.Gift;
import santa.SantaClaus;

import java.util.ArrayList;

public final class YellowElf extends Elf {
    private ArrayList<ChildStrategy> children;
    public YellowElf() {
        super();
    }

    public ArrayList<ChildStrategy> getChildren() {
        return children;
    }

    public void setChildren(final ArrayList<ChildStrategy> children) {
        this.children = children;
    }

    @Override
    public void elfAction() {
        SantaClaus santaClaus = SantaClaus.getInstance();
        ArrayList<Gift> gifts = santaClaus.getGiftList();
        for (ChildStrategy child : children) {
            if (child.getElf().compareTo(ElvesType.YELLOW) == 0) {
                if (child.getReceivedGifts().isEmpty()) {
                    for (Gift gift : gifts) {
                        if (!child.getGiftsPreferences().isEmpty()) {
                            if (gift.getCategory().compareTo(child.getGiftsPreferences().get(0))
                                    == 0) {
                                if (gift.getQuantity() > 0) {
                                    santaClaus.giveGift(child, gift, gifts);
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}
