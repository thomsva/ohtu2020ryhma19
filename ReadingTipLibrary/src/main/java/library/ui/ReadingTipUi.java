package library.ui;

import java.util.Scanner;
import library.domain.ReadingTip;
import library.domain.ReadingTipService;
import library.io.IO;

/** The user interface. */
public class ReadingTipUi {
    
    Scanner scanner;
    ReadingTipService service;
    private IO io;

    public ReadingTipUi(IO io) {
        this.io = io;
    }
    
    /** Method to start the user interface. */
    public void start() throws Exception {

        service = new ReadingTipService();
        scanner = new Scanner(System.in);

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
                listAllReadingTips();
            } else if (command.equals("Q")) {
                break;
            } else {
                io.print("Oops, command not existing! Try again.");
            }
        }
    }

    private void printOptions() {
        io.print("You can...");
        io.print("(A)dd a new reading tip"); //this is what we have at the moment
        io.print("(M)odify an existing reading tip"); //coming soon

        //coming soon; selecting this allows user to specify searching criteria
        io.print("(L)ist all existing reading tips"); 

        io.print("(Q)uit");
    }
    
    private void createReadingTip() {
        String title = io.readLine("What is the title of the reading tip?");
        printTypes();
        String type = io.readLine("What kind of reading tip it is?");
        ReadingTip tip = service.createTipWithType(type.toLowerCase(), title);
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

    private void listAllReadingTips() throws Exception {
        service.browseReadingTips();
    }
    
    
    //        ReadingTipService ok = new ReadingTipService();
    //
    //        String type = "book";
    //        String title = "The Hitchhiker's Guide to the Galaxy";
    //        String info1 = "Douglas Adams";
    //        String info2 = "0-330-25864-8";
    //
    //        ok.createTip(type, title, info1, info2);
    //        ok.browseReadingTips();
        
    //    public void start() throws Exception {
    //        ReadingTipService ok = new ReadingTipService();
    //        Scanner sc = new Scanner(System.in);
    //
    //        //String author = "kennedy";
    //        System.out.println("Enter a author name: ");
    //        String author = sc.nextLine();
    //
    //        System.out.println("Enter a title");
    //        String title = sc.nextLine();
    //
    //        ok.createTip(author, title);
    //
    //
    //    }
}
