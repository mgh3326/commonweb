package me.khmoon.commonweb.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {
  @Autowired
  private PostRepository postRepository;

  @Test
  public void save() {
    Post post = new Post();
    post.setId(1L);
    post.setTitle("jpa");
    Post savedPost = postRepository.save(post); // insert

    Post postUpdate = new Post();
    postUpdate.setId(1L);
    postUpdate.setTitle("hibernate");
    Post UpdatedPost = postRepository.save(postUpdate); // update

    UpdatedPost.setTitle("whiteship");
    List<Post> all = postRepository.findAll();
    assertThat(all.size()).isEqualTo(1);
  }

  @Test
  public void findByTitleStartsWith() {
    Post post = new Post();
    post.setTitle("Spring Data Jpa");
    postRepository.save(post);

    List<Post> all = postRepository.findByTitleStartsWith("Spring");
    assertThat(all.size()).isEqualTo(1);

  }

  @Test
  public void findByTitle() {
    Post post = new Post();
    post.setTitle("Spring");
    postRepository.save(post);

    List<Post> all = postRepository.findByTitle("Spring", Sort.by("title"));
    assertThat(all.size()).isEqualTo(1);

  }

  @Test
  public void updateTitle() {
    Post post = new Post();
    post.setTitle("Spring");
    Post spring = postRepository.save(post);

    String hibernate = "hibernate";

    int update = postRepository.updateTitle(hibernate, spring.getId());
    assertThat(update).isEqualTo(1);

    Optional<Post> byId = postRepository.findById(spring.getId());
    post = byId.get();
    assertThat(post.getTitle()).isEqualTo(hibernate);
  }
}