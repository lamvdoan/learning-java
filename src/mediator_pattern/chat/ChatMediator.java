package mediator_pattern.chat;

public interface ChatMediator {
    void addUsers(User user);
    void sendMessage(String message, User user);
}
