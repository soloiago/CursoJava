package com.iago.springapp.domain.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SHOPS", schema="IAGO")
public class Shops implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nombre;
	private String direccion;
	private Set<Items> itemses = new HashSet<Items>(0);

	public Shops() {
	}

	public Shops(Long id) {
		this.id = id;
	}
	public Shops(Long id, String nombre, String direccion, Set<Items> itemses) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.itemses = itemses;
	}

	@Id 

	@Column(name="ID", nullable=false, precision=22, scale=0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="NOMBRE", length=150)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name="DIRECCION", length=200)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="shops")
	public Set<Items> getItemses() {
		return this.itemses;
	}

	public void setItemses(Set<Items> itemses) {
		this.itemses = itemses;
	}

	@Override
	public String toString() {
		return getNombre();
	}


}


