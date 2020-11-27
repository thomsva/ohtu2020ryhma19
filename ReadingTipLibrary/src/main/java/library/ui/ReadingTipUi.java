package library.ui;

import java.util.Scanner;
import library.domain.ReadingTip;
import library.domain.ReadingTipService;

/** The user interface. */
public class ReadingTipUi {
    
    Scanner scanner;
    ReadingTipService service;

    /** Method to start the user interface. */
    public void start() throws Exception {

        service = new ReadingTipService();
        scanner = new Scanner(System.in);

        System.out.println("Hello user!");

        while (true) {
            printOptions();
            String input = scanner.nextLine();
            if (input.equals("A")) {
                createReadingTip();
            } else if (input.equals("M")) {
                System.out.println("This option is coming soon. Thank you for being patient!");
            } else if (input.equals("L")) {
                listAllReadingTips();
            } else if (input.equals("Q")) {
                break;
            } else {
                System.out.println("Oops, command not existing! Try again.");
            }
        }
    }

    private void printOptions() {
        System.out.println("You can...");
        System.out.println("(A)dd a new reading tip"); //this is what we have at the moment
        System.out.println("(M)odify an existing reading tip"); //coming soon

        //coming soon; selecting this allows user to specify searching criteria
        System.out.println("(L)ist all existing reading tips"); 

        System.out.println("(Q)uit");
    }
    
    private void createReadingTip() throws Exception {
        System.out.println("What is the title of the reading tip?");
        String title = scanner.nextLine();
        printTypes();
        String type = scanner.nextLine();
        service.createTip(type.toLowerCase(), title);
        System.out.println("Lisätty!");
    }
    
    private void listAllReadingTips() throws Exception {
        service.browseReadingTips();
    }
    
    private void printTypes() {
        System.out.println("What kind of reading tip it is?");
        System.out.println("Options:");
        System.out.println("blogpost");
        System.out.println("book");
        System.out.println("podcast");
        System.out.println("video");
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
