package com.example.csdndemo;

public class ItemInfoBean {
	private String text;
    private int imageId;
	public ItemInfoBean( int imageId,String text) {
		this.text = text;
		this.imageId = imageId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
}
