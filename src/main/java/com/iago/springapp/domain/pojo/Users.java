package com.iago.springapp.domain.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name = "findUserByNickname", query = "from Users s where s.nickname = :nickname")
})

@Entity
@Table(name="USERS", schema="IAGO")
public class Users implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String nickname;
	private String password;
	private Profile profile;
	private Set<Comments> commentses = new HashSet<Comments>(0);
	private Set<Items> itemses = new HashSet<Items>(0);

	public Users() {
	}


	public Users(long id) {
		this.id = id;
	}
	public Users(long id, String nick, Profile profile, Set<Comments> commentses, Set<Items> itemses) {
		this.id = id;
		this.nickname = nick;
		//this.profile = profile;
		this.commentses = commentses;
		this.itemses = itemses;
	}

	@Id 
	@Column(name="ID", unique=true, nullable=false, precision=22, scale=0)
	@GeneratedValue(generator="sequence_generator")
	@SequenceGenerator(name="sequence_generator", sequenceName="USERS_ID_SEQ")
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="NICKNAME", length=50)
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nick) {
		this.nickname = nick;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="users")
	public Set<Comments> getCommentses() {
		return this.commentses;
	}

	public void setCommentses(Set<Comments> commentses) {
		this.commentses = commentses;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="users")
	public Set<Items> getItemses() {
		return this.itemses;
	}

	public void setItemses(Set<Items> itemses) {
		this.itemses = itemses;
	}

	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="users")
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	@Column(name="PASSWORD", length=30)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}


