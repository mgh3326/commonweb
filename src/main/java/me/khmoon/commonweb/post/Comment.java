package me.khmoon.commonweb.post;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;

@NamedEntityGraph(name = "Comment.post",
        attributeNodes = @NamedAttributeNode("post"))
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Comment {
  @Id
  @GeneratedValue
  private Long id;

  private String comment;

  @ManyToOne(fetch = FetchType.LAZY)
  private Post post;

  private int up;
  private int down;
  private boolean best;


  @LastModifiedDate
  private Date updated;

  @CreatedBy
  @ManyToOne
  private Account createdBy;

  @LastModifiedBy
  @ManyToOne
  private Account updatedBy;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Post getPost() {
    return post;
  }

  public void setPost(Post post) {
    this.post = post;
  }

  public int getUp() {
    return up;
  }

  public void setUp(int up) {
    this.up = up;
  }

  public int getDown() {
    return down;
  }

  public void setDown(int down) {
    this.down = down;
  }

  public boolean isBest() {
    return best;
  }

  public void setBest(boolean best) {
    this.best = best;
  }

  @PrePersist
  public void perPersist() {
    System.out.println("Pre Persist is called");
  }
}
