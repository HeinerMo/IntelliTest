package com.if7103.intellitest.domain.domain;

import java.util.List;

public class EuclidianDistanceCalculator {
    
    public static double calculateEuclideanDistance(List<Integer> points1, List<Integer> points2) {
        double distance = 0;
        for (int i = 0; i < points1.size(); i++) {
            distance += Math.pow(points1.get(i) - points2.get(i), 2);
        }
        return Math.sqrt(distance);
    }

    public static int getMinDistanceIndex(List<Integer> coords, List<List<Integer>> centroids) {
        int minIndex = 0;

        double minDistance = Double.MAX_VALUE;
        for (int i = 0; i < centroids.size(); i++) {
            double distance = calculateEuclideanDistance(coords, centroids.get(i));
            if (distance < minDistance) {
                minDistance = distance;
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static String getTagName(List<Integer> coords, List<String> tags, List<List<Integer>> centroids) {
        return tags.get(getMinDistanceIndex(coords, centroids));
    }
    
}