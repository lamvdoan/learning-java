package exercise.graph;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class SolutionDijkstra {
	ArrayList<SolutionWeightedNode> nodeList = new ArrayList<SolutionWeightedNode>();


	//Constructor
	public SolutionDijkstra(ArrayList<SolutionWeightedNode> nodeList) {
		this.nodeList = nodeList;
	}


	//Dijkstra from a Source WeightedNode
	void dijkstra(SolutionWeightedNode node) {
		PriorityQueue<SolutionWeightedNode> queue = new PriorityQueue<>();
		node.setDistance(0); //This will make sure that we start from this vertex in priority queue as distance is min
		queue.addAll(nodeList);
		while(!queue.isEmpty()) {
			SolutionWeightedNode presentNode = queue.remove(); //remove node with minimum distance from queue
			for(SolutionWeightedNode neighbor: presentNode.getNeighbors()) { //for each neighbor
				if(queue.contains(neighbor)) { //if neighbor is not visited
					// if 'known distance' of neighbor is greater than new path then,
					// update 'distance' of neighbor
					// and also new parent as presentNode
					if(neighbor.getDistance() > (presentNode.getDistance()+presentNode.getWeightMap().get(neighbor))) {
						neighbor.setDistance((presentNode.getDistance()+presentNode.getWeightMap().get(neighbor)));
						neighbor.setParent(presentNode);
						//Refresh the Priority Queue
						queue.remove(neighbor);
						queue.add(neighbor);
					}//end of if block
				}//end of if block
			}//end of for loop
		}//end of while loop


		//print table of node with minimum distance and shortest path from source
		for(SolutionWeightedNode nodeToCheck: nodeList) {
			System.out.print("WeightedNode "+nodeToCheck+", distance: "+nodeToCheck.getDistance()+", Path: ");
			pathPrint(nodeToCheck);
			System.out.println();
		}
	}//end of method


	private static void pathPrint(SolutionWeightedNode node) {
		if(node.getParent()!=null) {
			pathPrint(node.getParent());
			System.out.print("->"+node);
		}
		else
			System.out.print(node);
	}//end of method


	// add a weighted directed edge between two nodes
	public void addWeightedEdge(int i, int j, int d) {
		SolutionWeightedNode first = nodeList.get(i-1);
		SolutionWeightedNode second = nodeList.get(j-1);
		first.getNeighbors().add(second);
		first.getWeightMap().put(second,d);
	}//end of method

}//end of class



