package FullStack.Backend.dto.response;

import FullStack.Backend.entity.EvaluationEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("texte")
    private String texte;

    @Min(0)
    @Max(3)
    @JsonProperty("note")
    private Integer note;

    @JsonProperty("date_création")
    private String date_creation;

    @JsonProperty("date_MAJ")
    private String date_MAJ;

    @JsonProperty("restaurant")
    private RestaurantDTO restaurant;

    public static EvaluationDTO buildFromEntity(EvaluationEntity evaluationEntity) {
        return EvaluationDTO.builder()
                .id(evaluationEntity.getId())
                .nom(evaluationEntity.getNom())
                .texte(evaluationEntity.getTexte())
                .note(evaluationEntity.getNote())
                .date_creation(evaluationEntity.getDate_créa())
                .date_MAJ(evaluationEntity.getDate_MAJ())
                .build();
    }

}
