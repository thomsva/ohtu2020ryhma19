package library.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import library.domain.ReadingTip;

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

/**
 *
 * @author nicholas
 */
public class ReadingTipDaoTest implements ReadingTipDao {

    List<ReadingTip> readingTips;

    public ReadingTipDaoTest() {
        readingTips = new ArrayList<>();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Override
    public void addTip(ReadingTip bookTip) throws Exception {
        readingTips.add(bookTip);

    }

    @Override
    public List<ReadingTip> getAllTips() throws Exception {
        return readingTips;
    }
}
