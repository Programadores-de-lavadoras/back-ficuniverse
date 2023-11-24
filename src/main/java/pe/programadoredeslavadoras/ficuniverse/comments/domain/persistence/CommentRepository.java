package pe.programadoredeslavadoras.ficuniverse.comments.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.programadoredeslavadoras.ficuniverse.comments.domain.model.entities.Comment;


import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
  Optional<Comment> findById(Integer Id);
  boolean existsById(Integer Id);

  @Query(value = "SELECT * from comments WHERE tag_id = :tagId", nativeQuery = true)
  List<Comment> sqlCommentsByTagId(Integer tagId);
}
