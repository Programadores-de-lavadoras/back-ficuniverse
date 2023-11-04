package pe.programadoredeslavadoras.ficuniverse.creation.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "fanfics")
public class Fanfic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 50)
    @Column(name= "title", length = 50, nullable = false)
    private String title;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 70000)
    @Column(name= "content", length = 70000, nullable = false)
    private String summary;

    @OneToMany(mappedBy = "fanfic")
    private List<Chapter> chapters;

}
