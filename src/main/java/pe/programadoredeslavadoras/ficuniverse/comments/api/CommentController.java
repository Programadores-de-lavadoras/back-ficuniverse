package pe.programadoredeslavadoras.ficuniverse.comments.api;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pe.programadoredeslavadoras.ficuniverse.comments.domain.model.entities.Comment;
import pe.programadoredeslavadoras.ficuniverse.comments.domain.service.CommentService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("comments")

public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public Comment save(@RequestBody Comment comment){
        return commentService.save(comment);
    }

    @GetMapping
    public List<Comment> obtainAll() {
        return commentService.obtainAll();
    }

}
