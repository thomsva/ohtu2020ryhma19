package library.domain;

public interface ReadingTip {
    
    String getType();

    String getTitle();
    
    void SetTitle(String title);
    
    String[] getTags();
    
    String[] getRelatedCourses();
    
    void setMoreInfo1(String info);
    
    void setMoreInfo2(String info);
    
    String getMoreInfo1();
    
    String getMoreInfo2();

}
