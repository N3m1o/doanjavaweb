package com.laptrinhjavaweb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "new")
public class NewEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "image", nullable = false)
	private String image;
	
	@Column(name = "short_description", nullable = false)
	private String shortDes;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cate_id")
    private CateEntity new_cate;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private CateEntity wrotebyID;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getShortDes() {
		return shortDes;
	}

	public void setShortDes(String shortDes) {
		this.shortDes = shortDes;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CateEntity getNew_cate() {
		return new_cate;
	}

	public void setNew_cate(CateEntity new_cate) {
		this.new_cate = new_cate;
	}

	public CateEntity getWrotebyID() {
		return wrotebyID;
	}

	public void setWrotebyID(CateEntity wrotebyID) {
		this.wrotebyID = wrotebyID;
	}

	@Override
	public String toString() {
		return "NewEntity [id=" + id + ", name=" + name + ", image=" + image + ", shortDes=" + shortDes
				+ ", description=" + description + ", new_cate=" + new_cate + ", wrotebyID=" + wrotebyID + "]";
	}
}
