package com.rachelsanchez.lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Lookify {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Size should be greater than 0")
	@Min(1)
	private Integer rating;
	@NotNull(message = "Must not be blank")
	
	@NotEmpty
	@NotBlank
	@Size(min=3, max=40)
	private String artist;
	
	@NotNull(message = "Must not be blank")
	@NotBlank
	@NotEmpty
	@Size(min=3, max=40)
	private String songName;
	
	public Long getId() {
		return id;
	}

	public Lookify(Long id, @NotNull(message = "Size should be greater than 0") @Min(1) Integer rating,
			@NotNull(message = "Must not be blank") @NotEmpty @NotBlank @Size(min = 3, max = 40) String artist,
			@NotNull(message = "Must not be blank") @NotBlank @NotEmpty @Size(min = 3, max = 40) String song,
			Date createdAt, Date updatedAt) {
		this.id = id;
		this.rating = rating;
		this.artist = artist;
		this.songName = song;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getSong() {
		return songName;
	}

	public void setSong(String song) {
		this.songName = song;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	

	public Lookify get(Lookify artist) {
		// TODO Auto-generated method stub
		return artist;
	}

	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}

	public Lookify() {
		
	}
}
