package com.iago.springapp.domain.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PROFILE", schema="IAGO")
public class Profile implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String name;
	private String surname;
	private String email;
	private Date createdDate;
	private String avatar;
	private Users user;

	public Profile() {
	}

	public Profile(long id) {
		this.id = id;
	}
	
	public Profile(long id, String name, String surname, String email, Date createdDate, String avatar, Users user) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.createdDate = createdDate;
		this.avatar = avatar;
		this.user = user;
	}

	@Id 
	@Column(name="USER_ID", unique=true, nullable=false, precision=22, scale=0)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="NAME", length=100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="SURNAME", length=150)
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Column(name="EMAIL", length=100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="CREATED_DATE")
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name="AVATAR", length=100)
	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID", nullable=false)
	public Users getUsers() {
		return this.user;
	}

	public void setUsers(Users user) {
		this.user = user;
	}


}


