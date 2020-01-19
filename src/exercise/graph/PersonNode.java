package exercise.graph;

import java.util.HashSet;
import java.util.Set;

public class PersonNode {
    private String name;
    private Set<PersonNode> friends = new HashSet<>();

    public PersonNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<PersonNode> getFriends() {
        return friends;
    }

    public void addFriend(PersonNode friend) {
        friends.add(friend);

        if (!friend.getFriends().contains(this)) {
            friend.addFriend(this);
        }
    }
}
