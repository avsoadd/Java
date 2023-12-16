package model;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the likes database table.
 * 
 */
@Entity
@Table(name="likes")
@NamedQuery(name="Likes.findAll", query="SELECT l FROM Likes l")
public class Likes implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="like_id")
	private Long likeId;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="post_id")
	private Long postId;

	@Column(name="user_id")
	private Integer userId;

	public Likes() {
	}

	public Long getLikeId() {
		return this.likeId;
	}

	public void setLikeId(Long likeId) {
		this.likeId = likeId;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Long getPostId() {
		return this.postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}