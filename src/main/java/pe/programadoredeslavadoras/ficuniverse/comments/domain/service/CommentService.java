package pe.programadoredeslavadoras.ficuniverse.comments.domain.service;

import pe.programadoredeslavadoras.ficuniverse.comments.domain.model.entities.Comment;

import java.util.List;

public interface CommentService {
    Comment save (Comment comment);
    List<Comment> obtainAll();
    Comment fetchById(Integer Id);
}
