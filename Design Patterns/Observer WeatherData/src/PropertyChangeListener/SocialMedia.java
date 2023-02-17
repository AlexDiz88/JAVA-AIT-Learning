package PropertyChangeListener;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public abstract class SocialMedia {
    protected List<News> newsArchive;

    protected List<PropertyChangeListener> listOfSubscribers;
    protected News actualNews;
    protected PropertyChangeSupport support;

    public SocialMedia() {
        this.support = new PropertyChangeSupport(this);
        this.newsArchive = new ArrayList<>();
        this.listOfSubscribers = new ArrayList<>();
    }

    public void addSubscriber(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removeSubscriber(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public abstract void setNews(News mainNews);

    public List<News> getNewsArchive() {
        return newsArchive;
    }

    public PropertyChangeSupport getSupport() {
        return support;
    }
}
