package com.javaweb.springmvc.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity(name = "news")
public class NewEntity extends BaseEntity{
	
	@Column(name = "title")
	private String title;
	@Column(name = "thumbnail")
	private String thumbnail;
	@Column(name = "shortdescription")
	private String shortDescription;
	@Column(name = "content")
	private String content;
	@Column(name = "categoryid")
	private Long categoryid;
	
	
	
//	@OneToMany(mappedBy = "newComment")
//	private List<CommentEntity> comments = new ArrayList<>();
	
	
	
	
	
	
	
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}
	
	
	
}
