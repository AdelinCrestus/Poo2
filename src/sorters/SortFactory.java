package sorters;

public final class SortFactory {
    public SortFactory() {
    }

    /**
     * Am folosit factory pentru a crea la runtime tipul de sortare de care avem nevoie
     * @param criterion
     * @return
     */
    public Sort createSorter(final String criterion) {
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
            default -> {
                return null;
            }
        }
    }
}
