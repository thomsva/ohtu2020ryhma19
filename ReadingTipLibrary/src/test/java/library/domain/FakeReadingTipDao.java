/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.domain;

import java.util.ArrayList;
import java.util.List;
import library.dao.ReadingTipDao;

/**
 *
 * @author nicholas
 */
public class FakeReadingTipDao implements ReadingTipDao {

    List<ReadingTip> readingTips;

    public FakeReadingTipDao() {
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
}
