package com.laptrinhjavaweb.entity;

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
@Table(name = "image")
public class ImageEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int imageId;
	
	@Column(name = "image_url", columnDefinition = "nvarchar(MAX) not null")
	private String imageUrl;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "news_id")
	private NewsEntity newsId;
	
	public ImageEntity() {
		// TODO Auto-generated constructor stub
	}

	public ImageEntity(int imageId, String imageUrl, NewsEntity newsId) {
		super();
		this.imageId = imageId;
		this.imageUrl = imageUrl;
		this.newsId = newsId;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	
	public NewsEntity getNewsId() {
		return newsId;
	}

	public void setNewsId(NewsEntity newsId) {
		this.newsId = newsId;
	}

	@Override
	public String toString() {
		return "ImageEntity [imageId=" + imageId + ", imageUrl=" + imageUrl + ", newsId=" + newsId + "]";
	}
	
}
