package com.itcast.entity;

public class News {
	private int nId;
	private String title;
	private String content;
	
	public News() {
		super();
	}

	public News(int nId, String title, String content) {
		super();
		this.nId = nId;
		this.title = title;
		this.content = content;
	}

	public int getnId() {
		return nId;
	}

	public void setnId(int nId) {
		this.nId = nId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "News [nId=" + nId + ", title=" + title + ", content=" + content
				+ "]";
	}
	
	

}
