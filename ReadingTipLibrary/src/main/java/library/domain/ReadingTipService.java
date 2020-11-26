package library.domain;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import library.dao.ReadingTipDao;
import library.dao.ReadingTipDatabaseDao;

import library.dao.ReadingTipDao;

public class ReadingTipService {

    private ReadingTipDao readingTipDao;

    public ReadingTipService() {
        readingTipDao = new ReadingTipDatabaseDao("jdbc:sqlite:readingtip.db");
    }

    public void createTip(String type, String title, String info1, String info2) throws Exception {

        ReadingTip rt = createTipWithType(type, title);
        rt.setMoreInfo1(info1);
        rt.setMoreInfo2(info2);
        readingTipDao.addTip(rt);
    }

    public List<ReadingTip> browseReadingTips() throws Exception {
        List<ReadingTip> tipList = readingTipDao.getAllTips();
        
        for (ReadingTip tip : tipList) {
            System.out.println(tip.toString());
        }
        
        return tipList;
    }

    public ReadingTip createTipWithType(String type, String title) {

        ReadingTip tip;

        if (type.equals("book")) {
            tip = new BookTip(title);
        } else if (type.equals("blogpost")) {
            tip = new BlogPostTip(title);
        } else if (type.equals("video")) {
            tip = new VideoTip(title);
        } else {
            tip = new PodcastTip(title);
        }

        return tip;
    }
}
