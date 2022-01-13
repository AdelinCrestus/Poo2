package SortChildren;

import children.Child;
import children.ChildStrategy;
import enums.Cities;

import java.util.*;

public class SortByNiceScoreCity implements Sort{
    private HashMap<Cities, Double> mapCityScore = new HashMap<>();
    private HashMap<Cities, ArrayList<Double>> mapCityScores = new HashMap<>();

    public HashMap<Cities, Double> getMapCityScore() {
        return mapCityScore;
    }

    public HashMap<Cities, ArrayList<Double>> getMapCityScores() {
        return mapCityScores;
    }

    public void setMapCityScores(HashMap<Cities, ArrayList<Double>> mapCityScores) {
        this.mapCityScores = mapCityScores;
    }

    public void setMapCityScore(HashMap<Cities, Double> mapCityScore) {
        this.mapCityScore = mapCityScore;
    }

    @Override
    public void sortChildren(ArrayList<ChildStrategy> children) {
        for(ChildStrategy child : children) {
            ArrayList<Double> niceScores = mapCityScores.get(child.getCity());
            if(niceScores == null) {
                niceScores = new ArrayList<>();
                niceScores.add(child.getAverageScore());

                mapCityScores.put(child.getCity(),niceScores);
            } else {
                niceScores.add(child.getAverageScore());
                mapCityScores.put(child.getCity(),niceScores);

            }
        }

        for(Map.Entry<Cities, ArrayList<Double>> map : mapCityScores.entrySet()) {
            ArrayList<Double> scores = map.getValue();
            Double sum = 0.0;
            for(Double score: scores) {
                sum += score;
            }
            mapCityScore.put(map.getKey(), sum/scores.size());
        }
        ArrayList<Cities> cities = new ArrayList<>(mapCityScore.keySet());
        ArrayList<Double> niceScores = new ArrayList<>(mapCityScore.values());
        for (int i = 0; i < niceScores.size() - 1; i++) {
            for (int j = i + 1; j < niceScores.size(); j++){
                if(niceScores.get(i) < niceScores.get(j)) {
                    Collections.swap(niceScores, i, j);
                    Collections.swap(cities, i, j);
                }
            }
        }
        for (int i = 0; i < niceScores.size() - 1; i++) {
            for (int j = i + 1; j < niceScores.size(); j++){
                if(niceScores.get(i).compareTo(niceScores.get(j)) == 0) {
                    if(cities.get(i).toString().compareTo(cities.get(j).toString()) > 0) {
                        Collections.swap(niceScores, i, j);
                        Collections.swap(cities, i, j);
                    }
                }
            }
        }
        int j = 0;
        for(int k = 0; k < cities.size(); k++) {
            for (int i = 0; i < children.size(); i++) {
                if(children.get(i).getCity().compareTo(cities.get(k)) == 0) {
                    Collections.swap(children, i, j);
                    j++;
                }

            }
        }

        children.sort((o1, o2) -> {
            if (o1.getCity().compareTo(o2.getCity()) == 0) {
                return o1.getId().compareTo(o2.getId());
            }
            return 0;
        });


    }
}
