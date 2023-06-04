package com.if7103.intellitest.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class Intelligence {
    private String name;
    private List<Integer> centroids;

    public Intelligence(String name, List<Integer> centroids) {
        this.name = name;
        this.centroids = centroids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getCentroids() {
        return centroids;
    }
    public void setCentroids(ArrayList<Integer> centroids) {
        this.centroids = centroids;
    }
}
