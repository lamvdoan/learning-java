package exercise.graph;

import java.util.*;

/*
 *  Shortest path solutions will work for weighted and for direction/directionless paths.
 *
 */
class WeightedGraph {
    private List<WeightedNode> nodes;

    WeightedGraph(List<WeightedNode> nodes) {
        this.nodes = nodes;
    }

    void addWeightedEdge(int source, int destination, int weight) {
        nodes.get(source).getNeighbors().add(nodes.get(destination));
        nodes.get(source).getWeightedMap().put(nodes.get(destination), weight);

        // There is no direction, so must add the reciprocate
        nodes.get(destination).getNeighbors().add(nodes.get(source));
        nodes.get(destination).getWeightedMap().put(nodes.get(source), weight);
    }

    void dijkstra(WeightedNode sourceNode) {
        initializeDistanceAndParentOfAllNodes(sourceNode);

        findShortestDistance(sourceNode);

        printAllPathsOfNeighboringNodes();
    }

    private void findShortestDistance(WeightedNode sourceNode) {
        Set<WeightedNode> unvisited = new HashSet<>();
        unvisited.add(sourceNode);

        while (!unvisited.isEmpty()) {
            WeightedNode currentNode = getShortestDistanceNode(unvisited);
            unvisited.remove(currentNode);

            for (WeightedNode neighbor : currentNode.getNeighbors()) {
                int nodeToNeighborDistance = currentNode.getDistance() + currentNode.getWeightedMap().get(neighbor);

                if (nodeToNeighborDistance < neighbor.getDistance()) {
                    neighbor.setParent(currentNode);
                    neighbor.setDistance(nodeToNeighborDistance);
                    unvisited.add(neighbor);
                }
            }
        }
    }

    private void initializeDistanceAndParentOfAllNodes(WeightedNode sourceNode) {
        for (WeightedNode node : nodes) {
            node.setDistance(Integer.MAX_VALUE);
            node.setParent(null);
        }

        sourceNode.setDistance(0);
    }

    private WeightedNode getShortestDistanceNode(Set<WeightedNode> unvisited) {
        int smallest = Integer.MAX_VALUE;
        WeightedNode smallestNode = null;

        for (WeightedNode node : unvisited) {
            if (node.getDistance() < smallest) {
                smallestNode = node;
                smallest = node.getDistance();
            }
        }

        return smallestNode;
    }

    private void printAllPathsOfNeighboringNodes() {
        for (WeightedNode node : nodes) {
            System.out.print(String.format("WeightedNode %s: Distance = %d: ", node.getName(), node.getDistance()));
            printPathOfNode(node);
            System.out.println();
        }

        System.out.println();
    }

    private void printPathOfNode(WeightedNode node) {
        if (node.getParent() != null) {
            printPathOfNode(node.getParent());
            System.out.print(" -> " + node.getName());
        } else {
            System.out.print(node.getName());
        }
    }
}
