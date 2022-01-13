package SortChildren;

import children.ChildStrategy;

import java.util.ArrayList;
import java.util.Comparator;

public class SortById implements Sort{
    @Override
    public void sortChildren(ArrayList<ChildStrategy> children) {
        children.sort(new Comparator<ChildStrategy>() {
            @Override
            public int compare(ChildStrategy o1, ChildStrategy o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
    }
}
