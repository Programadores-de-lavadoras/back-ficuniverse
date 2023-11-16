package pe.programadoredeslavadoras.ficuniverse.creation.api;


import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.programadoredeslavadoras.ficuniverse.creation.domain.model.entities.Chapter;
import pe.programadoredeslavadoras.ficuniverse.creation.domain.service.ChapterService;
import pe.programadoredeslavadoras.ficuniverse.shared.exceptions.InternalServerErrorException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("chapters")
public class ChapterController {
    private final ChapterService chapterService;

    @PostMapping
    public Chapter save(@RequestBody Chapter chapter){
        return chapterService.save(chapter);
    }

    @GetMapping
    public List<Chapter> fetchAll(){
        return chapterService.fetchAll();
    }

    @GetMapping("{id}")
    public Chapter fetchById(@PathVariable("id") Integer id){
        return chapterService.fetchById(id);
    }

    @GetMapping("title/{title}")
    public Chapter fetchTitle(@PathVariable("title") String title){
        return chapterService.fetchByTitle(title);
    }

    @GetMapping("fanfic?{fanficId}")
    public List<Chapter> fetchChaptersByFanficId(@PathVariable("fanficId") Integer fanficId){
        return chapterService.fetchChaptersByFanficId(fanficId);
    }

    @GetMapping("order/{orderInit}/{orderEnd}")
    public List<Chapter> fetchChaptersBetweenOrder(@PathVariable("orderInit") Integer orderInit, @PathVariable("orderEnd") Integer orderEnd){
        return chapterService.fetchByChapterOrderBetween(orderInit,orderEnd);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id){
        if(chapterService.deleteById(id)){
            return ResponseEntity.noContent().build();
        }
        throw new InternalServerErrorException("Chapter", "id", String.valueOf(id), "deleted");
    }
}
