package library.domain;

/** A ReadingTip of type BookTip. */
public class BookTip implements ReadingTip {

    private int id;
    private String title;
    private String[] tags;
    private String[] relatedCourses;
    private String author;
    private String isbn;
    private final String type = "book";

    public BookTip(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {

    }

    @Override
    public String getType() {
        return type;
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
    public void setMoreInfo2(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String getMoreInfo1() {
        return author;
    }

    @Override
    public String getMoreInfo2() {
        return isbn;
    }
    
    @Override
    public String toString() {
        return "Author: " + author + "\nTitle: " + title + "\nType: " + type + "\nISBN: " + isbn;
    }

    @Override
    public int getId() {
       return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
