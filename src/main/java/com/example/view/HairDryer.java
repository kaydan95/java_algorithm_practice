package com.example.view;

public class HairDryer implements US120{

    @Override
    public void poweron() {
        System.out.println("드라이기 120V on");        
    }
}
