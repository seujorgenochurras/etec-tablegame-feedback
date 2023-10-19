package io.github.seujorgenochurras.service;

import io.github.seujorgenochurras.domain.Vote;
import io.github.seujorgenochurras.repository.VoteRepository;
import jakarta.validation.executable.ValidateOnExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;


    public Vote save(Vote vote){
        return voteRepository.save(vote);
    }
}
