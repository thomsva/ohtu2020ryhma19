package library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import library.domain.BookTip;
import library.domain.ReadingTip;

public class ReadingTipDatabaseDao implements ReadingTipDao {

    private String databaseAddress;

    public ReadingTipDatabaseDao(String databaseAddress) {
        this.databaseAddress = databaseAddress;
    }

    @Override
    public List<BookTip> getAllTips() throws Exception {

        Connection conn = DriverManager.getConnection(databaseAddress);
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM ReadingTip");

        List<BookTip> readingTips = new ArrayList<>();

        while (result.next()) {
            String title = result.getString("title");
            String author = result.getString("author");
            int id = result.getInt("id");

            BookTip readingTip = new BookTip(title);
            readingTip.setAuthor(author);
            readingTips.add(readingTip);
        }

        conn.close();

        return readingTips;

    }

    @Override
    public void addTip(BookTip Booktip) throws Exception {

        Connection conn = DriverManager.getConnection(databaseAddress);

        Statement s = conn.createStatement();
        try {

            s.execute("CREATE TABLE ReadingTip (id INTEGER PRIMARY KEY, title, author)");
        } catch (Exception e) {
            System.out.println(" fail");
        }
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO ReadingTip (title,author) "
                + "VALUES (?,?)");

        stmt.setString(1, Booktip.getTitle());
        stmt.setString(2, Booktip.getAuthor());
        stmt.execute();

        conn.close();
    }

//    @Override
//    public void removeTip(String id) throws Exception {
//        
//        Connection conn = DriverManager.getConnection(databaseAddress);
//        PreparedStatement stmt = conn.prepareStatement("DELETE FROM ReadingTip WHERE id = ?");
//        stmt.setInt(1, Integer.parseInt(id));
//        stmt.execute();
//        conn.close();
//    }
}
