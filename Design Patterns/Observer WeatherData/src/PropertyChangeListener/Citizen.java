package PropertyChangeListener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Citizen implements PropertyChangeListener {

    private City city;
    private String name;
    private boolean getEventNews;

    public Citizen(String name, City city) {
        this.name = name;
        this.city = city;
        city.getMainChannel().addSubscriber(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.setNews((News) evt.getNewValue());
    }

    public void setNews(News news) {
        if (news.getNewsType() == NewsType.MAIN_NEWS) {
            System.out.println(name + " получил новость: " + news);
        }
        if (news.getNewsType() == NewsType.EVENT_NEWS && getEventNews) {
            System.out.println(name + " получил новость: " + news);
        }
    }

    public void switchOnEventsNotification() {
        getEventNews = true;
    }

    public void switchOffEventsNotification() {
        getEventNews = false;
    }

    public List<News> getRegularItNews() {
        List<News> result = new ArrayList<>();
        SocialMedia itNews = null;
        for (SocialMedia channel : city.getNewsChannels()) {
            if (channel instanceof ItNews) {
                itNews = channel;
                break;
            }
        }
        if (itNews == null) return result;
        List<PropertyChangeListener> pclList = List.of(itNews.getSupport().getPropertyChangeListeners());
        if (!pclList.contains(this)) {
            System.out.println(name + " не подписан на IT News");
            return result;
        }
        ListIterator<News> iterator = itNews.getNewsArchive().listIterator(itNews.getNewsArchive().size());
        int counter = 0;
        while (iterator.hasPrevious() && counter < 3) {
            result.add(iterator.previous());
            counter++;
        }
        displayNews(result);
        return result;
    }

    private void displayNews(List<News> result) {
        result.forEach((el)-> System.out.println(name + " получает новость: " + el));
    }

    @Override
    public String toString() {
        return name;
    }
}
