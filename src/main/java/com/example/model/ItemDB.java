package com.example.model;

import java.util.ArrayList;
import java.util.List;

import com.example.entity.Item;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

import org.bson.Document;
import org.bson.conversions.Bson;


public class ItemDB {
    private MongoCollection<Document> collection = null;
    private final String URL = "mongodb://id312:pw312@1.234.5.158:37017/id312";

    private static ItemDB itemDB = new ItemDB();

    private ItemDB() {
        MongoClient client = MongoClients.create(URL);
        MongoDatabase db = client.getDatabase("id312");
        this.collection = db.getCollection("exam_item");
    }
    public static ItemDB getInstance(){
        return itemDB;
    }

    public int insertItem(Item item) throws Exception {
        Document document = new Document();
        document.append("_id", item.getCode());
        document.append("name", item.getName());
        document.append("text", item.getText());
        document.append("price", item.getPrice());
        document.append("quantity", item.getQuantity());

        InsertOneResult result = collection.insertOne(document);
        if(result.getInsertedId().asInt32().getValue() == item.getCode()){
            return 1;
        }
        return 0;
    }

    public int deleteItem(int code) throws Exception {
        Bson query = Filters.eq("_id", code);
        DeleteResult result = this.collection.deleteOne(query);

        if(result.getDeletedCount() == 1){
            return 1;
        }
        return 0;
    }

    public int updateItem(Item item) throws Exception{
        Bson query = Filters.eq("_id", item.getCode());
        Bson update = Updates.combine(
            Updates.set("name", item.getName())
            //수정할 항목 더 추가하기
        );
        UpdateResult result = this.collection.updateOne(query, update);
        if(result.getMatchedCount() == 1){
            return 1;
        }
        return 0;
    }

    //물품조회
    public List<Item> selectItems() throws Exception {
        MongoCursor<Document> cursor = collection.find().sort(Filters.eq("_id", 1)).cursor();
        List<Item> list = new ArrayList<Item>();

        while(cursor.hasNext()){
            Document doc = cursor.next();

            Item item = new Item();
            item.setCode(doc.getInteger("_id"));
            item.setName(doc.getString("name"));
            item.setText(doc.getString("text"));
            item.setPrice(doc.getInteger("price"));
            item.setQuantity(doc.getLong("quantity"));

            list.add(item);
        }
        return list;
    }

    
    
}
