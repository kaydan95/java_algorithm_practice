package com.example.view;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainFrame extends JFrame implements ChangeListener {

    private JTabbedPane tabbedPane = null;

    public MainFrame(String title) throws HeadlessException {
        super(title);

        this.tabbedPane = new JTabbedPane();
        tabbedPane.add("홈", new Panel1());
        tabbedPane.add("물품등록", new Panel2());
        tabbedPane.add("물품조회", new Panel3());

        tabbedPane.setSelectedIndex(0);
        tabbedPane.addChangeListener(this);

        this.add(tabbedPane);

        this.setSize(600, 500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        System.out.println(e.getSource());
        int idx = tabbedPane.getSelectedIndex();
        if (idx == 2) {
            ItemTable.getInstance().refreshData();
        }
    }

}
