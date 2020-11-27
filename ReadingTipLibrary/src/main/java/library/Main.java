package library;

import library.io.ConsoleIO;
import library.io.IO;
import library.ui.ReadingTipUi;

/** Main Class. Launches UI. */
public class Main {
 
    public static void main(String[] args)throws Exception {
        IO io = new ConsoleIO();
        ReadingTipUi ui = new ReadingTipUi(io);
        ui.start();
    }
    
}
