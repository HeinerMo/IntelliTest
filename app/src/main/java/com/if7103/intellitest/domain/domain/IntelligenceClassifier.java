package com.if7103.intellitest.domain.domain;

import android.content.Context;
import android.util.Log;

import com.if7103.intellitest.domain.entity.User;
import com.if7103.intellitest.persistance.data.DatabaseController;

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

    public static List<User> sortPlayersByIntelligence(User user, Context context) {
        List<User> sortedUsers = new ArrayList<>();


        DatabaseController databaseController = DatabaseController.getInstance(context);
        List<User> userList = databaseController.getUsers();
        //delete current user from user list
        removeUserByUserName(user, userList);

        int playersSize = userList.size();

        List<List<Integer>> usersPoints = new ArrayList<>();

        for (User otherUser : userList) {
            usersPoints.add(otherUser.getPoints());
        }
        if (usersPoints.size() > 0) {
            for (int i = 0; i < playersSize; i++) {
                int minIndex = EuclidianDistanceCalculator.getMinDistanceIndex(user.getPoints(), usersPoints);
                sortedUsers.add(userList.get(minIndex));

                userList.remove(minIndex);
                usersPoints.remove(minIndex);
            }
        }
        return sortedUsers;
    }

    private static void removeUserByUserName(User user, List<User> users) {
        User userToRemove = null;
        for (User otherUser : users) {
            if (otherUser.getUserName().equals(user.getUserName())) {
                userToRemove = otherUser;
                break;
            }
        }

        if (userToRemove != null) {
            users.remove(userToRemove);
        }
    }

}
