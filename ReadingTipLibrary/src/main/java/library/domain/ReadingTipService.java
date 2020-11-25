
package library.domain;
import library.dao.ReadingTipDao;
import library.dao.ReadingTipDatabaseDao;

import library.dao.ReadingTipDao;

public class ReadingTipService {

    
    private ReadingTipDao readingTipDao;
    
    public ReadingTipService() {
        readingTipDao = new ReadingTipDatabaseDao("jdbc:sqlite:readingtip.db");
    }

}
