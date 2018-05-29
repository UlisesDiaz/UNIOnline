package ni.edu.uni.www.unionline;

/**
 * Created by ulises diaz on 17/05/2018.
 */

public class ModelNews {

    private int image;
    private String newsTitle, newsDetails, newsCreateDate;
    public ModelNews()
    {}
    public ModelNews(int image, String newsTitle, String newsDetails, String newsCreateDate) {
        this.image = image;
        this.newsTitle = newsTitle;
        this.newsDetails = newsDetails;
        this.newsCreateDate = newsCreateDate;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsDetails() {
        return newsDetails;
    }

    public void setNewsDetails(String newsDetails) {
        this.newsDetails = newsDetails;
    }

    public String getNewsCreateDate() {
        return newsCreateDate;
    }

    public void setNewsCreateDate(String newsCreateDate) {
        this.newsCreateDate = newsCreateDate;
    }
}
