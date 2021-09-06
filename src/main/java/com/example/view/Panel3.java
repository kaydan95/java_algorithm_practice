package com.example.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Panel3 extends JPanel implements ActionListener {
    private JButton button1 = null; //수정
    private JButton button2 = null; //삭제

    public Panel3() {
        this.setLayout(new BorderLayout());

        JScrollPane scroll = new JScrollPane(ItemTable.getInstance());
        this.add(scroll, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        button1 = new JButton("수정");
        button2 = new JButton("삭제");

        button1.addActionListener(this);
        button2.addActionListener(this);

        panel.add(button1);
        panel.add(button2);

        this.add(panel, BorderLayout.NORTH); //아래쪽
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1){
            try{
                int ret = JOptionPane.showConfirmDialog(null, "수정하시겠습니까?", "수정", JOptionPane.INFORMATION_MESSAGE);
                if(ret == 0){
                    JOptionPane.showConfirmDialog(null, "수정완료", "완료", JOptionPane.INFORMATION_MESSAGE);
                    ItemTable.getInstance().updateItems();
                    
                }
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }
        if(e.getSource() == button2){
            try {
                int ret = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "삭제", JOptionPane.INFORMATION_MESSAGE);
                if(ret == 0){
                    ItemTable.getInstance().deleteItems();
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    
}
