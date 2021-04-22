public class ChatUser extends User {

    public ChatUser() {}

    public ChatUser(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    protected void sendMessage(String message) {
        System.out.println("\n" + this.name + ": Sending Message=" + message);
        mediator.sendMessage(message, this);

        if ("addBot".equals(message)) {
            mediator.addUser(ChatBotSingleton.getInstance());
            ChatBotSingleton
                    .getInstance()
                    .setMediator(mediator);
        }
    }

    @Override
    protected void receiveMessage(String message) {
        System.out.println(this.name + ": Received Message:" + message);
    }
}
