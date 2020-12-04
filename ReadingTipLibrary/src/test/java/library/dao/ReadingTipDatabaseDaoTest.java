package library.dao;

import java.util.ArrayList;
import java.util.List;
import library.dao.ReadingTipDatabaseDao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import library.dao.ReadingTipDao;
import library.domain.BookTip;
import library.domain.ReadingTip;

public class ReadingTipDatabaseDaoTest {

    ReadingTipDao testDbDao;
    List<ReadingTip> readingTips;

    @Before
    public void setUp() throws Exception {
        
        testDbDao = new ReadingTipDatabaseDao("jdbc:sqlite:test.db");
        testDbDao.addTip(new BookTip("test1"));
        testDbDao.addTip(new BookTip("test2"));
    }

    @After
    public void tearDown() {
        testDbDao.deleteDatabaseContents();
    }

    @Test
    public void testGetAllTips() throws Exception {
        assertTrue(testDbDao.getAllTips().size()>0);
    }
    
    @Test
    public void testSearchTip() throws Exception {
        
    }
   
    
    @Test
    public void testModifyTip() throws Exception {
        testDbDao.modifyTip("1", "new title", "new info 1", "new info 2");
        BookTip book=(BookTip) testDbDao.getOneTip("1");
        assertEquals("new title",book.getTitle());
        assertEquals("new info 1",book.getMoreInfo1());
        assertEquals("new info 2",book.getMoreInfo2());
    }
    
    @Test
    public void testMarkAsRead() throws Exception {
        testDbDao.markAsRead("1");
        BookTip book=(BookTip) testDbDao.getOneTip("1");
        assertEquals(1,book.getRead());
    }
    
    @Test
    public void testMarkAsUnread() throws Exception {
        testDbDao.markAsUnread("1");
        BookTip book=(BookTip) testDbDao.getOneTip("1");
        assertEquals(0,book.getRead());
    }

}
