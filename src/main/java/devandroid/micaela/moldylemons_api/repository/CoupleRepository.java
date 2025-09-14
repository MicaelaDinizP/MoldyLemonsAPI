package devandroid.micaela.moldylemons_api.repository;

import devandroid.micaela.moldylemons_api.model.Couple;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CoupleRepository extends JpaRepository<Couple, Long> {
    Optional<Couple> findByEmail(String email);
}