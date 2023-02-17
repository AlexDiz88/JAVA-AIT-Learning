package PropertyChangeListener;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ItNews extends SocialMedia{

    public ItNews() {
        super();
    }

    @Override
    public void setNews(News news) {
        if (news.getNewsImportance() == NewsImportance.IMPORTANT_NEWS) {
            support.firePropertyChange("important IT news", actualNews, news);
        }
        this.actualNews = news;
        newsArchive.add(news);
    }
}
