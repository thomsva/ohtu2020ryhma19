package library.dao;

import java.util.List;
import library.domain.BookTip;

public interface ReadingTipDao {

    void addTip(BookTip bookTip) throws Exception;
//    void removeTip(String id) throws Exception;

    List<BookTip> getAllTips() throws Exception;

}
