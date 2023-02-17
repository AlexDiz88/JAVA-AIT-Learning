package PropertyChangeListener;

public class News {

    private String newsMessage;
    private NewsType newsType;
    private NewsImportance newsImportance;

    public News(String newsMessage, NewsType newsType, NewsImportance newsImportance) {
        this.newsMessage = newsMessage;
        this.newsType = newsType;
        this.newsImportance = newsImportance;
    }

    @Override
    public String toString() {
        return newsMessage;
    }

    public String getNewsMessage() {
        return newsMessage;
    }

    public NewsType getNewsType() {
        return newsType;
    }

    public NewsImportance getNewsImportance() {
        return newsImportance;
    }
}
