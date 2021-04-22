

public class ObserverMain {

    public static void main(String[] args) {
        YoutubeSubscriber josh = new YoutubeSubscriber("Josh");
        YoutubeSubscriber tom = new YoutubeSubscriber("Tom");
        YoutubeSubscriber jerry = new YoutubeSubscriber("Jerry");

        YoutubeChannel channel = new YoutubeChannel();
        channel.postMessage("Should not be received");

        josh.setTopic(channel);
        channel.register(josh);
        tom.setTopic(channel);
        channel.register(tom);

        channel.postMessage("Hello today video is send to 2 subscribers Josh, Tom");

        jerry.setTopic(channel);
        channel.register(jerry);

        josh.setTopic(null);
        channel.unregister(josh);

        channel.postMessage("Hello new subscriber Jerry, goodbye Josh");

    }
}
