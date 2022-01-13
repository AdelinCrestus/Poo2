package SortChildren;

public class SortFactory {
    public SortFactory() {
    }

    public Sort createSorter(String criterion) {
        switch (criterion) {
            case "id" -> {
                return new SortById();
            }
            case "niceScore" -> {
                return new SortByNiceScore();
            }
            case "niceScoreCity" -> {
                return new SortByNiceScoreCity();
            }
        }
        return null;
    }
}
