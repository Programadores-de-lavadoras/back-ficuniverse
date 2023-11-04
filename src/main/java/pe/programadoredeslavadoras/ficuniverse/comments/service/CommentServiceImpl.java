package pe.programadoredeslavadoras.ficuniverse.comments.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.programadoredeslavadoras.ficuniverse.comments.domain.model.entities.Comment;
import pe.programadoredeslavadoras.ficuniverse.comments.domain.persistence.CommentRepository;
import pe.programadoredeslavadoras.ficuniverse.comments.domain.service.CommentService;
import pe.programadoredeslavadoras.ficuniverse.shared.exception.FetchNotFoundException;
import pe.programadoredeslavadoras.ficuniverse.shared.exception.ResourceValidationException;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    private final Validator validator;

    @Override
    public Comment save(Comment comment) {
        Set<ConstraintViolation<Comment>> violations = validator.validate(comment);
        if(violations.isEmpty()) {
            return commentRepository.save(comment);
        }
        throw new ResourceValidationException("Comment", violations);
    }

    @Override
    public List<Comment> obtainAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment fetchById(Integer Id) {
        if (commentRepository.existsById(Id)) {
            commentRepository.findById(Id).orElseThrow();
        }
        throw new FetchNotFoundException("Student", "Id", Id);
    }
}
