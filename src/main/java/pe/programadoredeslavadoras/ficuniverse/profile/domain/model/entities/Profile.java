package pe.programadoredeslavadoras.ficuniverse.profile.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@With
@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 50)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 50)
    private String lastName;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 15)
    @Column(name = "user_name", nullable = false, length = 100)
    private String userName;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 50)
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @NotNull
    @Size(min = 1)
    @Column(name = "user_name", nullable = false, length = 100)
    private String imageUrl;
}
