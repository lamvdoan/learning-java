package mediator_pattern.chat;

public abstract class User {
    ChatMediator chatMediator;
    String name;

    public User(ChatMediator chatMediator, String name) {
        this.chatMediator = chatMediator;
        this.name = name;
    }

    public abstract void send(String message);
    public abstract void receive(String message);
}
