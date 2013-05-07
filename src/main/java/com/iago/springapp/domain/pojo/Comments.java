package com.iago.springapp.domain.pojo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

//@NamedQueries({
//	@NamedQuery(name = "findCommentsByItemId", query = "from COMMENTS"), 
//})

@Entity
@Table(name="COMMENTS", schema="IAGO")
public class Comments  implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BigDecimal id;
	private Users users;
	private Items items;
	private String comentario;
	private BigDecimal replyId;
	private Date fecha;
	private int marginReply;

	public Comments() {
	}

	public Comments(BigDecimal id, Users users, Items items) {
		this.id = id;
		this.users = users;
		this.items = items;
	}
	public Comments(BigDecimal id, Users users, Items items, String comentario, Date fecha) {
		this.id = id;
		this.users = users;
		this.items = items;
		this.comentario = comentario;
		this.fecha = fecha;
	}

	@Id 
	@Column(name="ID", unique=true, nullable=false, precision=22, scale=0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID", nullable=false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ITEM_ID", nullable=false)
	public Items getItems() {
		return this.items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	@Column(name="COMENTARIO", length=500)
	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	@Column(name="REPLY_ID", precision=22, scale=0)
	public BigDecimal getReplyId() {
		return replyId;
	}
	
	public void setReplyId(BigDecimal replyId) {
		this.replyId = replyId;
	}

	@Column(name="FECHA")
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Transient
	public int getMarginReply() {
		return marginReply;
	}
	
	public void setMarginReply(int marginReply) {
		this.marginReply = marginReply;
	}

}


