package dev.cris97.fms.services;
import dev.cris97.fms.models.FoodDTO;
import java.util.List;
import java.util.Optional;


public interface FoodService {

    FoodDTO create(FoodDTO dto);

    List<FoodDTO> findAll();

    Optional<FoodDTO> findByUuid(String uuid);

    Optional<FoodDTO> update(String uuid, FoodDTO dto);

    boolean delete(String uuid);
}
