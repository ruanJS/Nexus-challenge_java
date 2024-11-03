package br.com.fiap.nexus.service;

import org.springframework.stereotype.Service;

@Service
public class RecommendationService {

    public String recommendToy(String userId) {
        // Implement logic for AI recommendation, e.g., using a model
        return "Recommended Toy for user " + userId;
    }
}