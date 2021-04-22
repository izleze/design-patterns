

public abstract class User {
    protected Mediator mediator;
    protected String name;

    public User() {}

    public User(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public Mediator getMediator() {
        return mediator;
    }

    protected void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected abstract void sendMessage(String message);
    protected abstract void receiveMessage(String message);

}
