package library;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import library.dao.*;
import library.domain.*;
import library.io.*;
import library.ui.*;

public class Stepdefs {
    ReadingTipUi ui;
    ReadingTipDao readingTipDao;
    List<String> inputLines;
    StubIO io;
    
    
    @Before
    public void setup(){
        inputLines = new ArrayList<>();     
        io = new StubIO(inputLines);
        ui = new ReadingTipUi(io);
        
//        readingTipDao = new ReadingTipDatabaseDao();        
    }

    
    @Given("command add is selected")
    public void commandAddIsSelected() {
        inputLines.add("A");
    }

    
    @When("a reading tip {string} with type {string} is created")
    public void newReadingTipWithTypeIsCreated(String title, String type) throws Exception {
        inputLines.add(title);
        inputLines.add(type);
        
        io = new StubIO(inputLines); 
        ui = new ReadingTipUi(io);
        ui.start();
    }    


    @Then("system will respond with {string}")
    public void systemWillRespondWith(String expectedOutput) {
        assertTrue(io.getPrints().contains(expectedOutput));
    }


//    @Given("a reading tip {string} with type {String} is created")
//    public void readingTipIsCreated(String title, String type) throws Exception {
//        inputLines.add("A");
//        inputLines.add(title);
//        inputLines.add(type);
//        
//        io = new StubIO(inputLines); 
//        ui = new ReadingTipUi(io);
//        ui.start();
//    }    
//    
//    @When("it is saved to the database")
//    public void readingTipIsSaved() {
//        
//    }
//    
//    @Then("it can be found from the database")
//    public void readingTipCanBeFound() {
//    }
}