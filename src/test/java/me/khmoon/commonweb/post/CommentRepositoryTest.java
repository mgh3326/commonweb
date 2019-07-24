package me.khmoon.commonweb.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {
  @Autowired
  CommentRepository comments;

  @Autowired
  PostRepository postRepository;

  @Test
  public void getComment() {
    comments.getById(1L);
    System.out.println("===================");

//    Post post = new Post();
//    post.setTitle("jpa");
//    Post savedPost = postRepository.save(post);
//
//    Comment comment = new Comment();
//    comment.setComment("comment");
//    comment.setPost(savedPost);
//    comments.save(comment);

    Optional<Comment> byId = comments.findById((long) 1);
//    comments.findByPost_Id(1L);

//    System.out.println(byId.get().getPost());

  }

}