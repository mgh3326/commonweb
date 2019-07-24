package me.khmoon.commonweb.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentSummaryTest {

  @Autowired
  CommentRepository comments;

  @Autowired
  PostRepository posts;

  @Test
  public void getVotes() {
    Post post = new Post();
    post.setTitle("jps");
    Post savedPost = posts.save(post);

    Comment comment = new Comment();
    comment.setComment("spring data jpa projection");
    comment.setPost(savedPost);
    comment.setUp(10);
    comment.setDown(1);

    comments.findByPost_Id(savedPost.getId(), CommentOnly.class).forEach(c -> {
      System.out.printf("==================");
      System.out.println(c.getComment());

    });
  }
}