package com.example.view;

public class ProductDetails implements DisplayDetails {
    private String text;
    private String image;

    public ProductDetails(String texts, String image_url) {
        text = texts;
        image = image_url;
        
        System.out.println(image + "해당 상품은" + text + "입니다");
    }
    
    @Override
    public void displayTexts() {
        System.out.println("상품명 : " + text);
    }
    
    @Override
    public void displayImages() {
        System.out.println(text + " 제품입니다.");
    }
}
