package library.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import library.domain.ReadingTip;

public class ReadingTipDatabaseDaoTest implements ReadingTipDao {

    ReadingTipDatabaseDao ReadingDatabase;
    List<ReadingTip> readingTips;

    public ReadingTipDatabaseDaoTest() {
        readingTips = new ArrayList<>();
    }

    @Before
    public void setUp() {
        //ReadingDatabase = new ReadingTipDatabaseDao("jdbc:sqlite:test.db");

    }

    @Override
    public void addTip(ReadingTip bookTip) throws Exception {

        readingTips.add(bookTip);
    }

    @Override
    public List<ReadingTip> getAllTips() throws Exception {
        return readingTips;
    }
}
