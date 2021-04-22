import java.util.Arrays;

public class ChatBotSingleton extends ChatUser {

    private User lastMessageSender;
    private ChatBotSingleton(){}

    //double checked locking principle for thread safety
/*    private static ChatBotSingleton instance;
    public static ChatBotSingleton getInstanceUsingDoubleLocking(){
        if(instance == null){
            synchronized (ChatBotSingleton.class) {
                if(instance == null){
                    instance = new ChatBotSingleton();
                }
            }
        }
        return instance;
    }*/

    //Bill Pugh approach to avoid double checking above showed
    private static class SingletonHelperBillPugh {
        private static final ChatBotSingleton INSTANCE = new ChatBotSingleton();
    }

    public static ChatBotSingleton getInstance() {
        return SingletonHelperBillPugh.INSTANCE;
    }

    @Override
    protected void receiveMessage(String message) {
        if (message != null) {
            String[] splitStrings = message.split(" ");
            long count = Arrays.stream(splitStrings)
                    .filter("cat"::equals)
                    .count();

            if (count >= 1l) {
                ((ChatRoomMediator) mediator).setUserToBeRemoved(lastMessageSender);
            }
        }
    }

    public void setLastMessageSender(User lastMessageSender) {
        this.lastMessageSender = lastMessageSender;
    }

}
