package io.github.seujorgenochurras.etecfeedbackapi.service;

import io.github.seujorgenochurras.etecfeedbackapi.domain.Vote;
import io.github.seujorgenochurras.etecfeedbackapi.repository.VoteRepository;
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
