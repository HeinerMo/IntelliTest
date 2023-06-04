package com.if7103.intellitest.domain.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntelligenceClassifier {
    
    private static List<String> getIntelligenceTypes() {

        //TODO: This should use the "intelligence" class.
        List<String> intelligenceTypes = new ArrayList<>();
        intelligenceTypes.add("Espacial");
        intelligenceTypes.add("Musical");
        intelligenceTypes.add("Lingüístico-verbal");
        intelligenceTypes.add("Lógico-matemático");
        intelligenceTypes.add("Corporal-cinestésico");
        intelligenceTypes.add("Intrapersonal");
        intelligenceTypes.add("Interpersonal");
        intelligenceTypes.add("Naturalista");
        intelligenceTypes.add("Existencial");
        intelligenceTypes.add("Creativo");
        intelligenceTypes.add("Emocional");
        intelligenceTypes.add("Colaborativo");

        return intelligenceTypes;
    }

    private static List<List<Integer>> getIntelligenceTypesCentroids() {
        List<List<Integer>> centroids = new ArrayList<>();
        centroids.add(Arrays.asList(2, 2, 2, 3, 2, 2, 2, 3, 2, 2, 2, 1));
        centroids.add(Arrays.asList(2, 3, 2, 1, 3, 2, 1, 2, 2, 2, 2, 2));
        centroids.add(Arrays.asList(1, 3, 1, 3, 3, 3, 2, 2, 3, 2, 2, 2));
        centroids.add(Arrays.asList(2, 1, 2, 2, 3, 2, 2, 2, 3, 3, 2, 2));
        centroids.add(Arrays.asList(2, 2, 1, 2, 2, 3, 1, 3, 2, 3, 2, 2));
        centroids.add(Arrays.asList(1, 2, 2, 2, 3, 2, 2, 2, 3, 2, 2, 3));
        centroids.add(Arrays.asList(2, 2, 2, 2, 3, 2, 1, 3, 2, 2, 2, 2));
        centroids.add(Arrays.asList(3, 2, 2, 2, 1, 3, 2, 2, 2, 2, 2, 2));
        centroids.add(Arrays.asList(2, 2, 3, 3, 2, 2, 2, 3, 2, 2, 2, 2));
        centroids.add(Arrays.asList(2, 2, 2, 2, 2, 1, 3, 2, 2, 2, 3, 2));
        centroids.add(Arrays.asList(3, 2, 2, 3, 2, 2, 2, 1, 3, 2, 2, 2));
        centroids.add(Arrays.asList(3, 2, 2, 2, 3, 2, 2, 2, 2, 2, 1, 2));

        return centroids;
    }

    public static String getPredominantIntelligenceType(List<Integer> points) {
        return EuclidianDistanceCalculator.getTagName(points, getIntelligenceTypes(), getIntelligenceTypesCentroids());
    }

    public static List<String> sortPlayersByIntelligence(List<Integer> personalPoints, List<String> playersNames, List<List<Integer>> playersPoints) {

        // TODO: Si es necesario, validar que no se muestre le mismo jugador en la lista.

        List<String> sortedPlayersNames = new ArrayList<>();
        
        int playersSize = playersNames.size();

        for (int i = 0; i < playersSize; i++) {
            int minIndex = EuclidianDistanceCalculator.getMinDistanceIndex(personalPoints, playersPoints);
            sortedPlayersNames.add(playersNames.get(minIndex));

            playersNames.remove(minIndex);
            playersPoints.remove(minIndex);
        }

        return sortedPlayersNames;
    } 

}
