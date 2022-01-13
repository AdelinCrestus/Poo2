package children;

import common.Constants;
import enums.Category;
import enums.Cities;
import enums.ElvesType;

import java.util.ArrayList;

/**
 * Copii cu varsta sub 5 ani
 * Este folosit pentru Strategy Pattern
 */

public final class Baby extends ChildStrategy {
    public Baby(final Integer id, final String lastName, final String firstName, final Integer age,
                final Cities city, final Double niceScore,
                final ArrayList<Category> giftsPreferences, final Integer niceScoreBonus,
                final ElvesType elf) {
        super(id, lastName, firstName, age, city, niceScore, giftsPreferences,niceScoreBonus, elf);
    }

    @Override
    public Double average() {
        if (getNiceScoreHistory().size() == 0) {
            getNiceScoreHistory().add(getNiceScore());
        }
        this.setAverageScore(Constants.TEN);
        return Constants.TEN;

    }
}
