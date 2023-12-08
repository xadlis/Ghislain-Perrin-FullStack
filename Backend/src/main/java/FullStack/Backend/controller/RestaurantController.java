package FullStack.Backend.controller;

import FullStack.Backend.dto.response.RestaurantDTO;
import FullStack.Backend.service.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<RestaurantDTO> getRestaurant(@RequestParam(value = "id", required = false) ArrayList<Integer> idsToFetch) {
        if (idsToFetch == null || idsToFetch.isEmpty()) {
            return this.restaurantService.getRestaurants().stream().map(restaurantEntity -> RestaurantDTO.buildFromEntity(restaurantEntity)).toList();
        } else {
            return this.restaurantService.getRestaurants(idsToFetch).stream().map(restaurantEntity -> RestaurantDTO.buildFromEntity(restaurantEntity)).toList();
        }
    }

    @PostMapping("/restaurants")
    public RestaurantDTO addRestauranr(@Valid @RequestBody RestaurantDTO restaurantDTO) {
        return RestaurantDTO.buildFromEntity(this.restaurantService.addRestaurant(restaurantDTO));
    }

    @GetMapping("/restaurant/{id}/cover")
    public String getLivreCoverById(@PathVariable Integer id) {
        return this.restaurantService.getRestaurantCoverDownloadUrl(id);
    }

    @PutMapping("/restaurant/{id}/cover")
    public String putLivreCoverById(@PathVariable Integer id) {
        return this.restaurantService.putRestaurantDownloadUrl(id);
    }


}
