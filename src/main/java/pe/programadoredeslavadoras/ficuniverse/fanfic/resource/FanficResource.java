package pe.programadoredeslavadoras.ficuniverse.fanfic.resource;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class FanficResource {
    private Integer id;
    private String title;
    private String author;
    private String summary;
    private String publicationDate;
    private String language;
    private String status;
    private String thumbnail;
    private Long favorites;
    private Long views;
}
