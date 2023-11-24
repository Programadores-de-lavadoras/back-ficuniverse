package pe.programadoredeslavadoras.ficuniverse.fanfic.domain.model.entitie;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "fanfics")
public class Fanfic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 50)
    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name = "author", length = 50, nullable = false)
    private String author;


    @Column(name = "summary", columnDefinition = "TEXT", nullable = false)
    private String summary;

    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "publication_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date publicationDate;

    @Size(min = 4, max = 20)
    @Column(name = "language")
    private String language;

    @Size(min = 5, max = 30)
    @Column(name = "status", nullable = false)
    private String status;


    @Column(name = "thumbnail", nullable = false)
    private String thumbnail;

    @Column(name = "favorites")
    private Long favorites;

    @Column(name = "views")
    private Long views;

}
