/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.domain;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import library.domain.ReadingTip;

public class ReadingTipServiceTest   {

    FakeReadingTipDao fakeTip;
    ReadingTipService service;

    public ReadingTipServiceTest() {
    }

//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
    @Before
    public void setUp() throws Exception {
        fakeTip = new FakeReadingTipDao();
        service = new ReadingTipService();
        
        fakeTip.addTip(new BookTip("First title"));
        fakeTip.addTip(new BookTip("Second title"));
        fakeTip.addTip(new BookTip("Third title"));
       
    }
    @Test
    public void atStartListContainsSetUpValues() throws Exception{
       List<ReadingTip> readingTips = fakeTip.getAllTips();
        assertEquals(3, readingTips.size());
    }
    @Test
    public void readingTipContainsAllValues() throws Exception{
        List<ReadingTip> readingTips = fakeTip.getAllTips();
        
        
    }
    @Test
    public void aBookTipCanBeCreated() throws Exception{
        fakeTip.addTip(new BookTip("Forth title"));
        
        
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
