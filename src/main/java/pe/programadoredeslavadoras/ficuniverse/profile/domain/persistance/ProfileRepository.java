package pe.programadoredeslavadoras.ficuniverse.profile.domain.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.programadoredeslavadoras.ficuniverse.profile.domain.model.entities.Profile;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    @Query(value = "SELECT * FROM profiles WHERE email = :email",nativeQuery = true)
    Optional<Profile> sqlFindByEmail(String profile_email);
    boolean existsByEmail(String profile_email);
}
