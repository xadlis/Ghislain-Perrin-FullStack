package FullStack.Backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "tag")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TagEntity {

    @Id
    @Column(name = "nom", columnDefinition = "varchar(90)", nullable = false)
    private String nom;

    @ManyToMany
    @JoinTable(name = "tags_in_restaurant",
            joinColumns = @JoinColumn(name = "tag"),
            inverseJoinColumns = @JoinColumn(name = "restaurant"))
    private List<RestaurantEntity> restaurants;
}
