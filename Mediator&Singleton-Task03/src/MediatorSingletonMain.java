
public class MediatorSingletonMain {
    public static void main(String[] args) {

        ChatRoomMediator mediator = new ChatRoomMediator();
        User chatBot = ChatBotSingleton.getInstance();
        chatBot.setName("Bot");

        User tom = new ChatUser(mediator, "Tom");
        User jerry = new ChatUser(mediator, "Jerry");
        User josh = new ChatUser(mediator, "Josh");

        mediator.addUser(tom);
        mediator.addUser(jerry);
        mediator.addUser(josh);

        tom.sendMessage("Hi All");
        josh.sendMessage("Hey Jerry weren't you a mouse");
        jerry.sendMessage("Good morning I will add David");

        User david = new ChatUser(mediator, "David");
        mediator.addUser(david);
        david.sendMessage("Jerry you are a mouse I will add bot to protect you from treats");
        david.sendMessage("addBot");
        jerry.sendMessage("Yes I am. I hate Tom he is a cat");

        tom.sendMessage("See Jerry was removed for saying cat lol");

    }
}
