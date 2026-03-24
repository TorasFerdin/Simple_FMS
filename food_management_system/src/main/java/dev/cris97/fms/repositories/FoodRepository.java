package dev.cris97.fms.repositories;
import dev.cris97.fms.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


//@Repository  // non serve definirlo come bean poiché lo è già grazie alla definizione di estensione di JpaRepository
public interface FoodRepository extends JpaRepository<Food, Long> {

    Optional<Food> findByUuid(String uuid);

    void deleteByUuid(String uuid);

    boolean existsByUuid(String uuid);
}
