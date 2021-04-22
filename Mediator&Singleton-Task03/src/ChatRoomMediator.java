import java.util.ArrayList;
import java.util.List;

public class ChatRoomMediator implements Mediator {

    private final List<User> users;
    private User userToBeRemoved;
    private boolean removeUser;

    {
        removeUser = false;
        users = new ArrayList<>();
    }

    public void setUserToBeRemoved(User userToBeRemoved) {
        this.userToBeRemoved = userToBeRemoved;
        removeUser = true;
    }

    @Override
    public void sendMessage(String message, User user) {
        ChatBotSingleton.getInstance().setLastMessageSender(user);
        users.stream()
                .filter(userReceiving -> !userReceiving.equals(user))
                .forEach(userReceiving -> userReceiving.receiveMessage(message));
        if (removeUser) {
            System.out.println(userToBeRemoved.getName() + " was removed from the room for saying cat");
            removeUser(userToBeRemoved);
            removeUser = false;
            ChatBotSingleton instance = ChatBotSingleton.getInstance();
            instance.sendMessage(instance.name + " warns everybody that cat is restricted word in this chat you will be removed if you use it");
        }
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }
}
