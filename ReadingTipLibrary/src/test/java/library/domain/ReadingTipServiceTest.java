/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import library.domain.ReadingTip;

public class ReadingTipServiceTest {

    FakeReadingTipDaoTest readingTip;
    ReadingTipService service;

    public ReadingTipServiceTest() {
    }

    @Before
    public void setUp() throws Exception {
        readingTip = new FakeReadingTipDaoTest();
        service = new ReadingTipService();
        List<ReadingTip> readingTips = new ArrayList<>();
        readingTip.addTip(new BookTip("First title"));
        readingTip.addTip(new BookTip("Second title"));
        readingTip.addTip(new BookTip("Third title"));
        readingTips.add(new BookTip("First title"));

    }

    @Test
    public void atStartListContainsSetUpValues() throws Exception {
        List<ReadingTip> readingTips = readingTip.getAllTips();
        assertEquals(3, readingTips.size());
    }

    @Test
    public void readingTipContainsAllValues() throws Exception {
        List<ReadingTip> readingTips = readingTip.getAllTips();

    }

    @Test
    public void readingTipContainsSpecificTip() throws Exception {
        List<ReadingTip> readingTips = readingTip.getAllTips();

        assertEquals(readingTips.get(0).getTitle(), "First title");
    }

}
