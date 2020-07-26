package com.javaweb.springmvc.DTO;

public class CommentModel extends AbstractModel{

	private String comments;
	private Long userid;
	private Long newid;
	private String userName;
	private Long useridcomment;
	private String news;
	
	private String repComments;
	
	
	
	
	public String getRepComments() {
		return repComments;
	}
	public void setRepComments(String repComments) {
		this.repComments = repComments;
	}
	public String getNews() {
		return news;
	}
	public void setNews(String news) {
		this.news = news;
	}
	public Long getUseridcomment() {
		return useridcomment;
	}
	public void setUseridcomment(Long useridcomment) {
		this.useridcomment = useridcomment;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getNewid() {
		return newid;
	}
	public void setNewid(Long newid) {
		this.newid = newid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	

	
	
	
}
