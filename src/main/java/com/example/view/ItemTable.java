package com.example.view;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.example.entity.Item;
import com.example.model.ItemDB;

public class ItemTable extends JTable {

        private static ItemTable itemTable = new ItemTable();
        private List<Item> list = null;
    
        private ItemTable() {
            this.refreshData();
        }
    
        public static ItemTable getInstance(){
            return itemTable;
        }
        
        public void refreshData(){ 
            try {
                this.list = ItemDB.getInstance().selectItems();
    
                Object[][] contents = new Object[list.size()][5];
                for(int i=0; i<list.size(); i++){
                    Item item = list.get(i);
                    contents[i][0] = item.getCode(); //int
                    contents[i][1] = item.getName(); //String
                    contents[i][2] = item.getText(); //String
                    contents[i][3] = item.getPrice(); //int
                    contents[i][4] = item.getQuantity(); //long
                }
    
                String[] columns = {"번호","물품명","내용","가격","수량"};
                DefaultTableModel model = new DefaultTableModel(contents,columns);
                this.setModel(model);
            } catch (Exception e) {
                e.printStackTrace();
            } 
        }
    
        // 테이블에서 수정하기
        public void updateItems() throws Exception{
            for(int i=0; i<this.getRowCount(); i++){
                String code = this.getModel().getValueAt(i, 0).toString();
                String name = this.getModel().getValueAt(i, 1).toString();
                String text = this.getModel().getValueAt(i, 2).toString();
                String price = this.getModel().getValueAt(i, 3).toString();
                String quantity = this.getModel().getValueAt(i, 4).toString();
    
                Item item = new Item();
                item.setCode(Integer.parseInt(code));
                item.setName(name);
                item.setText(text);
                item.setPrice(Integer.parseInt(price));
                item.setQuantity(Long.parseLong(quantity));
    
                ItemDB.getInstance().updateItem(item);
            }
            this.refreshData();
        }
    
        // 테이블에서 삭제하기
        public void deleteItems() throws Exception{
            int[] rows = this.getSelectedRows(); //여러개를 선택해야하기 때문에 배열로 / 선택된 위치정보확인
            if(rows.length <= 0){
                
            }else{
                for(int idx : rows){
                    // table에서 물품번호 가져오기
                    String code = this.getModel().getValueAt(idx, 0).toString();
                    ItemDB.getInstance().deleteItem(Integer.parseInt(code));
                }
                this.refreshData();
            }
        }
}
