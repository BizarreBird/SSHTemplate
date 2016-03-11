package com.template.system.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/** 
* @ClassName: User 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Peter Jia
* @date 2016年3月9日 下午12:29:02 
*  
*/
@Entity
@Table(name = "USER")
@DynamicInsert(true)
@DynamicUpdate(true)
public class User implements Serializable{

	private static final long serialVersionUID = 5988732592369349132L;
	
	@Id
	@Column(name = "ID", nullable = false, length = 50)
	private String id;
	@Column(name = "USERNAME", unique = true, nullable = false, length = 50)
	private String username;
	@Column(name = "PASSWORD", unique = true, nullable = false, length = 50)
	private String password;
	@Column(name = "EMAIL", length = 30)
	private String email;
	@Column(name = "PHONE", length = 20)
	private String phone;
	@Column(name = "RANK")
	private Integer rank;
	@Column(name = "CREATOR", length = 50)
	private String creator;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATEDATETIME", length = 19)
	private Date createdatetime;
	@Column(name = "MODIFYER", length = 50)
	private String modifyer;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFYDATETIME", length = 19)
	private Date modifydatetime;
	@Column(name = "EXP1")
	private String exp1;
	@Column(name = "EXP2")
	private String exp2;
	@Column(name = "EXP3")
	private String exp3;
	@Column(name = "EXP4")
	private String exp4;
	@Column(name = "EXP5")
	private String exp5;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public Date getCreatedatetime() {
		return createdatetime;
	}
	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}
	public Date getModifydatetime() {
		return modifydatetime;
	}
	public void setModifydatetime(Date modifydatetime) {
		this.modifydatetime = modifydatetime;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getModifyer() {
		return modifyer;
	}
	public void setModifyer(String modifyer) {
		this.modifyer = modifyer;
	}
	public String getExp1() {
		return exp1;
	}
	public void setExp1(String exp1) {
		this.exp1 = exp1;
	}
	public String getExp2() {
		return exp2;
	}
	public void setExp2(String exp2) {
		this.exp2 = exp2;
	}
	public String getExp3() {
		return exp3;
	}
	public void setExp3(String exp3) {
		this.exp3 = exp3;
	}
	public String getExp4() {
		return exp4;
	}
	public void setExp4(String exp4) {
		this.exp4 = exp4;
	}
	public String getExp5() {
		return exp5;
	}
	public void setExp5(String exp5) {
		this.exp5 = exp5;
	}
	
}
