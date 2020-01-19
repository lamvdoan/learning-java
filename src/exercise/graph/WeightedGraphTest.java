package exercise.graph;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraphTest {
    public static void main(String[] args) {
        List<WeightedNode> nodes = new ArrayList<>();
        WeightedGraph graph = new WeightedGraph(nodes);

        /* Limited to directions */
//        for (int i = 0; i < 6; i++) {
//            nodes.add(new WeightedNode("" + (char) (65 + i)));
//        }
//
//        graph.addWeightedEdge(0, 1, 3);
//        graph.addWeightedEdge(0, 4, 10);
//        graph.addWeightedEdge(1, 2, 2);
//        graph.addWeightedEdge(1, 3, 5);
//        graph.addWeightedEdge(1, 4, 2);
//        graph.addWeightedEdge(2, 3, 4);
//        graph.addWeightedEdge(2, 0, 7);
//        graph.addWeightedEdge(3, 2, 1);
//        graph.addWeightedEdge(3, 5, 1);
//        graph.addWeightedEdge(4, 3, 2);
//        graph.addWeightedEdge(4, 5, 4);
//        graph.addWeightedEdge(5, 0, 5);
//
//        graph.dijkstra(nodes.get(0));


        /*  Bi-directional  */
        for (int i = 0; i < 5; i++) {
            nodes.add(new WeightedNode("" + (char) (65 + i)));
        }

        graph.addWeightedEdge(0, 2, 1);
        graph.addWeightedEdge(0, 3, 2);
        graph.addWeightedEdge(0, 4, 7);
        graph.addWeightedEdge(1, 2, 7);
        graph.addWeightedEdge(1, 3, 2);
        graph.addWeightedEdge(1, 4, 3);
        graph.addWeightedEdge(2, 3, 6);
        graph.addWeightedEdge(2, 4, 3);
        graph.addWeightedEdge(3, 4, 5);

        graph.dijkstra(nodes.get(1));
    }
}
