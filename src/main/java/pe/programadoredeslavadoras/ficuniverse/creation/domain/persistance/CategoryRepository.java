package pe.programadoredeslavadoras.ficuniverse.creation.domain.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.programadoredeslavadoras.ficuniverse.creation.domain.model.entities.Category;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
}
