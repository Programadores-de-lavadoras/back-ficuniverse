package pe.programadoredeslavadoras.ficuniverse.creation.resource;

import jakarta.validation.constraints.*;
import lombok.*;
import pe.programadoredeslavadoras.ficuniverse.creation.domain.model.entities.Fanfic;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ChapterResource {
    private String title;
    private String content;
    private Integer chapterOrder;
    //private Fanfic fanfic;
}
