package dev.cris97.fms.controllers;
import dev.cris97.fms.models.FoodDTO;
import dev.cris97.fms.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;


@RestController
@RequestMapping("/api/foods")
//@CrossOrigin(origins = "http://127.0.0.1:5500")
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService){
        this.foodService = foodService;
    }

    @GetMapping("/{uuid}")
    public FoodDTO findByUuid(@PathVariable String uuid){
        return foodService.findByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<FoodDTO> findAll(){
        return foodService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FoodDTO create(@RequestBody FoodDTO dto){
        return foodService.create(dto);
    }

    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String uuid){
        boolean deleted = foodService.delete(uuid);

        if(!deleted)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{uuid}")
    public FoodDTO update(@PathVariable String uuid, @RequestBody FoodDTO dto){
        return foodService.update(uuid, dto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
