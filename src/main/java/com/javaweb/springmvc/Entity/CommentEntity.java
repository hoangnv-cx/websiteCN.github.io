package com.javaweb.springmvc.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class CommentEntity extends BaseEntity{
	@Column(name = "comments")
	private String comments;
	@Column(name = "userid")
	private Long userid;
	@Column(name = "newid")
	private Long newid;
	@Column(name = "useridcomment")
	private Long useridcomment;
	
	
	/*
	 * @ManyToOne(fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "userid") private UserEntity userComment;
	 * 
	 * @ManyToOne(fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "newid") private NewEntity newComment;
	 */
	
	
	
	

	

	



	public String getComments() {
		return comments;
	}

	public Long getUseridcomment() {
		return useridcomment;
	}

	public void setUseridcomment(Long useridcomment) {
		this.useridcomment = useridcomment;
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

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	
}
