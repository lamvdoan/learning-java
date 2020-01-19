package exercise.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class SolutionWeightedNode implements Comparable<SolutionWeightedNode> {
	public String name;

	private ArrayList<SolutionWeightedNode> neighbors = new ArrayList<SolutionWeightedNode>();
	private HashMap<SolutionWeightedNode, Integer> weightMap = new HashMap<>();
	private boolean isVisited = false;
	private SolutionWeightedNode parent;
	private int distance;

	public SolutionWeightedNode(String name) {
		this.name = name;
		distance = Integer.MAX_VALUE;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<SolutionWeightedNode> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(ArrayList<SolutionWeightedNode> neighbors) {
		this.neighbors = neighbors;
	}

	public HashMap<SolutionWeightedNode, Integer> getWeightMap() {
		return weightMap;
	}

	public void setWeightMap(HashMap<SolutionWeightedNode, Integer> weightMap) {
		this.weightMap = weightMap;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public SolutionWeightedNode getParent() {
		return parent;
	}

	public void setParent(SolutionWeightedNode parent) {
		this.parent = parent;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(SolutionWeightedNode o) {
		return this.distance - o.distance;
	}

}
