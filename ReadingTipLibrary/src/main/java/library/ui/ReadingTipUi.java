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

    public void start() throws Exception {
        start(new ReadingTipService());
    }
    
    /**
     * Starts the user interface.
     */
    void start(ReadingTipService rts) throws Exception {
        
        service = rts;
        searchResults = service.browseReadingTips();
        
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
                modifyTip();
            } else if (command.equals("L")) {
                getAllTips();
            } else if (command.equals("S")) {
                searchTip();
            } else if (command.equals("D")) {
                removeTip();
            } else if (command.equals("R")) {
                markAsRead();
            } else if (command.equals("U")) {
                markAsUnread();
            } else if (command.equals("Q")) {
                break;
            } else {
                io.print("Oops, command does not exist! Try again.");
            }
        }
    }
    
    private void removeTip() throws Exception {
        String id = io.readLine("What is the id of the reading tip you want to delete?");
        if (getOneTip(id) == null) {
            io.print("Reading tip doesn't exist.");
        } else {
            service.removeTip(id);
            io.print("Reading tip is deleted.");
        }
    }
    
    private void modifyTip() throws Exception {
        String id = io.readLine("What is the id of the reading tip you want to modify?");
        if (getOneTip(id) == null) {
            io.print("Reading tip doesn't exist.");
        } else {
            io.print(getOneTip(id).toString());
            String newTitle = io.readLine("What is the new title of the reading tip?");
            String[] otherInfo = askMoreInfoByType(getOneTip(id).getType());
            service.modifyTip(id, newTitle, otherInfo[0], otherInfo[1]);
            io.print(getOneTip(id).toString());
        }
    }
    
    private void markAsRead() throws Exception {
        String id = io.readLine("What is the id of the reading tip you want to mark as read?");
        if (getOneTip(id) == null) {
            io.print("Reading tip doesn't exist.");
        } else {
            service.markAsRead(id);
            io.print(getOneTip(id).toString());
        }
    }
    
    private void markAsUnread() throws Exception {
        String id = io.readLine("What is the id of the reading tip you want to mark as unread?");
        if (getOneTip(id) == null) {
            io.print("Reading tip doesn't exist.");
        } else {
            service.markAsUnread(id);
            io.print(getOneTip(id).toString());
        }
    }
    
    private void createReadingTip() throws Exception {
        String title = io.readLine("What is the title of the reading tip?");
        printTypes();
        String type = io.readLine("What kind of reading tip it is?");
        String[] additionalInfo = askMoreInfoByType(type);
        ReadingTip tip = service.createTip(type.toLowerCase(), title, additionalInfo[0], additionalInfo[1]);

        //io.print(tip.toString());
    }
    
    private String[] askMoreInfoByType(String type) {
        
        String[] additionalInfo = new String[2];
        
        if (type.toLowerCase().equals("book")) {
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
        io.print("(M)odify an existing reading tip");
        io.print("(D)elete a reading tip");
        io.print("(L)ist all reading tips");
        io.print("(S)earch reading tips by criteria");
        io.print("Mark reading tip as (R)ead or (U)nread");
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
    
    private void printSearchFields() {
        io.print("What field would you like to search in?");
        io.print("Options:");
        io.print("Type");
        io.print("Title");
        
    }
    
    private void getAllTips() throws Exception {
        searchResults = service.browseReadingTips();
        listSearchResults();
    }
    
    private ReadingTip getOneTip(String id) throws Exception {
        ReadingTip tip = service.getOneTip(id);
        return tip;
    }
    
    private void searchTip() throws Exception {
        printSearchFields();
        String searchField = io.readLine("");
        
        String SearchTerm = io.readLine("Input search term:");
        
        searchResults = service.searchTip(SearchTerm, searchField.toLowerCase());
        listSearchResults();
    }
    
    private void listSearchResults() throws Exception {
        for (int i = 1; i <= searchResults.size(); i++) {
            io.print(searchResults.get(i - 1).toString());
            io.print("");
        }
    }
}
