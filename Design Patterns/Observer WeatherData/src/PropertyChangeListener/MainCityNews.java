package PropertyChangeListener;

public class MainCityNews extends SocialMedia{

    public MainCityNews() {
        super();
    }

    public void setNews(News mainNews) {
        if (mainNews.getNewsType() == NewsType.MAIN_NEWS) {
            support.firePropertyChange("main news", actualNews, mainNews);
        }
        if (mainNews.getNewsType() == NewsType.EVENT_NEWS) {
            support.firePropertyChange("event news", actualNews, mainNews);
        }
        this.actualNews = mainNews;
        newsArchive.add(mainNews);
    }
}
