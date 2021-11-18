package com.csci4050.movie.api.promotion;

import com.csci4050.movie.api.CodeGenerator;
import com.csci4050.movie.api.model.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PromotionService {
    @Autowired
    private PromotionRepository promotionRepository;

    @Autowired
    private CodeGenerator codeGenerator;

    public Optional<Promotion> addPromotion(Promotion promotion) {
        Promotion newPromo = promotion;
        newPromo.setPcode(codeGenerator.generatePromo());
        return Optional.of(promotionRepository.save(newPromo));
    }
}
