package pe.programadoredeslavadoras.ficuniverse.creation.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "chapters")
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name= "title", length = 30)
    private String title;
    @Column(name= "content")
    private String content;


}
