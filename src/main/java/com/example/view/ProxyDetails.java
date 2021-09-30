package com.example.view;

public class ProxyDetails implements DisplayDetails {
    private String text;
    private String image;
    private ProductDetails productDetails; 

    public ProxyDetails(String texts, String image_url) {
        text = texts;
        image = image_url;
    }

    @Override
    public void displayTexts() {
        System.out.println("상품명 : " + text);
    }
    
    @Override
    public void displayImages() {
			// 비어있다면 상품 설명과 이미지 설정
			if (productDetails == null) {     
            productDetails = new ProductDetails(text, image); 
      }    
      productDetails.displayImages(); // 무거운 작업
    }
}
