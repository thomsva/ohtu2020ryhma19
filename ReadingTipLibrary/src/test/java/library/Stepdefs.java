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
    List<String> inputLines;
    StubIO io;
    ReadingTipService service;
    
    
    @Before
    public void setup(){
        inputLines = new ArrayList<>();     
        io = new StubIO(inputLines);
        ui = new ReadingTipUi(io);    
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
    public void readingTipCanBeFound(String expectedOutput) {
        assertTrue(io.getPrints().contains(expectedOutput));
    }
   
    
    @When("all reading tips are listed")
    public void readingTipIsSaved() throws Exception {
        inputLines.add("L");
        io = new StubIO(inputLines);
        ui = new ReadingTipUi(io);
        ui.start();        
    }

    
//    @Then("a reading tip {string} with type {string} is printed")
//    public void systemWillRespondWith(String title, String type) {
//        assertTrue(io.getPrints().contains(title));
//        assertTrue(io.getPrints().contains(type));
//    }

}