package library.ui;

import java.util.List;
import library.domain.ReadingTip;
import library.domain.ReadingTipService;
import library.io.IO;

/**
 * The user interface.
 */
public class ReadingTipUi {

    ReadingTipService service;
    private IO io;
    private List<ReadingTip> searchResults;
    private List<ReadingTip> allTips;

    public ReadingTipUi(IO io) {
        this.io = io;
    }

    /**
     * Starts the user interface.
     */
    public void start() throws Exception {

        service = new ReadingTipService();

        this.allTips = service.browseReadingTips();
        io.print("Hello user!");

        while (true) {
            printOptions();
            String command = io.readLine("Give a command:");

            if (command.isEmpty()) {
                break;
            }

            if (command.equals("A")) {
                createReadingTip();
            } else if (command.equals("M")) {
                io.print("This option is coming soon. Thank you for being patient!");
            } else if (command.equals("L")) {
                listSearchResults(allTips);
            } else if (command.equals("C")) {
                io.print("This option is coming soon. Thank you for being patient!");
            } else if (command.equals("D")) {
                removeTip();
            } else if (command.equals("S")) {
                searchTip();
            } else if (command.equals("Q")) {
                break;
            } else {
                io.print("Oops, command does not exist! Try again.");
            }
        }
    }

    private void removeTip() throws Exception {
        String id = io.readLine("What is the id of the reading tip you want to delete?");
        printTypes();
        service.removeTip(id);

    }

    private void createReadingTip() throws Exception {
        String title = io.readLine("What is the title of the reading tip?");
        printTypes();
        String type = io.readLine("What kind of reading tip it is?");
        String[] additionalInfo = askMoreInfoByType(type);
        ReadingTip tip = service.createTip(type.toLowerCase(), title, additionalInfo[0], additionalInfo[1]);

        io.print(tip.toString());
    }

    private String[] askMoreInfoByType(String type) {

        String[] additionalInfo = new String[2];

        if (type.equals("book")) {
            additionalInfo[0] = io.readLine("Who is the author?");
            additionalInfo[1] = io.readLine("What is the ISBN number?");
        } else {
            additionalInfo[0] = "---";
            additionalInfo[1] = "---";
        }

        return additionalInfo;
    }

    private void printOptions() {
        io.print("You can...");
        io.print("(A)dd a new reading tip");
        io.print("(M)odify an existing reading tip"); //coming soon
        io.print("(L)ist search result"); //currently lists all
        io.print("(D)delete tip"); //delete tip
        io.print("(C)hange search criteria"); //coming soon
        io.print("(S)earch reading tips"); //coming soon
        io.print("(Q)uit");
    }

    private void printTypes() {
        io.print("What kind of reading tip it is?");
        io.print("Options:");
        io.print("Blogpost");
        io.print("Book");
        io.print("Podcast");
        io.print("Video");
    }

    private void searchTip() throws Exception {
        printSearchTypes();
        String searchType = io.readLine("Choose search type");

        String SearchTerm = io.readLine("Give your searchterm");

        searchResults = service.searchTip(SearchTerm, searchType);
        listSearchResults(searchResults);
    }

    private void printSearchTypes() {
        io.print("Type");
        io.print("Title");

    }

    private void listSearchResults(List list) throws Exception {
        for (int i = 0; i < list.size(); i++) {
            io.print("Nr: " + i);
            io.print(list.get(i).toString());
            io.print("---");
        }
    }
}
