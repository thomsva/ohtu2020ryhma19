package library.domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import library.dao.ReadingTipDao;
import library.domain.ReadingTip;

public class FakeReadingTipDaoTest implements ReadingTipDao {

    List<ReadingTip> readingTips;

    public FakeReadingTipDaoTest() {
        readingTips = new ArrayList<>();
    }

    @Override
    public void addTip(ReadingTip bookTip) throws Exception {
        readingTips.add(bookTip);

    }

    @Override
    public List<ReadingTip> getAllTips() throws Exception {
        return readingTips;
    }

    @Override
    public List<ReadingTip> getTipByAuthor(String author) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTip(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
