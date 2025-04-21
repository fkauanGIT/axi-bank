package com.project.axibank.controller;

import com.project.axibank.model.Cards;
import com.project.axibank.repository.CardsRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Cartões", description = "Consulta de cartões do cliente")
public class CardsController {

    private final CardsRepository cardsRepository;

    @Operation(
            summary = "Obter informações dos cartões",
            description = "Retorna todos os cartões vinculados ao cliente de acordo com o ID fornecido."
    )
    @GetMapping("/myCards")
    public List<Cards> getCardDetails(@RequestParam long id) {
        List<Cards> cards = cardsRepository.findByCustomerId(id);
        if (cards != null ) {
            return cards;
        }else {
            return null;
        }
    }

}
