/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.WebScrapperHw.util;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Prabishan
 */
public class Grabber {

    public String grab(String link) throws IOException {
        URL url = new URL(link);
        URLConnection connect = url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connect.getInputStream()));
        StringBuilder content = new StringBuilder();

        String line = "";
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        reader.close();
        return (content.toString());
    }

}
