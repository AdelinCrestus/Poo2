package SortChildren;

import children.ChildStrategy;

import java.util.ArrayList;
import java.util.Comparator;

public class SortByNiceScore implements Sort{
    @Override
    public void sortChildren(ArrayList<ChildStrategy> children) {
        children.sort(new Comparator<ChildStrategy>() {
            @Override
            public int compare(ChildStrategy o1, ChildStrategy o2) {
                if(o1.getAverageScore().compareTo(o2.getAverageScore()) == 0){
                    return o1.getId().compareTo(o2.getId());
                }
                return o2.getAverageScore().compareTo(o1.getAverageScore());
            }
        });
    }
}
