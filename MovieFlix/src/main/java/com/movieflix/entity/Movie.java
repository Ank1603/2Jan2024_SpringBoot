package com.movieflix.entity;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="movie_id")
	private Integer id;

	// @Column(name = "movie_title")
	private String title;
	private String director;
	private String studio;

	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
	private Date releaseDate;
	private Float avgVote;

	@ElementCollection
	@CollectionTable(name = "movie_cast")
	private Set<String> cast;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToMany
	@JoinTable(name = "movie_genre", joinColumns = @JoinColumn(referencedColumnName = "movie_id"), inverseJoinColumns = @JoinColumn(referencedColumnName = "genre_id")

	)
	private Set<Genre> genres;
	private String poster;

	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public Movie(Integer id, String title, String director, String studio, Date releaseDate, Float avgVote,
			Set<String> cast, Category category, Set<Genre> genres, String poster) {
		super();
		this.id = id;
		this.title = title;
		this.director = director;
		this.studio = studio;
		this.releaseDate = releaseDate;
		this.avgVote = avgVote;
		this.cast = cast;
		this.category = category;
		this.genres = genres;
		this.poster = poster;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Float getAvgVote() {
		return avgVote;
	}

	public void setAvgVote(Float avgVote) {
		this.avgVote = avgVote;
	}

	public Set<String> getCast() {
		return cast;
	}

	public void setCast(Set<String> cast) {
		this.cast = cast;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", director=" + director + ", studio=" + studio
				+ ", releaseDate=" + releaseDate + ", avgVote=" + avgVote + ", cast=" + cast + ", category=" + category
				+ ", genres=" + genres + ", poster=" + poster + "]";
	}

}
