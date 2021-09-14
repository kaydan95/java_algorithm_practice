package com.example.view;

public class Adapter implements US120{

    private KR220 kr220;

    public Adapter(KR220 kr220) {
        this.kr220 = kr220;
    }

    @Override
    public void poweron() {
        kr220.connect();
    }
    
}
