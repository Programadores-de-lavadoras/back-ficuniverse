package pe.programadoredeslavadoras.ficuniverse.profile.domain.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.programadoredeslavadoras.ficuniverse.profile.domain.model.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    Profile findByEmail(String profile_email);
    boolean existsByEmail(String profile_email);
}
