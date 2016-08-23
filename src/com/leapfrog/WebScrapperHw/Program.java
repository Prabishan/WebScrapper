/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.WebScrapperHw;

import com.leapfrog.WebScrapperHw.util.Grabber;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Prabishan
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            while (true) {
                Scanner input = new Scanner(System.in);
                System.out.print("Keyword :");
                String keyword = input.next();

                // while (!(keyword.equalsIgnoreCase("exit"))) 
                Grabber grabber = new Grabber();
                String content = grabber.grab("http://hamrobazaar.com/search.php?do_search=Search&searchword=" + keyword + "&Search.x=0&Search.y=0&catid_search=0");

                String RegEx = "<div class.*?>.*?</div>.*?<a href=\"(.*?)\">.*?<img src='(.*?)'.*?></a>\\s.*?</td>.*?</center>\\s.*?</td>\\s.*?<td bgcolor.*?>.*?<a href=\"(.*?)\">.*?\\s.*>\\s.*\\s.*<b>(.*?)</b><.*\\s.*\\s.*\\s.*<font.*?>(.*?)</font>\\s.*\\s.*\\s.*\\s.*\\s.*\\s.*\\s.*<b>(.*?)</b>";
                Pattern pattern = Pattern.compile(RegEx);
                Matcher match = pattern.matcher(content);
                // System.out.println(content.toString());

                FileWriter writer = new FileWriter("c:/users/prabishan/desktop/sellers.txt");
                writer.write("FOR :" + keyword + "\r\n");
                //     InputStream is = 

                while (match.find()) {

                  //  String url=grabber.grab(match.group(2));
                    //String connect = grabber.grab(url);
                    //FileOutputStream os = new FileOutputStream("c:/users/prabishan/desktop");
                    //byte[] data = new byte[1024*5];
                    // int i = 0;
 //                   while((.read(data))!=-1){
    //            }
                    writer.write("Link :" + match.group(3) + "\r\n");
                    writer.write("Title :" + match.group(4) + "\r\n");
                    writer.write("Description :" + match.group(5) + "\r\n");
                    writer.write("Price :" + match.group(6) + "\r\n");
                    writer.write("ImgURL :" + match.group(2) + "\r\n");
                    writer.write("=================================================\r\n");

                }

                writer.close();
                System.out.println("Do you Want to Continue[Y/N]");
                if (input.next().equalsIgnoreCase("n")) {
                    System.exit(0);
                }
            }

        } catch (IOException ioe) {
            ioe.getMessage();

        }

    }
}
