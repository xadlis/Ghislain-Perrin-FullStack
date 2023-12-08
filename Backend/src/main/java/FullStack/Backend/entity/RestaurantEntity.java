package FullStack.Backend.entity;

import FullStack.Backend.dto.response.TagDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "restaurant")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantEntity {

    @Id
    @GeneratedValue()
    private Integer id;

    @Column(name = "nom", columnDefinition = "varchar(90)", nullable = false)
    private String nom;

    @Column(name = "adresse", columnDefinition = "varchar(255)", nullable = false)
    private String adresse;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<EvaluationEntity> evaluations;

    @Column(name = "évaluation_moy", columnDefinition = "FLOAT")
    private float evaluation_moy;

    @OneToOne(mappedBy = "restaurants")
    private EvaluationFinaleEntity evaluation_fin;

    @ManyToMany(mappedBy = "restaurants")
    private List<TagEntity> tags;




}
