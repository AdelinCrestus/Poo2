package sorters;

import children.ChildStrategy;

import java.util.ArrayList;
import java.util.Comparator;

public final class SortById implements Sort {
    @Override
    public void sortChildren(final ArrayList<ChildStrategy> children) {
        children.sort(new Comparator<ChildStrategy>() {
            @Override
            public int compare(final ChildStrategy o1, final ChildStrategy o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
    }
}
