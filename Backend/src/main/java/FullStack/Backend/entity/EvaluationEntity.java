package FullStack.Backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "évaluations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EvaluationEntity {
    @Id
    @GeneratedValue()
    private Integer id;

    @Column(name = "nom", columnDefinition = "varchar(50)", nullable = false)
    private String nom;

    @Column(name = "texte", columnDefinition = "varchar(255)", nullable = false)
    private String texte;

    @Column(name = "note", columnDefinition = "INT", nullable = false)
    private Integer note;

    @Column(name = "date_créa", columnDefinition = "varchar(50)", nullable = false)
    private String  date_créa;

    @Column(name = "date_MAJ", columnDefinition = "varchar(50)", nullable = false)
    private String date_MAJ;

    @ManyToOne()
    @JoinColumn(name = "restaurant_id")
    private RestaurantEntity restaurant;

}
