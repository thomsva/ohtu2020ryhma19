
package library.domain;

/** A ReadingTip of type BlogPostTip. */
public class BlogPostTip implements ReadingTip {
    
    private String title;
    private String author;
    private String url;
    private String[] tags;
    private String[] relatedCourses;
    private final String type = "blogpost";
    
    public BlogPostTip(String title) {
        this.title = title;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String[] getTags() {
        return tags;
    }

    @Override
    public String[] getRelatedCourses() {
        return relatedCourses;
    }

    @Override
    public void setMoreInfo1(String author) {
        this.author = author;
    }

    @Override
    public void setMoreInfo2(String url) {
        this.url = url;
    }

    @Override
    public String getMoreInfo1() {
        return author;
    }

    @Override
    public String getMoreInfo2() {
        return url;
    }
    
}
