package me.khmoon.commonweb.post;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

  @EntityGraph(value = "Comment.post", type = EntityGraph.EntityGraphType.LOAD)
  Optional<Comment> getById(Long id);

  <T> List<T> findByPost_Id(Long id, Class<T> type);
}
