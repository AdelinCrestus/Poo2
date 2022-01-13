package sorters;

import children.ChildStrategy;

import java.util.ArrayList;
import java.util.Comparator;

public final class SortByNiceScore implements Sort {
    @Override
    public void sortChildren(final ArrayList<ChildStrategy> children) {
        children.sort(new Comparator<ChildStrategy>() {
            @Override
            public int compare(final ChildStrategy o1, final ChildStrategy o2) {
                if (o1.getAverageScore().compareTo(o2.getAverageScore()) == 0) {
                    return o1.getId().compareTo(o2.getId());
                }
                return o2.getAverageScore().compareTo(o1.getAverageScore());
            }
        });
    }
}
