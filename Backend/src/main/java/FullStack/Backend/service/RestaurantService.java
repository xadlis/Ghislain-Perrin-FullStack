package FullStack.Backend.service;

import FullStack.Backend.dto.response.RestaurantDTO;
import FullStack.Backend.entity.RestaurantEntity;
import FullStack.Backend.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final S3Service s3Service;

    public List<RestaurantEntity> getRestaurants()
    {
        return this.restaurantRepository.findAll();
    }

    public List<RestaurantEntity> getRestaurants(final List<Integer> idsToFetch) {
        return this.restaurantRepository.findAllById(idsToFetch);
    }

    public RestaurantEntity getRestaurantById(final Integer id) {
        return this.restaurantRepository.findById(id).orElseThrow(() -> new ResolutionException("Livre with id " + id + " + not found"));
    }

    public RestaurantEntity addRestaurant(final RestaurantDTO restaurantDTO)
    {
        final RestaurantEntity restaurantToInsert = RestaurantEntity.builder()
                .nom(restaurantDTO.getNom())
                .adresse((restaurantDTO.getAdresse()))
                .build();

        return this.restaurantRepository.save(restaurantToInsert);
    }

    public String getRestaurantCoverDownloadUrl(final Integer restaurantId) {
        this.getRestaurantById(restaurantId);

        return this.s3Service.getRestaurantDownloadUrl("LeCameleon" + restaurantId);
    }

    public String putRestaurantDownloadUrl(final Integer restaurantId) {
        this.getRestaurantById(restaurantId);

        return this.s3Service.putRestaurantDownloadUrl("LeCameleon" + restaurantId);
    }

}
