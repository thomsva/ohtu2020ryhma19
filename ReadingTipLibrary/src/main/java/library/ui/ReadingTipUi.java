/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.ui;
import library.domain.ReadingTipService;


public class ReadingTipUi {
    
    
    public void start() throws Exception{
      ReadingTipService ok = new ReadingTipService();
     
      String type = "book";
      String title = "The Hitchhiker's Guide to the Galaxy";
      String info1 = "Douglas Adams";
      String info2 = "	0-330-25864-8";
      
      ok.createTip(type, title, info1, info2);
      ok.browseReadingTips();
      
 
    }
    
}
