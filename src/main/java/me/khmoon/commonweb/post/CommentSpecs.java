package me.khmoon.commonweb.post;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CommentSpecs {
  public static Specification<Comment> isBest() {
    return (Specification<Comment>) (root, criteriaQuery, builder) -> builder.isTrue(root.get(Comment_.best));

  }

  public static Specification<Comment> isGood() {
    return (Specification<Comment>) (root, criteriaQuery, builder) -> builder.greaterThanOrEqualTo(root.get(Comment_.up), 10);
  }
}
