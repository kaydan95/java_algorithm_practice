package com.example.view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel1 extends JPanel {

    public Panel1() {
        this.setLayout(new BorderLayout());

        JLabel label1 = new JLabel("메인화면입니다.");
        label1.setHorizontalAlignment(JLabel.CENTER);
        this.add(label1);
    }
    
}
