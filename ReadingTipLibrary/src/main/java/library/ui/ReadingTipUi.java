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

    public ReadingTipUi(IO io) {
        this.io = io;
    }

    /**
     * Starts the user interface.
     */
    public void start() throws Exception {

        service = new ReadingTipService();
        this.searchResults = service.browseReadingTips();

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
                listSearchResults();
            } else if (command.equals("C")) {
                io.print("This option is coming soon. Thank you for being patient!");
            } else if (command.equals("Q")) {
                break;
            } else {
                io.print("Oops, command not existing! Try again.");
            }
        }
    }

    private void printOptions() {
        io.print("You can...");
        io.print("(A)dd a new reading tip"); 
        io.print("(M)odify an existing reading tip"); //coming soon
        io.print("(L)ist search result"); //currently lists all
        io.print("(C)hange search criteria"); //coming soon
        io.print("(Q)uit");
    }

    private void createReadingTip() throws Exception {
        String title = io.readLine("What is the title of the reading tip?");
        printTypes();
        String type = io.readLine("What kind of reading tip it is?");
        ReadingTip tip = service.createTip(type.toLowerCase(), title);
        io.print(tip.toString());
    }

    private void printTypes() {
        io.print("What kind of reading tip it is?");
        io.print("Options:");
        io.print("Blogpost");
        io.print("Book");
        io.print("Podcast");
        io.print("Video");
    }

    private void listSearchResults() throws Exception {
        for (int i = 0; i < searchResults.size(); i++) {
            io.print("Nr: " + i);
            io.print(searchResults.get(i).toString());
            io.print("---");
        }
    }
}
