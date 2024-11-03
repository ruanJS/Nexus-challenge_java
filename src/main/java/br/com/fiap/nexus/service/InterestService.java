package br.com.fiap.nexus.service;

import br.com.fiap.nexus.dto.InterestDTO;
import br.com.fiap.nexus.exception.ResourceNotFoundException;
import br.com.fiap.nexus.model.Interest;
import br.com.fiap.nexus.repository.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InterestService {

    @Autowired
    private InterestRepository interestRepository;

    public List<InterestDTO> getAllInterests() {
        return interestRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public InterestDTO getInterestById(Long id) {
        Interest interest = interestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Interest not found for this id :: " + id));
        return convertToDTO(interest);
    }

    public InterestDTO createInterest(InterestDTO interestDTO) {
        Interest interest = new Interest();
        interest.setName(interestDTO.getName());
        interestRepository.save(interest);
        return convertToDTO(interest);
    }

    public InterestDTO updateInterest(Long id, InterestDTO interestDTO) {
        Interest interest = interestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Interest not found for this id :: " + id));
        interest.setName(interestDTO.getName());
        interestRepository.save(interest);
        return convertToDTO(interest);
    }

    public void deleteInterest(Long id) {
        Interest interest = interestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Interest not found for this id :: " + id));
        interestRepository.delete(interest);
    }

    private InterestDTO convertToDTO(Interest interest) {
        InterestDTO interestDTO = new InterestDTO();
        interestDTO.setName(interest.getName());
        return interestDTO;
    }
}
