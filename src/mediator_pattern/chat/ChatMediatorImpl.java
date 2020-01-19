package mediator_pattern.chat;

import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImpl implements ChatMediator {
    private List<User> users;

    public ChatMediatorImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public void addUsers(User user) {
        this.users.add(user);
    }

    @Override
    public void sendMessage(String message, User sender) {
        for(User user : this.users) {
            if (user != sender) {
                user.receive(message);
            }
        }
    }
}
