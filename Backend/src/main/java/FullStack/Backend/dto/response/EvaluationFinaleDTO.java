package FullStack.Backend.dto.response;

import FullStack.Backend.entity.EvaluationFinaleEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationFinaleDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("texte")
    private String texte;

    public static EvaluationFinaleDTO buildFromEntity(EvaluationFinaleEntity evaluationFinaleEntity) {
        return EvaluationFinaleDTO.builder()
                .id(evaluationFinaleEntity.getId())
                .nom(evaluationFinaleEntity.getNom())
                .texte(evaluationFinaleEntity.getTexte())
                .build();
    }
}
