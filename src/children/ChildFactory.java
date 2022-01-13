package children;

import common.Constants;



public final class ChildFactory {
    private ChildFactory() {
    }

    /**
     * Creeaza copilul avand tipuri diferite la run-time in functie de varsta
     * @param child
     * @return
     */
    public static ChildStrategy createChild(final Child child) {
        ChildStrategy childStrategy;
        if (child.getAge() < Constants.MINIMUM_AGE_KID) {
                  childStrategy =   new Baby(child.getId(), child.getLastName(),
                            child.getFirstName(), child.getAge(), child.getCity(),
                            child.getNiceScore(), child.getGiftsPreferences(),
                          child.getNiceScoreBonus(), child.getElf());
        } else if (child.getAge() < Constants.MAXIMUM_AGE_KID) {
            childStrategy = new Kid(child.getId(),
                    child.getLastName(), child.getFirstName(), child.getAge(),
                    child.getCity(), child.getNiceScore(), child.getGiftsPreferences(),
                    child.getNiceScoreBonus(), child.getElf());
        } else if (child.getAge() <= Constants.MAXIMUM_AGE_TEEN) {
            childStrategy = new Teen(child.getId(),
                    child.getLastName(), child.getFirstName(), child.getAge(),
                    child.getCity(), child.getNiceScore(), child.getGiftsPreferences(),
                    child.getNiceScoreBonus(), child.getElf());
        } else {
            childStrategy = new YoungAdult(child.getId(),
                    child.getLastName(), child.getFirstName(), child.getAge(),
                    child.getCity(), child.getNiceScore(), child.getGiftsPreferences(),
                    child.getNiceScoreBonus(), child.getElf());
        }
        childStrategy.getNiceScoreHistory().add(child.getNiceScore());
        childStrategy.assignElf(childStrategy);
        return childStrategy;
    }
}
