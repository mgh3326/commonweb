package me.khmoon.commonweb.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
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

  @Test
  public void specs() {
    Page<Comment> page = comments.findAll(CommentSpecs.isBest().or(CommentSpecs.isGood()), PageRequest.of(0, 10));

  }

  @Test
  public void qbe() {
    Comment prove = new Comment();
    prove.setBest(true);
    ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny()
            .withIncludeNullValues()
            .withIgnorePaths("up", "down");
    Example<Comment> example = Example.of(prove, exampleMatcher);

    comments.findAll(example);
  }

}