package com.javaweb.springmvc.Entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;



@Entity(name = "users")
public class UserEntity extends BaseEntity{
	

	
	@Column(name = "user")
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "fullname")
	private String fullName;
	@Column(name = "sdt")
	private String sdt;
	@Column(name = "email")
	private String email;
	@Column(name = "image")
	private String image;
	@Column(name = "roleid")
	private Long roleid;
	@Column(name = "status")
	private int status;
	@Column(name = "role")
	private String role;
	
	
	@Column(name = "sex")
	private String sex;
	@Column(name = "dateofbirth")
	private Timestamp dateofbirth;
	
	
	
	
	@OneToMany(mappedBy = "users")
	private List<HelpEntity> helps = new ArrayList<>();
	
//	@OneToMany(mappedBy = "userComment")
//	private List<CommentEntity> comments = new ArrayList<>();
	
	
	
	
	public List<HelpEntity> getHelps() {
		return helps;
	}
	public void setHelps(List<HelpEntity> helps) {
		this.helps = helps;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public Timestamp getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Timestamp dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Long getRoleid() {
		return roleid;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}
