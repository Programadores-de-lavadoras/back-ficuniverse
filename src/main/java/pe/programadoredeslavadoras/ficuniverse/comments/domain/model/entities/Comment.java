package pe.programadoredeslavadoras.ficuniverse.comments.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="users", length = 20, nullable = false)
    private String user;

    @Column(name="content", length = 120, nullable = false)
    private String content;

    @Column(name="publication_date", length = 120, nullable = false)
    private Date publication_Date;
}
