package com.example.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.example.entity.Item;
import com.example.model.ItemDB;

public class Panel2 extends JPanel implements ActionListener{

    private JTextField textField = null;
    private JTextField textField_1 = null;
    private JTextField textField_2 = null;
    private JTextField textField_3 = null;
    private JTextArea textArea = null;
    private JButton btnNewButton = null;
    
    public Panel2() {
        super();

        this.setLayout(null);

        JLabel lblNewLabel = new JLabel("물품번호");
        lblNewLabel.setBounds(32, 31, 50, 15);
        this.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(83, 28, 144, 21);
        this.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("물품명");
        lblNewLabel_1.setBounds(32, 63, 50, 15);
        this.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setBounds(83, 60, 144, 21);
        this.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("물품내용");
        lblNewLabel_2.setBounds(32, 96, 50, 15);
        this.add(lblNewLabel_2);

        textArea = new JTextArea();
        textArea.setBounds(83, 91, 144, 55);
        this.add(textArea);

        JLabel lblNewLabel_3 = new JLabel("물품가격");
        lblNewLabel_3.setBounds(32, 159, 50, 15);
        this.add(lblNewLabel_3);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(83, 156, 144, 21);
        this.add(textField_2);

        JLabel lblNewLabel_1_1 = new JLabel("수량");
        lblNewLabel_1_1.setBounds(32, 191, 50, 15);
        this.add(lblNewLabel_1_1);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(83, 188, 144, 21);
        this.add(textField_3);

        btnNewButton = new JButton("물품등록");
        btnNewButton.setBounds(83, 231, 91, 23);
        this.add(btnNewButton);
        btnNewButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnNewButton){
            int code = Integer.parseInt( textField.getText());
            String name = textField_1.getText();
            String text = textArea.getText();
            int price = Integer.parseInt(textField_2.getText());
            long quantity = Long.parseLong(textField_3.getText());

            Item item = new Item();
            item.setCode(code);
            item.setName(name);
            item.setText(text);
            item.setPrice(price);
            item.setQuantity(quantity);

            try {
                int ret = ItemDB.getInstance().insertItem(item);
                if(ret == 1){
                    JOptionPane.showMessageDialog(this, "물품등록성공", "성공", JOptionPane.INFORMATION_MESSAGE);
                    //textField.setText("");
                }
                else{
                    JOptionPane.showMessageDialog(this, "물품등록실패", "실패", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        
    }
}
    

