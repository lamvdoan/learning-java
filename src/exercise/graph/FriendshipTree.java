package exercise.graph;

import java.util.*;

class FriendshipTree {
    private PersonNode source;
    private Set<PersonNode> visited;
    private boolean isFriend;

    FriendshipTree(PersonNode source) {
        this.source = source;
    }

    boolean breadthFirstSearch(PersonNode destination) {
        Queue<PersonNode> queue = new LinkedList<>();
        queue.add(source);

        visited = new HashSet<>();
        visited.add(source);

        while (!queue.isEmpty()) {
            PersonNode person = queue.remove();

            if (person == destination && person != source) {
                printAreFriends(destination);
                return true;
            }

            for (PersonNode friend : person.getFriends()) {
                if (!visited.contains(friend)) {
                    queue.add(friend);
                    visited.add(friend);
                }
            }
        }

        printAreNotFriends(destination);
        return false;
    }

    private void printAreFriends(PersonNode destination) {
        System.out.println(String.format("%s and %s are friends!", source.getName(), destination.getName()));
    }

    private void printAreNotFriends(PersonNode destination) {
        System.out.println(String.format("%s do not know %s.", source.getName(), destination.getName()));
    }

    void depthFirstSearch(PersonNode destination) {
        visited = new HashSet<>();
        isFriend = false;
        depthFirstSearch(source, destination);

        if (isFriend) {
            printAreFriends(destination);
        } else {
            printAreNotFriends(destination);
        }
    }

    private void depthFirstSearch(PersonNode person, PersonNode destination) {
        if (person == destination && person != source) {
            isFriend = true;
            return;
        }

        visited.add(person);

        for (PersonNode friend : person.getFriends()) {
            if (!visited.contains(friend)) {
                depthFirstSearch(friend, destination);
            }
        }
    }
}
