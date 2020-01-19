package mediator_pattern.main;

import mediator_pattern.chat.ChatMediator;
import mediator_pattern.chat.ChatMediatorImpl;
import mediator_pattern.chat.User;
import mediator_pattern.chat.UserImpl;

public class ChatDemo {
    public static void main(String[] args) {
        ChatMediator chat = new ChatMediatorImpl();

        User lam = new UserImpl(chat, "Lam");
        User jackie = new UserImpl(chat, "Jackie");
        User nick = new UserImpl(chat, "Nick");
        User thanh = new UserImpl(chat, "Thanh");

        chat.addUsers(lam);
        chat.addUsers(jackie);
        chat.addUsers(nick);
        chat.addUsers(thanh);

        lam.send("Hello all!");
    }
}
