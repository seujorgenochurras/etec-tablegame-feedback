package io.github.seujorgenochurras.etecfeedbackapi.service;

import io.github.seujorgenochurras.etecfeedbackapi.domain.Vote;
import io.github.seujorgenochurras.etecfeedbackapi.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    public Vote save(Vote vote) {
        return voteRepository.save(vote);
    }

    public List<Vote> getVotesAverageByClass(String voteClass) {
        System.out.println(voteClass);
        var votes = voteRepository.findByVoteClass(voteClass);
        System.out.println(votes);
        HashSet<Vote> newVotes = new HashSet<>();

        votes.forEach(vote -> {

            newVotes.add(new Vote()
                            .setId(0)
                    .setVoteClass(voteClass)
                    .setTablegame(vote.tablegame().replace(".png", ""))
                    .setFeedback(2));
        });

        System.out.println(newVotes);
        return newVotes.stream().sorted((vote1, vote2) -> vote1.feedback().compareTo(vote2.feedback())).toList();
    }
}
