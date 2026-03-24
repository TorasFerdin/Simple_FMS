package dev.cris97.fms.services;
import dev.cris97.fms.models.Food;
import dev.cris97.fms.models.FoodDTO;
import dev.cris97.fms.repositories.FoodRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public FoodServiceImpl(FoodRepository foodRepository){
        this.foodRepository = foodRepository;
    }


    @Override
    public FoodDTO create(FoodDTO dto) {
        Food food = new Food();
        mapToEntity(dto, food);
        Food foodSaved = foodRepository.save(food);
        entityManager.refresh(foodSaved);
        return mapToDto(foodSaved);
    }

    @Override
    public List<FoodDTO> findAll() {
        return foodRepository.findAll().stream().map((Food f) -> this.mapToDto(f)).toList();
    }

    @Override
    public Optional<FoodDTO> findByUuid(String uuid) {
        /*Food food = foodRepository.findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException("Food not found"));
        return mapToDto(food);*/

//        return foodRepository.findByUuid(uuid).map(this::mapToDto);
        return foodRepository.findByUuid(uuid).map((Food f) -> this.mapToDto(f));
    }

    @Override
    public Optional<FoodDTO> update(String uuid, FoodDTO dto) {
        Optional<Food> foodOpt = foodRepository.findByUuid(uuid);

        if(foodOpt.isEmpty())
            return Optional.empty();

        Food food = foodOpt.get();
        mapToEntity(dto, food);

        // SAVE è entity managed

        return Optional.of(mapToDto(food));
    }

    @Override
    public boolean delete(String uuid) {
        Optional<Food> food = foodRepository.findByUuid(uuid);

        if(food.isEmpty())
            return false;

        foodRepository.delete(food.get());
        return true;
    }


    // MAPPING
    private FoodDTO mapToDto(Food food){
        FoodDTO dto = new FoodDTO();
        dto.setUuid(food.getUuid());
        dto.setName(food.getName());
        dto.setCateg(food.getCategory());
        dto.setCalor(food.getCalories());
        dto.setPric(food.getPrice());
        dto.setAvaila(food.isAvailable());
        dto.setExpi(food.getExpirationDate());
        dto.setCreat(food.getCreatedAt());
        return dto;
    }

    private void mapToEntity(FoodDTO dto, Food food){
        // UUID non deve essere toccato!
        food.setName(dto.getName());
        food.setCategory(dto.getCateg());
        food.setCalories(dto.getCalor());
        food.setPrice(dto.getPric());
        food.setAvailable(dto.isAvaila());
        food.setExpirationDate(dto.getExpi());
        // Created At non deve essere toccato!
    }
}