package FullStack.Backend.controller;

import FullStack.Backend.dto.request.AddEvaluationDTO;
import FullStack.Backend.dto.response.EvaluationDTO;
import FullStack.Backend.dto.response.RestaurantDTO;
import FullStack.Backend.service.EvaluationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class EvaluationController {

    private final EvaluationService evaluationService;

    @PostMapping("/restaurant/{id}/evaluation")
    public EvaluationDTO addEvaluation(@PathVariable Integer id, @Valid @RequestBody AddEvaluationDTO addEvaluationDTO) {
        return EvaluationDTO.buildFromEntity(this.evaluationService.addEvaluationToRestaurant(id, addEvaluationDTO));
    }

    @GetMapping("/evaluations")
    public List<EvaluationDTO> getRestaurant(@RequestParam(value = "id", required = false) ArrayList<Integer> idsToFetch) {
        if (idsToFetch == null || idsToFetch.isEmpty()) {
            return this.evaluationService.getEvaluation().stream().map(evaluationEntity -> EvaluationDTO.buildFromEntity(evaluationEntity)).toList();
        } else {
            return this.evaluationService.getEvaluation(idsToFetch).stream().map(evaluationEntity -> EvaluationDTO.buildFromEntity(evaluationEntity)).toList();
        }
    }
}
