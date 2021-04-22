


public class YoutubeSubscriber implements Observer {
    private Subject youTubeChannel;
    private String subscriberName;

    public YoutubeSubscriber(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    @Override
    public void update() {
        System.out.println(subscriberName + " has received notification about this publication: " + youTubeChannel.getUpdate());
    }

    public void setSubscriberName(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    @Override
    public void setTopic(Subject subject) {
        this.youTubeChannel = subject;
    }
}
