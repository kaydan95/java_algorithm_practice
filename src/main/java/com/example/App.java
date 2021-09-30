package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.example.view.DisplayDetails;
import com.example.view.ProxyDetails;

public class App {

    public static void main(String[] args) throws IOException{
        ArrayList<DisplayDetails> displayDetails = new ArrayList<DisplayDetails>();
        displayDetails.add(new ProxyDetails("상품1", "/assets/pr1.png"));
        displayDetails.add(new ProxyDetails("상품2", "/assets/pr2.png"));

        for (DisplayDetails displayDetailss : displayDetails) {
            displayDetailss.displayTexts();;
            }

		displayDetails.get(1).displayImages();
        displayDetails.get(2).displayImages();
    }
}    


