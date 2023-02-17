package PropertyChangeListener;

import java.util.ArrayList;
import java.util.List;

public class City {

    private String title;
    private SocialMedia mainChannel;
    private List<SocialMedia> newsChannels;

    public City(String title) {
        this.title = title;
        this.newsChannels = new ArrayList<>();
    }

    public void setMainChannel(SocialMedia mainChannel) {
        this.mainChannel = mainChannel;
        newsChannels.add(mainChannel);
    }

    public void addChannels(List<SocialMedia> newsChannels) {
        this.newsChannels.addAll(newsChannels);
    }

    public String getTitle() {
        return title;
    }

    public SocialMedia getMainChannel() {
        return mainChannel;
    }

    public List<SocialMedia> getNewsChannels() {
        return newsChannels;
    }
}
