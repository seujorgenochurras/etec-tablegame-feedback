package io.github.seujorgenochurras.service;

import io.github.seujorgenochurras.domain.Vote;
import io.github.seujorgenochurras.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    public Vote save(Vote vote) {
        return voteRepository.save(vote);
    }

    public List<Vote> getVotesAverageByClass(String voteClass) {
        var votes = voteRepository.findDintinct();
        HashSet<Vote> newVotes = new HashSet<>();

        votes.forEach(vote -> newVotes.add(new Vote()
                        .setId(0)
                        .setVoteClass(voteClass)
                        .setTablegame(vote.replace(".png", ""))
                        .setFeedback(voteRepository.findAverageFeedbackByTablegame(vote))));
        System.out.println(newVotes);
        return newVotes.stream().sorted((vote2, vote1) -> vote1.feedback().compareTo(vote2.feedback())).toList();
    }
}
