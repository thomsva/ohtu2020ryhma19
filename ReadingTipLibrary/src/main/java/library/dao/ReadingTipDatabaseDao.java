package library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import library.domain.BlogPostTip;
import library.domain.BookTip;
import library.domain.PodcastTip;
import library.domain.ReadingTip;
import library.domain.VideoTip;

/**
 * ReadingTipDatabaseDao Class. Used to access ReadingTips in the database.
 */
public class ReadingTipDatabaseDao implements ReadingTipDao {

    private String databaseAddress;

    public ReadingTipDatabaseDao(String databaseAddress) {
        this.databaseAddress = databaseAddress;
    }

    @Override
    public List<ReadingTip> getAllTips() throws Exception {

        Connection conn = DriverManager.getConnection(databaseAddress);
        List<ReadingTip> readingTips = new ArrayList<>();

        try {

            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM ReadingTip");

            while (result.next()) {

                int id = result.getInt("id");
                String type = result.getString("type");
                String title = result.getString("title");

                ReadingTip readingTip = createTipWithType(type, title);

                String info1 = result.getString("info1");
                String info2 = result.getString("info2");
                
                readingTip.setId(id);
                readingTip.setMoreInfo1(info1);
                readingTip.setMoreInfo2(info2);
                readingTips.add(readingTip);
            }

        } catch (Exception e) {
            System.out.println("Database is empty.");
        }

        conn.close();

        return readingTips;

    }

    @Override
    public List<ReadingTip> getTipByAuthor(String author) throws Exception {
        Connection conn = DriverManager.getConnection(databaseAddress);
        List<ReadingTip> readingTips = new ArrayList<>();
        try {
            //Statement stmt = conn.createStatement();
            //ResultSet result = stmt.executeQuery("SELECT * from ReadingTip WHERE author=?");
            PreparedStatement p = conn.prepareStatement("SELECT hinta FROM Tuotteet WHERE nimi=?");
            p.setString(1, author);

            ResultSet result = p.executeQuery();

            while (result.next()) {
                
                int id = result.getInt("id");
                String type = result.getString("type");
                String title = result.getString("title");
                String info1 = result.getString("info1");
                String info2 = result.getString("info2");

                ReadingTip readingtip = createTipWithType(type, title);
                readingtip.setId(id);
                readingtip.setMoreInfo1(info1);
                readingtip.setMoreInfo2(info2);
                readingTips.add(readingtip);
            }
        } catch (Exception e) {

        }
        return readingTips;

    }

    @Override
    public void addTip(ReadingTip readingTip) throws Exception {

        Connection conn = DriverManager.getConnection(databaseAddress);
        createSchemaIfNotExists(conn);

        PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO ReadingTip (type,title,info1,info2) "
                + "VALUES (?,?,?,?)");

        stmt.setString(1, readingTip.getType());
        stmt.setString(2, readingTip.getTitle());
        stmt.setString(3, readingTip.getMoreInfo1());
        stmt.setString(4, readingTip.getMoreInfo2());
        stmt.execute();

        conn.close();
    }

        @Override
        public void removeTip(String id) throws Exception {
            
            Connection conn = DriverManager.getConnection(databaseAddress);
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM ReadingTip WHERE id = ?");
            stmt.setInt(1, Integer.parseInt(id));
            stmt.executeUpdate();
            conn.close();
        }
    /**
     * Creates ReadingTip table if it doesn't exist.
     */
    public void createSchemaIfNotExists(Connection conn) throws SQLException {

        Statement stmt = conn.createStatement();

        try {

            stmt.execute(
                    "CREATE TABLE ReadingTip (id INTEGER PRIMARY KEY, type, title, info1, info2)");
        } catch (Exception e) {
            System.out.println("Database schema already exists.");
        }

    }

    /**
     * Creates new ReadingTip.
     */
    public ReadingTip createTipWithType(String type, String title) {

        ReadingTip tip;

        if (type.equals("book")) {
            tip = new BookTip(title);
        } else if (type.equals("blogpost")) {
            tip = new BlogPostTip(title);
        } else if (type.equals("video")) {
            tip = new VideoTip(title);
        } else {
            tip = new PodcastTip(title);
        }

        return tip;
    }

}
