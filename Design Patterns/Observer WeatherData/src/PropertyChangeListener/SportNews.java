package PropertyChangeListener;

public class SportNews extends SocialMedia{

    public SportNews() {
        super();
    }

    @Override
    public void setNews(News mainNews) {
        support.firePropertyChange("sport news", actualNews, mainNews);
        this.actualNews = mainNews;
        newsArchive.add(mainNews);
    }
}
