package pe.programadoredeslavadoras.ficuniverse.security.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserResource {
    private String userName;
    private String email;
    private String password;
    private String role;
}
