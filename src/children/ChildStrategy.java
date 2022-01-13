package children;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import elves.*;
import enums.Category;
import enums.Cities;
import enums.ElvesType;
import gifts.Gift;

import java.util.ArrayList;

public abstract class ChildStrategy extends Child {
    private Double averageScore;
    private ArrayList<Double> niceScoreHistory;
    private Double assignedBudget;
    private ArrayList<Gift> receivedGifts;
    @JsonIgnore
    private Elf elfStrategy;

    public ChildStrategy() {
    }
    @JsonIgnore
    public Elf getElfStrategy() {
        return elfStrategy;
    }
    @JsonProperty
    public void setElfStrategy(Elf elf) {
        this.elfStrategy = elf;
    }

    public void assignElf(final ChildStrategy childStrategy) {
        switch (getElf()) {
            case PINK -> elfStrategy = new PinkElf(ElvesType.PINK, childStrategy);
            case BLACK -> elfStrategy = new BlackElf(ElvesType.BLACK, childStrategy);
            case WHITE -> elfStrategy = new WhiteElf(ElvesType.WHITE, childStrategy);
            case YELLOW -> elfStrategy = new YellowElf();
        }
    }

    public final Double getAverageScore() {
        return averageScore;
    }

    public final void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }

    public ChildStrategy(final Integer id, final String lastName, final String firstName,
                         final Integer age, final Cities city, final Double niceScore,
                         final ArrayList<Category> giftsPreferences, final Integer niceScoreBonus,
                         final ElvesType elf) {
        //super(id, lastName, firstName, age, city, niceScore, giftsPreferences);
        Builder builder = new Builder(id, lastName, firstName, city, age, giftsPreferences, niceScore, elf);
        builder = builder.niceScoreBonus(niceScoreBonus);
        Child child = builder.build();
        this.setId(child.getId());
        this.setLastName(child.getLastName());
        this.setFirstName(child.getFirstName());
        this.setAge(child.getAge());
        this.setCity(child.getCity());
        this.setNiceScore(child.getNiceScore());
        this.setGiftsPreferences(child.getGiftsPreferences());
        this.setNiceScoreBonus(child.getNiceScoreBonus());
        this.setElf(elf);
        niceScoreHistory = new ArrayList<>();
        receivedGifts = new ArrayList<>();
    }

    /**
     * Calculeaza media pentru fiecare copil, in functie de tipul acestuia
     * @return si o returneaza
     */
    public abstract Double average();

    public final ArrayList<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    public final void setReceivedGifts(final ArrayList<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    public final ArrayList<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public final void setNiceScoreHistory(final ArrayList<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    public final Double getAssignedBudget() {
        return assignedBudget;
    }

    public final void setAssignedBudget(final Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public void addNiceScoreBonus() {
        averageScore += averageScore * getNiceScoreBonus() / 100;
        if(averageScore > 10)
        {
            averageScore = 10.0;
        }
        setAverageScore(averageScore);
    }
}
