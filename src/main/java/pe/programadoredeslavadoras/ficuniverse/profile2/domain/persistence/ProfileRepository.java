package pe.programadoredeslavadoras.ficuniverse.profile2.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.programadoredeslavadoras.ficuniverse.profile2.domain.model.entity.Profile;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile,Integer> {
    public boolean existsById(Integer id);
    Optional<Profile> findByUserName(String userName);
}
