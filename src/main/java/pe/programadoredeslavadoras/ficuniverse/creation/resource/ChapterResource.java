package pe.programadoredeslavadoras.ficuniverse.creation.resource;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ChapterResource {
    private String title;
    private String content;
    private Integer chapterOrder;
}
