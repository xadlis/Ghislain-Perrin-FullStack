package FullStack.Backend.service;

import FullStack.Backend.dto.request.AddEvaluationDTO;
import FullStack.Backend.entity.EvaluationEntity;
import FullStack.Backend.entity.RestaurantEntity;
import FullStack.Backend.repository.EvaluationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EvaluationService {
    private final EvaluationRepository evaluationRepository;
    private final RestaurantService restaurantService;

    public EvaluationEntity addEvaluationToRestaurant(final Integer restaurantId, final AddEvaluationDTO dto)
    {
        final RestaurantEntity restaurant = this.restaurantService.getRestaurantById(restaurantId);

        final EvaluationEntity evaluation = EvaluationEntity.builder()
                .nom(dto.getNom())
                .texte(dto.getTexte())
                .note(dto.getNote())
                .date_créa(dto.getDate_crea())
                .date_MAJ(dto.getDate_MAJ())
                .restaurant(restaurant)
                .build();

        return this.evaluationRepository.save(evaluation);
    }

    public List<EvaluationEntity> getEvaluation()
    {
        return this.evaluationRepository.findAll();
    }

    public List<EvaluationEntity> getEvaluation(final List<Integer> idsToFetch) {
        return this.evaluationRepository.findAllById(idsToFetch);
    }
}
