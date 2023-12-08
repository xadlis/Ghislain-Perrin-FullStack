package FullStack.Backend.dto.response;


import FullStack.Backend.entity.EvaluationEntity;
import FullStack.Backend.entity.RestaurantEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("adresse")
    private String adresse;

    @JsonProperty("évaluation")
    private List<EvaluationDTO> evaluations;

    @JsonProperty("évaluation_moy")
    private float evaluation_moy;

    @JsonProperty("évaluation_fin")
    private EvaluationFinaleDTO evaluation_fin;

    @JsonProperty("tags")
    private List<TagDTO> tags;

    public static RestaurantDTO buildFromEntity(RestaurantEntity restaurantEntity) {
        return RestaurantDTO.builder()
                .id(restaurantEntity.getId())
                .nom(restaurantEntity.getNom())
                .adresse(restaurantEntity.getAdresse())
                .build();
    }
}
