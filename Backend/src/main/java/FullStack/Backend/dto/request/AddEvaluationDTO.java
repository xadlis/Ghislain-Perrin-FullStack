package FullStack.Backend.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddEvaluationDTO {
    @JsonProperty("nom")
    private String nom;

    @JsonProperty("texte")
    private String texte;

    @JsonProperty("note")
    private Integer note;

    @JsonProperty("date_créa")
    private String date_crea;

    @JsonProperty("date_MAJ")
    private String date_MAJ;
}
