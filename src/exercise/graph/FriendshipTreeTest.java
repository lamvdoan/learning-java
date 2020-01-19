package exercise.graph;

public class FriendshipTreeTest {
    public static void main(String[] args) {
        /* Create each person */
        PersonNode lam = new PersonNode("Lam");
        PersonNode jackie = new PersonNode("Jackie");
        PersonNode shashin = new PersonNode("Shashin");
        PersonNode cindy = new PersonNode("Cindy");
        PersonNode hetal = new PersonNode("Hetal");
        PersonNode vishal = new PersonNode("Vishal");
        PersonNode bob = new PersonNode("Bob");

        FriendshipTree lamsGraph = new FriendshipTree(lam);

        /* Create the relationship circle */
        lam.addFriend(vishal);
        lam.addFriend(shashin);
        lam.addFriend(jackie);
        shashin.addFriend(jackie);
        jackie.addFriend(cindy);
        cindy.addFriend(hetal);
        hetal.addFriend(vishal);


        System.out.println("*** Breadth First Search ***");
        lamsGraph.breadthFirstSearch(shashin);
        lamsGraph.breadthFirstSearch(vishal);
        lamsGraph.breadthFirstSearch(jackie);
        lamsGraph.breadthFirstSearch(hetal);
        lamsGraph.breadthFirstSearch(cindy);
        lamsGraph.breadthFirstSearch(bob);

        System.out.println("\n*** Depth First Search ***");
        lamsGraph.depthFirstSearch(shashin);
        lamsGraph.depthFirstSearch(vishal);
        lamsGraph.depthFirstSearch(jackie);
        lamsGraph.depthFirstSearch(hetal);
        lamsGraph.depthFirstSearch(cindy);
        lamsGraph.depthFirstSearch(bob);
    }
}
