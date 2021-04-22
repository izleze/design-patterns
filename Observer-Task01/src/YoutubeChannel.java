import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements Subject {

    private final List<Observer> channelSubscribers;
    private String message;

    {
        channelSubscribers = new ArrayList<>();
        message = "Default message";
    }

    @Override
    public void register(Observer subscriber) {
        this.channelSubscribers.add(subscriber);
    }

    @Override
    public void unregister(Observer subscriber) {
        this.channelSubscribers.remove(subscriber);
    }

    @Override
    public void notifyObservers() {
        channelSubscribers.forEach(Observer::update);
    }

    @Override
    public String getUpdate() {
        return this.message;
    }

    public void postMessage(String message) {
        this.message = message;
        System.out.println("New message was posted: " + message);
        notifyObservers();
    }
}
