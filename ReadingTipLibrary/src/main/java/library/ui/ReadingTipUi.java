/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.ui;

import java.util.Scanner;
import library.domain.ReadingTipService;

public class ReadingTipUi {

    public void start() throws Exception {
        ReadingTipService ok = new ReadingTipService();

        String type = "book";
        String title = "The Hitchhiker's Guide to the Galaxy";
        String info1 = "Douglas Adams";
        String info2 = "	0-330-25864-8";

        ok.createTip(type, title, info1, info2);
        ok.browseReadingTips();

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
}
