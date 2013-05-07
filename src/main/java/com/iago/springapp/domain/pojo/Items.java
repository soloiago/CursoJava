package com.iago.springapp.domain.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name = "findItemByName", query = "from Items s where s.name = :name"), 
	@NamedQuery(name = "findAllRestricted", query = "select name from Items s")
})

@Entity
@Table(name="ITEMS", schema="IAGO")
public class Items implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Users users;
	private Shops shops;
	private String name;
	private Double price;
	private Date fecha;
	private List<Images> imageses = new ArrayList<Images>(0);
	private Set<Notas> notases = new HashSet<Notas>(0);
	private Set<Comments> commentses = new HashSet<Comments>(0);

	public Items() {
	}


	public Items(Long id, Shops shops) {
		this.id = id;
		this.shops = shops;
	}
	public Items(Long id, Users users, Shops shops, String name, Double price, Date fecha, List<Images> imageses, Set<Notas> notases, Set<Comments> commentses) {
		this.id = id;
		this.users = users;
		this.shops = shops;
		this.name = name;
		this.price = price;
		this.fecha = fecha;
		this.imageses = imageses;
		this.notases = notases;
		this.commentses = commentses;
	}

	@Id 
	@Column(name="ID", nullable=false, precision=22, scale=0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SHOP_ID", nullable=false)
	public Shops getShops() {
		return this.shops;
	}

	public void setShops(Shops shops) {
		this.shops = shops;
	}

	@Column(name="NAME", length=150)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="PRICE", precision=2, scale=0)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name="FECHA")
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="items")
	public List<Images> getImageses() {
		return this.imageses;
	}

	public void setImageses(List<Images> imageses) {
		this.imageses = imageses;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="items")
	public Set<Notas> getNotases() {
		return this.notases;
	}

	public void setNotases(Set<Notas> notases) {
		this.notases = notases;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="items")
	public Set<Comments> getCommentses() {
		return this.commentses;
	}

	public void setCommentses(Set<Comments> commentses) {
		this.commentses = commentses;
	}




}


