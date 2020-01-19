package exercise.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedNode {
    private String name;
    private List<WeightedNode> neighbors;
    private Map<WeightedNode, Integer> weightedMap;
    private WeightedNode parent;
    private int distance;

    public WeightedNode(String name) {
        this.name = name;
        weightedMap = new HashMap<>();
        neighbors = new ArrayList<>();
    }

    public List<WeightedNode> getNeighbors() {
        return neighbors;
    }

    public Map<WeightedNode, Integer> getWeightedMap() {
        return weightedMap;
    }

    public String getName() {
        return name;
    }

    public WeightedNode getParent() {
        return parent;
    }

    public void setParent(WeightedNode parent) {
        this.parent = parent;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
