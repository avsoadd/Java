package model;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the posts database table.
 * 
 */
@Entity
@Table(name="posts")
@NamedQuery(name="Posts.findAll", query="SELECT p FROM Posts p")
public class Posts implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="post_id")
	private Long postId;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="delete_flg")
	private Boolean deleteFlg;

	@Column(name="image1_path")
	private String image1Path;

	@Column(name="image2_path")
	private String image2Path;

	@Column(name="image3_path")
	private String image3Path;

	@Column(name="image4_path")
	private String image4Path;

	@Column(name="message_text")
	private String messageText;

	@Column(name="user_id")
	private Integer userId;

	@Column(name="vvox_id")
	private Long vvoxId;

	public Posts() {
	}

	public Long getPostId() {
		return this.postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Boolean getDeleteFlg() {
		return this.deleteFlg;
	}

	public void setDeleteFlg(Boolean deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public String getImage1Path() {
		return this.image1Path;
	}

	public void setImage1Path(String image1Path) {
		this.image1Path = image1Path;
	}

	public String getImage2Path() {
		return this.image2Path;
	}

	public void setImage2Path(String image2Path) {
		this.image2Path = image2Path;
	}

	public String getImage3Path() {
		return this.image3Path;
	}

	public void setImage3Path(String image3Path) {
		this.image3Path = image3Path;
	}

	public String getImage4Path() {
		return this.image4Path;
	}

	public void setImage4Path(String image4Path) {
		this.image4Path = image4Path;
	}

	public String getMessageText() {
		return this.messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Long getVvoxId() {
		return this.vvoxId;
	}

	public void setVvoxId(Long vvoxId) {
		this.vvoxId = vvoxId;
	}

}