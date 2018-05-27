package com.example.android.computersciencenews;


public class News {
    // Title of the news
    private String mTitle;

    // Section of the news
    private String mSectionName;

    // When the news has been published
    private String mPublicationDate;

    // The website URL to find more details about the news
    private String mUrl;

    // The author of the article
    private String mAuthor;

    // Constructs a new News object
    public News(String title, String sectionName, String publicationDate, String url, String author) {
        mTitle = title;
        mSectionName = sectionName;
        mPublicationDate = publicationDate;
        mUrl = url;
        mAuthor = author;
    }

    public News(String title, String sectionName, String publicationDate, String url){
        mTitle = title;
        mSectionName = sectionName;
        mPublicationDate = publicationDate;
        mUrl = url;
    }

    // Returns the title of the news
    public String getTitle() {
        return mTitle;
    }

    // Returns the section of the news
    public String getSectionName() {
        return mSectionName;
    }

    // Returns the publication date
    public String getPublicationDate() {
        return mPublicationDate;
    }

    // Returns the website URL to find more details
    public String getUrl() {
        return mUrl;
    }

    // Returns the author name of the article
    public String getAuthor() { return mAuthor; }
}
