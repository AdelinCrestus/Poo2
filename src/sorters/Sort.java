package sorters;

import children.ChildStrategy;

import java.util.ArrayList;

public interface Sort {
    /**
     * Inainte de a oferi cadou copiilor ii sortam
     * @param children
     */
    void sortChildren(ArrayList<ChildStrategy> children);
}
