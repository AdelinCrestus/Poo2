package children;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import enums.Category;
import enums.Cities;
import enums.ElvesType;

import java.util.ArrayList;

public class Child {
    private Integer id;
    private String lastName;
    private String firstName;
    private Cities city;
    private Integer age;
    private ArrayList<Category> giftsPreferences;
    private Double niceScore;
    private Integer niceScoreBonus;
    private ElvesType elf;

    public static class Builder {
        private Integer id; // mandatory
        private String lastName; // mandatory
        private String firstName; // mandatory
        private Cities city; // mandatory
        private Integer age;  // mandatory
        private ArrayList<Category> giftsPreferences; // mandatory
        private Double niceScore; // mandatory
        @JsonIgnore
        private Integer niceScoreBonus = 0; // optional
        @JsonIgnore
        private ElvesType elf;

        public Builder(Integer id, String lastName, String firstName, Cities city, Integer age,
                       ArrayList<Category> giftsPreferences, Double niceScore, ElvesType elf) {
            this.id = id;
            this.lastName = lastName;
            this.firstName = firstName;
            this.city = city;
            this.age = age;
            this.giftsPreferences = giftsPreferences;
            this.niceScore = niceScore;
            this.elf = elf;
        }

        public Builder niceScoreBonus(int niceScoreBonus) {
            this.niceScoreBonus = niceScoreBonus;
            return this;
        }

        public Child build() {
            return new Child(this);
        }
    }


    public Child() {
    }

    private Child(Builder builder) {
        this.id = builder.id;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.city = builder.city;
        this.age = builder.age;
        this.giftsPreferences = builder.giftsPreferences;
        this.niceScore = builder.niceScore;
        this.niceScoreBonus = builder.niceScoreBonus;
    }

    private Child(final Integer id, final String lastName, final String firstName,
                 final Integer age, final Cities city, final Double niceScore,
                 final ArrayList<Category> giftsPreferences) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
    }
    @JsonIgnore
    public Integer getNiceScoreBonus() {
        return niceScoreBonus;
    }
    @JsonProperty
    public void setNiceScoreBonus(Integer niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
    }

    public final Integer getId() {
        return id;
    }

    public final void setId(final Integer id) {
        this.id = id;
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public final Integer getAge() {
        return age;
    }

    public final void setAge(final Integer age) {
        this.age = age;
    }

    public final Cities getCity() {
        return city;
    }

    public final void setCity(final Cities city) {
        this.city = city;
    }
    @JsonIgnore
    public ElvesType getElf() {
        return elf;
    }
    @JsonProperty
    public void setElf(ElvesType elf) {
        this.elf = elf;
    }

    @JsonIgnore
    public final Double getNiceScore() {
        return niceScore;
    }
    @JsonProperty
    public final void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    public final ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public final void setGiftsPreferences(final ArrayList<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }
}
