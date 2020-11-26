package library.domain;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import library.dao.ReadingTipDao;
import library.dao.ReadingTipDatabaseDao;

import library.dao.ReadingTipDao;

public class ReadingTipService {

    private ReadingTipDao readingTipDao;

    public ReadingTipService() {
        readingTipDao = new ReadingTipDatabaseDao("jdbc:sqlite:readingtip.db");
    }

    public void createTip(String author, String title) throws Exception {
        System.out.println("kutsuuku");
        BookTip bt = new BookTip(title);
        bt.setAuthor(author);
        readingTipDao.addTip(bt);
    }
}
