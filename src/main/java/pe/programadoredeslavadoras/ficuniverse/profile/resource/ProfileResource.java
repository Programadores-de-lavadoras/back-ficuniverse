package pe.programadoredeslavadoras.ficuniverse.profile.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileResource {
    private Integer id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String imageUrl;
}
