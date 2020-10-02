package com.project1;

public class PostData {
	
	private int likecount,dlikecount;
	private String posttext,username;
	
	public PostData(){
		
	}
	public PostData(int likecount, int dlikecount, String posttext, String username) {
		super();
		this.likecount = likecount;
		this.dlikecount = dlikecount;
		this.posttext = posttext;
		this.username = username;
	}
	public int getLikecount() {
		return likecount;
	}
	public void setLikecount(int likecount) {
		this.likecount = likecount;
	}
	public int getDlikecount() {
		return dlikecount;
	}
	public void setDlikecount(int dlikecount) {
		this.dlikecount = dlikecount;
	}
	public String getPosttext() {
		return posttext;
	}
	public void setPosttext(String posttext) {
		this.posttext = posttext;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

}
