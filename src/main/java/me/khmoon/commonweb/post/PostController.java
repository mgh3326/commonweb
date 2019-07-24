package me.khmoon.commonweb.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

  @Autowired
  private PostRepository posts;

  @GetMapping("/posts/{id}")
  public String getPost(@PathVariable("id") Post post) {
    return post.getTitle();
  }

  @GetMapping("/posts")
  public PagedResources<Resource<Post>> getPosts(Pageable pageable, PagedResourcesAssembler assembler) {
    return assembler.toResource(posts.findAll(pageable));
  }
}
