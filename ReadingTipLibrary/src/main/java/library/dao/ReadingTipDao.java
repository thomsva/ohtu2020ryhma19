package library.dao;

import java.util.List;
import library.domain.ReadingTip;

/**
 * ReadingTipDao Interface.
 */
public interface ReadingTipDao {

    void addTip(ReadingTip bookTip) throws Exception;
    
    void removeTip(String id) throws Exception;

    List<ReadingTip> getAllTips() throws Exception;

    List<ReadingTip> searchTip(String searchTerm,String searchType) throws Exception;
}
