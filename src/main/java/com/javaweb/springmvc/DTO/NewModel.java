package com.javaweb.springmvc.DTO;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class NewModel extends AbstractModel{

	
	private String title;
	private String thumbnail;
	private String shortDescription;
	private String content;
	private Long categoryid;
	private String categoryCode;
	private String categoryName;
	
	
	
	
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	private MultipartFile image;
	
	private String imageName;
	
	private String base64;
	
	private int countNewCategory;
	
	
	
	List<CommentModel> commentModels;
	
	
	
	
	public List<CommentModel> getCommentModels() {
		return commentModels;
	}
	public void setCommentModels(List<CommentModel> commentModels) {
		this.commentModels = commentModels;
	}
	public String getBase64() {
		return base64;
	}
	public void setBase64(String base64) {
		this.base64 = base64;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public int getCountNewCategory() {
		return countNewCategory;
	}
	public void setCountNewCategory(int countNewCategory) {
		this.countNewCategory = countNewCategory;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	
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
