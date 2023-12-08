package FullStack.Backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "évaluations_fin")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvaluationFinaleEntity {
    @Id
    @GeneratedValue()
    private Integer id;

    @Column(name = "nom", columnDefinition = "varchar(50)", nullable = false)
    private String nom;

    @Column(name = "note", columnDefinition = "INT", nullable = false)
    private Integer note;

    @Column(name = "texte", columnDefinition = "TEXT", nullable = false)
    private String texte;

    @OneToOne()
    @JoinColumn(name = "restaurants")
    private RestaurantEntity restaurants;
}
